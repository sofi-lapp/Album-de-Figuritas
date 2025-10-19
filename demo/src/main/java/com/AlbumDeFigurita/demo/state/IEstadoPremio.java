package com.AlbumDeFigurita.demo.state;
import com.AlbumDeFigurita.demo.entity.Reward;
import com.AlbumDeFigurita.demo.entity.User;

public interface IEstadoPremio {
    void reclamar(Reward premio, User usuario);
}
