package com.catijr.backend.DTOs.Artist;

import com.catijr.backend.Entities.Artist;
import com.catijr.backend.Storage.LocalImageStorage;

import java.time.Instant;
import java.util.UUID;

public record GetArtistDTO(UUID id, String name, int listeners, String about, String imageUrl,
    Instant createdAt, Instant updatedAt
){

    public GetArtistDTO(Artist artist){
        this(
            artist.getId(),
            artist.getName(),
            artist.getListeners(),
            artist.getAbout(),
            LocalImageStorage.toUrl(artist.getImagePath()),
            artist.getCreatedAt(),
            artist.getUpdatedAt()

        );
    }
}