package com.catijr.backend.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import java.time.Instant;

@Entity
@Table(name="tb_playlist_musics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaylistMusic {

    @Id
    @OneToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    @ManyToMany
    @JoinColumn(name = "music_id")
    private List<Music> songs;

    @Column(name = "num_music")
    private int musicQtd;

    @Column(name = "duration")
    private int duration;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    public void onPrePersist() {
        this.createdAt = Instant.now();
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updatedAt = Instant.now();
    }
}
