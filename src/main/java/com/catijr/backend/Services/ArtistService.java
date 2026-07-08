package com.catijr.backend.Services;


import com.catijr.backend.Entities.Album;
import com.catijr.backend.Entities.Artist;
import com.catijr.backend.Entities.Music;
import com.catijr.backend.Repositories.ArtistRepository;
import com.catijr.backend.Storage.LocalImageStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final LocalImageStorage imageStorage;
    //private MusicRepository musicRepository;

    public List<Music> getPopularMusicsByArtistId(UUID artistId) {
        var artist = artistRepository.findById(artistId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        List<Music> pop = artist.getSongs();

        pop.sort((m1, m2) -> Integer.compare(m1.getTimesListen(), m2.getTimesListen()));

        return pop;
    }

    public List<Album> getAlbumsByArtistId(UUID artistId) {
        var artist = artistRepository.findById(artistId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return artist.albums;
    }

    public Artist getArtistById(UUID artistId) {
        return artistRepository.findById(artistId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Artist setArtistImage(UUID artistId, MultipartFile file) {
        var artist = artistRepository.findById(artistId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        try {
            artist.setImagePath(imageStorage.save(file));
        } catch (IOException | NoSuchAlgorithmException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to store image", e);
        }

        return artistRepository.save(artist);
    }
}
