package com.AlbumDeFigurita.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "user_stickers",
       uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "sticker_id"}))
public class UserSticker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Usuario dueño de la figurita. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    /** Figurita asociada. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sticker_id")
    private Sticker sticker;

    /** Cantidad de copias que tiene el usuario. */
    @Column(nullable = false)
    private Integer cantidad = 1;

    /** Estado de la figurita (ej: EN_COLECCION, EN_INTERCAMBIO). */
    @Column(nullable = false)
    private String estado = "EN_COLECCION";

    /** Fecha en que fue obtenida. */
    private Instant acquiredAt = Instant.now();

    // ---------------------------
    // Constructores
    // ---------------------------

    public UserSticker() {
    }

    public UserSticker(Long id, User user, Sticker sticker, Integer cantidad, String estado, Instant acquiredAt) {
        this.id = id;
        this.user = user;
        this.sticker = sticker;
        this.cantidad = cantidad;
        this.estado = estado;
        this.acquiredAt = acquiredAt;
    }

    // ---------------------------
    // Getters y Setters
    // ---------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Sticker getSticker() {
        return sticker;
    }

    public void setSticker(Sticker sticker) {
        this.sticker = sticker;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Instant getAcquiredAt() {
        return acquiredAt;
    }

    public void setAcquiredAt(Instant acquiredAt) {
        this.acquiredAt = acquiredAt;
    }
}
