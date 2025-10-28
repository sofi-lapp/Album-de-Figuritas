package com.AlbumDeFigurita.demo.premios;

public class PremioDisponible implements IEstadoPremio {
    @Override
    public void reclamarPremio(PremioContext contexto) {
        System.out.println("Premio reclamado exitosamente.");
        contexto.setEstado(new PremioReclamado());
    }

    @Override
    public String getNombreEstado() {
        return "PREMIO_DISPONIBLE";
    }
}
