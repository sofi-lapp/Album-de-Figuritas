package com.AlbumDeFigurita.demo.entity;
import jakarta.persistence.*;
import java.util.*;
import com.AlbumDeFigurita.demo.observer.IObservador;
import com.AlbumDeFigurita.demo.observer.IObservable;

@Entity
@Table(name = "albums")
public class Album implements IObservable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int totalFiguritas;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Sticker> stickers = new HashSet<>();

    @OneToOne(mappedBy = "album", cascade = CascadeType.ALL)
    private Reward premio;

    @Transient
    private Set<IObservador> observadores = new HashSet<>();

    public Album() {}
    public Album(String id, int totalFiguritas) {
        this.id = nombre;
        this.totalFiguritas = totalFiguritas;
    }

    // Métodos Observer
    @Override
    public void agregarObservador(IObservador observador) { observadores.add(observador); }
    @Override
    public void quitarObservador(IObservador observador) { observadores.remove(observador); }
    @Override
    public void notificarObservadores() {
        for (IObservador obs : observadores) obs.actualizar(this);
    }

    // Lógica de dominio
    public double obtenerProgreso() {
        long pegadas = stickers.stream().filter(Sticker::isPegada).count();
        return (double) pegadas / totalFiguritas * 100;
    }

    public void agregarSticker(Sticker sticker) {
        sticker.setAlbum(this);
        stickers.add(sticker);
        notificarObservadores();
    }

    // Getters y setters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public Reward getPremio() { return premio; }
    public void setPremio(Reward premio) { this.premio = premio; }
}