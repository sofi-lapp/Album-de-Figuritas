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
    private String categoria;
    private String creador;
    private int totalFiguritas;
    private boolean publicado;

    @OneToMany(mappedBy = "album")
    private List<Sticker> stickers;

    @OneToOne(mappedBy = "album")
    private Reward reward;

    public enum Dificultad { FACIL, MEDIA, DIFICIL }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getCreador() { return creador; }
    public void setCreador(String creador) { this.creador = creador; }
    public int getTotalFiguritas() { return totalFiguritas; }
    public void setTotalFiguritas(int totalFiguritas) { this.totalFiguritas = totalFiguritas; }
    public boolean isPublicado() { return publicado; }
    public void setPublicado(boolean publicado) { this.publicado = publicado; }
    public List<Sticker> getStickers() { return stickers; }
    public void setStickers(List<Sticker> stickers) { this.stickers = stickers; }
    public Reward getReward() { return reward; }
    public void setReward(Reward reward) { this.reward = reward; }
}
