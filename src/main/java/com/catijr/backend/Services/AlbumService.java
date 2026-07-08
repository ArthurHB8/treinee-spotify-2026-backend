package com.catijr.backend.Services;

import com.catijr.backend.Entities.Album;
import com.catijr.backend.Entities.Music;
import com.catijr.backend.Repositories.AlbumRepository;
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
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final LocalImageStorage imageStorage;

    public List<Music> getMusicsByAlbumId(UUID albumId) {
        var album = albumRepository.findById(albumId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return album.getMusics();
    }

    public Album getAlbumById(UUID albumId) {
        return albumRepository.findById(albumId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Album setAlbumImage(UUID albumId, MultipartFile file) {
        var album = albumRepository.findById(albumId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        try {
            album.setImagePath(imageStorage.save(file));
        } catch (IOException | NoSuchAlgorithmException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to store image", e);
        }

        return albumRepository.save(album);
    }

}
