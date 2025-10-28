package com.AlbumDeFigurita.demo.premios;

public class PremioContext {
    private IEstadoPremio estado;
    private Premio premio;

    public PremioContext(IEstadoPremio estadoInicial, Premio premio) {
        this.estado = estadoInicial;
        this.premio = premio;
    }

    public void setEstado(IEstadoPremio nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public IEstadoPremio getEstado() {
        return estado;
    }

    public void reclamarPremio() {
        estado.reclamarPremio(this);
    }

    public Premio getPremio() {
        return premio;
    }
}
