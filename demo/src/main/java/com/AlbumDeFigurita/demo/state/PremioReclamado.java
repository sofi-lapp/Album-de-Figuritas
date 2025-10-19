package com.AlbumDeFigurita.demo.state;

import com.AlbumDeFigurita.demo.entity.Reward;
import com.AlbumDeFigurita.demo.entity.User;

public class PremioReclamado implements IEstadoPremio {

    @Override
    public void reclamar(Reward premio, User usuario) {
        System.out.println("El premio ya fue reclamado. Lo sentimos, No puede volver a reclamarse :(");
    }
}
