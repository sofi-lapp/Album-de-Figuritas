package com.AlbumDeFigurita.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    private String nombre;
    private String apellido;

    /** Fecha de creación automática. */
    private Instant createdAt = Instant.now();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserSticker> stickers;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserReward> rewards;

    // Constructor 
    public User() {}
    public User(Long id, String username, String email, String nombre, String apellido, Instant createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.createdAt = createdAt;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) {this.apellido = apellido;}
    public Instant getCreatedAt() { return createdAt;}
    public void setCreatedAt(Instant createdAt) {this.createdAt = createdAt;}
    public List<UserSticker> getStickers() {return stickers;}
    public void setStickers(List<UserSticker> stickers) {this.stickers = stickers;}
    public List<UserReward> getRewards() {return rewards;}
    public void setRewards(List<UserReward> rewards) {this.rewards = rewards;}
}