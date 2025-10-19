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
    
    public UserSticker() {
    }

    public UserSticker(Long id, User user, Sticker sticker, Integer cantidad, String estado, Instant acquiredAt) {
        this.id = id;
        this.user = user;
        this.sticker = sticker;
    }
    // Getters & setters
    public void setUsuario(User usuario) { this.user = user; }
    public Sticker getSticker() { return sticker; }
}
