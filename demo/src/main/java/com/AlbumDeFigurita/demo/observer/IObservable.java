package com.AlbumDeFigurita.demo.observer;

public interface IObservable {
    void agregarObservador(IObservador observador);
    void quitarObservador(IObservador observador);
    void notificarObservadores();
}
