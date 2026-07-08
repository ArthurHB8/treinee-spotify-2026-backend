package com.catijr.backend.DTOs.Album;

import com.catijr.backend.Entities.Album;
import com.catijr.backend.Storage.LocalImageStorage;

import java.time.Instant;
import java.util.UUID;

public record GetAlbumNoMusicsDTO(UUID id, String title,
                          String year, UUID artistId,
                          String artistName,
                          String imageUrl,
                          Instant createdAt, Instant updatedAt) {

    public GetAlbumNoMusicsDTO(Album album) {
        this(
                album.getId(),
                album.getTitle(),
                album.getYear(),
                album.getOwner().getId(),
                album.getOwner().getName(),
                LocalImageStorage.toUrl(album.getImagePath()),
                album.getCreatedAt(),
                album.getUpdatedAt()
        );
    }

}
