package com.catijr.backend.Mappers;

import com.catijr.backend.DTOs.GetPlaylistDTO;
import com.catijr.backend.Entities.Playlist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {

    GetPlaylistDTO toDTO(Playlist playlist);

}