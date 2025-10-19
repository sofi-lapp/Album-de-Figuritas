package com.AlbumDeFigurita.demo.state;

import com.AlbumDeFigurita.demo.entity.Reward;
import com.AlbumDeFigurita.demo.entity.User;

public class PremioDisponible implements IEstadoPremio {

    @Override
    public void reclamar(Reward premio, User usuario) {
        System.out.println("✅ Premio reclamado por " + usuario.getUsername());
        premio.setEstadoPremio(new PremioReclamado());
    }
}
