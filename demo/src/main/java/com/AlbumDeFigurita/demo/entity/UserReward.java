package com.AlbumDeFigurita.demo.entity;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "user_rewards",
       uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "album_id"}))
public class UserReward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Usuario dueño del premio
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    // Álbum por el cual se obtuvo el premio
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "album_id")
    private Album album;

    // Estado del premio: disponible o ya reclamado
    @Enumerated(EnumType.STRING)
    private RewardStatus status = RewardStatus.AVAILABLE;

    // Fecha en que fue reclamado (null si aún está disponible)
    private Instant claimedAt;
    // Versión para control de concurrencia
    @Version
    private Long version;

    // state
    public enum RewardStatus { AVAILABLE, CLAIMED }

    // Constructores
    public UserReward() {
    }

    public UserReward(Long id, User user, Album album, RewardStatus status, Instant claimedAt, Long version) {
        this.id = id;
        this.user = user;
        this.album = album;
        this.status = status;
        this.claimedAt = claimedAt;
        this.version = version;
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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public RewardStatus getStatus() {
        return status;
    }

    public void setStatus(RewardStatus status) {
        this.status = status;
    }

    public Instant getClaimedAt() {
        return claimedAt;
    }

    public void setClaimedAt(Instant claimedAt) {
        this.claimedAt = claimedAt;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
