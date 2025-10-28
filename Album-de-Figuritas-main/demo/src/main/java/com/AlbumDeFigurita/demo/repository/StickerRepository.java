package com.AlbumDeFigurita.demo.repository;

import com.AlbumDeFigurita.demo.entity.Sticker;
import java.util.List;

public interface StickerRepository {
    List<Sticker> findByAlbumId(Long albumId);
    List<Sticker> findAllById(List<Long> ids);
}