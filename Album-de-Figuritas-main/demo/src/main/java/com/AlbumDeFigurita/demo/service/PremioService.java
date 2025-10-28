package com.AlbumDeFigurita.demo.service;

import com.AlbumDeFigurita.demo.premios.*;
import org.springframework.stereotype.Service;

@Service
public class PremioService {

    public void claimReward(Long userId, Long albumId) {
        Premio premio = new Premio("Premio por completar álbum " + albumId);
        PremioContext contexto = new PremioContext(premio.getEstado(), premio);

        try {
            contexto.reclamarPremio();
            System.out.println("✅ Usuario " + userId + " cambió el estado a: " + contexto.getEstado().getNombreEstado());
        } catch (Exception e) {
            System.out.println("⚠️ Error al reclamar el premio: " + e.getMessage());
        }
    }
}