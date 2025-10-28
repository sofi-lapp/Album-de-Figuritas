package com.AlbumDeFigurita.demo.service;

import com.AlbumDeFigurita.demo.entity.Sticker;
import com.AlbumDeFigurita.demo.entity.UserSticker;
import com.AlbumDeFigurita.demo.repository.StickerRepository;
import com.AlbumDeFigurita.demo.repository.UserStickerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * RF4: Colección personal (ver colección, faltantes, duplicadas, progreso)
 */
@Service
public class ColeccionService {

    private final StickerRepository figuritaRepo;
    private final UserStickerRepository usuarioFiguritaRepo;
    
    public ColeccionService(StickerRepository figuritaRepo, UserStickerRepository usuarioFiguritaRepo) {
        this.figuritaRepo = figuritaRepo;
        this.usuarioFiguritaRepo = usuarioFiguritaRepo;
    }

    // Figuritas del usuario dentro de un álbum (con cantidades).
    public List<UserSticker> obtenerFiguritasUsuario(Long usuarioId, Long albumId) {
        return usuarioFiguritaRepo.findByUserAndAlbum(usuarioId, albumId);
    }

    // Figuritas faltantes para completar el album.
    public List<Sticker> obtenerFaltantes(Long usuarioId, Long albumId) {
        List<Sticker> todas = figuritaRepo.findByAlbumId(albumId);
        Set<Long> obtenidas = usuarioFiguritaRepo.findByUserAndAlbum(usuarioId, albumId).stream()
                .map(us -> us.getSticker().getId())
                .collect(Collectors.toSet());
        return todas.stream()
                .filter(f -> !obtenidas.contains(f.getId()))
                .toList();
    }

    // Las repetidas 
    public List<Sticker> obtenerRepetidas(Long usuarioId, Long albumId) {
        List<Long> repetidasIds = usuarioFiguritaRepo.findDuplicateStickerIds(usuarioId, albumId);
        return figuritaRepo.findAllById(repetidasIds);
    }

    // % de progreso del álbum 
    public double calcularProgresoAlbum(Long usuarioId, Long albumId) {
        int total = figuritaRepo.findByAlbumId(albumId).size();
        int obtenidas = (int) usuarioFiguritaRepo.findByUserAndAlbum(usuarioId, albumId).stream()
                .map(us -> us.getSticker().getId())
                .distinct()
                .count();
        return total > 0 ? (obtenidas * 100.0 / total) : 0.0;
    }
}