package com.AlbumDeFigurita.demo.entity;
import jakarta.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

import com.AlbumDeFigurita.demo.enums.EstadoPremio;

@Entity
@Table(name = "user_rewards",
       uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "album_id"}))
public class UserReward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "premio_id")
    private Reward premio;

    @Enumerated(EnumType.STRING)
    private EstadoPremio estado;

    private LocalDateTime claimedAt;

    @Version
    private Long version;

    // Getters & setters
    public void setEstado(EstadoPremio estado) { this.estado = estado; }
    public EstadoPremio getEstado() { return estado; }
}   