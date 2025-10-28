package com.AlbumDeFigurita.demo.premios;

public class PremioReclamado implements IEstadoPremio {
    @Override
    public void reclamarPremio(PremioContext contexto) {
        System.out.println("El premio ya fue reclamado. Procediendo a marcar como ENTREGADO.");
        contexto.setEstado(new PremioEntregado());
    }

    @Override
    public String getNombreEstado() {
        return "PREMIO_RECLAMADO";
    }
}
