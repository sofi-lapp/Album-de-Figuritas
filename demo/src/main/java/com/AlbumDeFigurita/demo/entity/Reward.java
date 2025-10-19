package com.AlbumDeFigurita.demo.entity;
import com.AlbumDeFigurita.demo.state.IEstadoPremio;
import com.AlbumDeFigurita.demo.state.PremioDisponible;

import jakarta.persistence.*;

@Entity
@Table(name = "rewards")
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id", nullable = false, unique = true)
    private Album album;
    private String descripcion;

    @Transient
    private IEstadoPremio estadoPremio = new PremioDisponible();

    public void reclamar(User usuario) {
        estadoPremio.reclamar(this, usuario);
    }

    public void setEstadoPremio(IEstadoPremio nuevoEstado) {
        this.estadoPremio = nuevoEstado;
    }

    public void setEstadoPremioDisponible() {
        this.estadoPremio = new PremioDisponible();
    }


    public Reward(Long id, Album album, String tipo) {
        this.id = id;
        this.album = album;
    }

    // Getters y Setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Album getAlbum() {return album;}
    public void setAlbum(Album album) {this.album = album;}
    public String getDescripcion() { return descripcion; }
    
}
