package com.catijr.backend.Repositories;

import com.catijr.backend.Entities.PlaylistMusic;
import com.catijr.backend.Entities.PlaylistMusicId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistMusicRepository extends JpaRepository<PlaylistMusic, PlaylistMusicId> {
}
