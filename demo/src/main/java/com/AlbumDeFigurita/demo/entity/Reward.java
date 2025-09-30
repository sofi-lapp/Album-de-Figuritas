package com.AlbumDeFigurita.demo.entity;
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

    // Tipo de premio (ej: COINS, TROPHY, BADGE)
    @Column(nullable = false)
    private String tipo;

    // Información dinámica del premio en formato JSON 
    @Column(columnDefinition = "TEXT")
    private String payloadJson;
    // Constructores
    public Reward() {
    }

    public Reward(Long id, Album album, String tipo, String payloadJson) {
        this.id = id;
        this.album = album;
        this.tipo = tipo;
        this.payloadJson = payloadJson;
    }

    // Getters y Setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Album getAlbum() {return album;}
    public void setAlbum(Album album) {this.album = album;}
    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}
    public String getPayloadJson() {return payloadJson;}
    public void setPayloadJson(String payloadJson) {this.payloadJson = payloadJson;}
}
