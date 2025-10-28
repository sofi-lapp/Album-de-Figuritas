package com.AlbumDeFigurita.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<UserSticker> stickers;

    @OneToMany(mappedBy = "user")
    private List<UserReward> rewards;

    // Constructor vacío
    public User() {}

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<UserSticker> getStickers() { return stickers; }
    public void setStickers(List<UserSticker> stickers) { this.stickers = stickers; }

    public List<UserReward> getRewards() { return rewards; }
    public void setRewards(List<UserReward> rewards) { this.rewards = rewards; }
}