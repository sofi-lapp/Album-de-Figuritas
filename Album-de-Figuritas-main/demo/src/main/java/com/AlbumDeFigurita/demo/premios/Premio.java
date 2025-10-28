package com.AlbumDeFigurita.demo.premios;

public class Premio {
    private String descripcion;
    private IEstadoPremio estado;

    public Premio(String descripcion) {
        this.descripcion = descripcion;
        this.estado = new PremioDisponible(); // estado inicial
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public IEstadoPremio getEstado() { return estado; }
    public void setEstado(IEstadoPremio estado) { this.estado = estado; }

    public void reclamar() {
        PremioContext ctx = new PremioContext(this.estado, this);
        ctx.reclamarPremio();
        this.estado = ctx.getEstado(); // actualizar estado
    }
}
