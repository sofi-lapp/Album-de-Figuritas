package com.AlbumDeFigurita.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private int totalFiguritas;

    @OneToMany(mappedBy = "album")
    private List<Sticker> stickers;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public int getTotalFiguritas() { return totalFiguritas; }
    public void setTotalFiguritas(int totalFiguritas) { this.totalFiguritas = totalFiguritas; }
}
