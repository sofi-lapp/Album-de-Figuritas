package com.AlbumDeFigurita.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stickers")
public class Sticker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int numero;

    @ManyToOne
    private Album album;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public Album getAlbum() { return album; }
    public void setAlbum(Album album) { this.album = album; }
}