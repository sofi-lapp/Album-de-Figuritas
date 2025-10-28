package com.AlbumDeFigurita.demo.repository;

import com.AlbumDeFigurita.demo.entity.UserSticker;
import java.util.List;

public interface UserStickerRepository {
    List<UserSticker> findByUserAndAlbum(Long userId, Long albumId);
    List<Long> findDuplicateStickerIds(Long userId, Long albumId);
}