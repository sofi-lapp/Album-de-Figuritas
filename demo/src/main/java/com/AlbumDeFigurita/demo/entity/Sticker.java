package com.AlbumDeFigurita.demo.entity;
import com.AlbumDeFigurita.demo.enums.Rareza;

import jakarta.persistence.*;

@Entity
@Table(name = "stickers", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"numero", "album_id"})
})
public class Sticker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre de la figurita. */
    @Column(nullable = false)
    private String nombre;

    /** Número dentro del álbum (único por álbum). */
    @Column(nullable = false)
    private Integer numero;
    @Enumerated(EnumType.STRING) //para el state
    private Rareza rareza;
    private boolean pegada;

    /** Relación: a qué álbum pertenece la figurita. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;
    /** Control de stock total. */
    @Column(nullable = false)
    private Integer stockTotal;
    /** Stock disponible (no puede ir en negativo). */
    @Column(nullable = false)
    private Integer stockDisponible;
    /** URL o path de la imagen de la figurita. */
    @Column(nullable = false)
    private String imageUrl;
    
    // Constructores    
    public Sticker() {
    }

    public Sticker(Long id, String nombre, Integer numero, Rareza rareza, Album album,
                   Integer stockTotal, Integer stockDisponible, String imageUrl) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.rareza = rareza;
        this.album = album;
        this.stockTotal = stockTotal;
        this.stockDisponible = stockDisponible;
        this.imageUrl = imageUrl;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public Album getAlbum() { return album; }
    public void setAlbum(Album album) { this.album = album; }
    public Rareza getRareza() {return rareza;}
    public void setRareza(Rareza rareza) {this.rareza = rareza;}
    public boolean isPegada() { return pegada; }
    public void setPegada(boolean pegada) { this.pegada = pegada; }
    public Integer getStockTotal() {return stockTotal;}
    public void setStockTotal(Integer stockTotal) {this.stockTotal = stockTotal;}
    public Integer getStockDisponible() {return stockDisponible;}
    public void setStockDisponible(Integer stockDisponible) {this.stockDisponible = stockDisponible;}
    public String getImageUrl() {return imageUrl;}
    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}

}