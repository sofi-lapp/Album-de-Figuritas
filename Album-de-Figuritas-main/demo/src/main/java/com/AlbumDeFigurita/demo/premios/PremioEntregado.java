package com.AlbumDeFigurita.demo.premios;

public class PremioEntregado implements IEstadoPremio {
    @Override
    public void reclamarPremio(PremioContext contexto) {
        throw new IllegalStateException("El premio ya fue ENTREGADO. No se puede reclamar nuevamente.");
    }

    @Override
    public String getNombreEstado() {
        return "PREMIO_ENTREGADO";
    }
}
