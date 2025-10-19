package com.AlbumDeFigurita.demo.observer;
import com.AlbumDeFigurita.demo.entity.Album;


public class NotificadorAlbum implements IObservador {

    @Override
    public void actualizar(Album album) {
        double progreso = album.obtenerProgreso();
        if (progreso >= 100.0) {
            System.out.println("Album completado!! se habilita el premio del album  " + album.getId());
            if (album.getReward() != null) {
                album.getReward().setEstadoPremioDisponible();
            }
        }
    }
}