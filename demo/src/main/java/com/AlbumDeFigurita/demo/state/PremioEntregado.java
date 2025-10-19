package com.AlbumDeFigurita.demo.state;

import com.AlbumDeFigurita.demo.entity.Reward;
import com.AlbumDeFigurita.demo.entity.User;

public class PremioEntregado implements IEstadoPremio {

    @Override
    public void reclamar(Reward premio, User usuario) {
        System.out.println("🎁 El premio ya fue entregado al usuario " + usuario.getUsername());
    }
}
