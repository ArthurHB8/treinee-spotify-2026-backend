package com.catijr.backend.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catijr.backend.Entities.Album;
import com.catijr.backend.Entities.Artist;
import com.catijr.backend.Entities.Music;
import com.catijr.backend.Entities.Playlist;
import com.catijr.backend.Services.UserService;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;

    /*
    GET METHOD:

    This method is used to list all the playlists of the user
    
    **since there is only a single user in this project, this is
    equivalent to listing all the playlists of the database

    */
    @GetMapping("/playlists")
    public List<Playlist> getUserPlaylists(@RequestParam String param) {
        return userService.getUserPlaylists();
    }

    /*
    GET METHOD:

    This method is used to list (the last 5) artists the user recently listened to,
    since this project has no support for metrics that allow this to be
    a functional route, the result of this method will be a fixed set of artists
    initialized in the database
    */
    @GetMapping("/recentArtists")
    public List<Artist> getUserRecentArtists(@RequestParam String param) {
        return userService.getUserRecentArtists();
    }
    

    /*
    GET METHOD:

    This method is used to list the 5 most played artists of the user,
    since this project has no support for metrics that allow this to be
    a functional route, the result of this method will be a fixed set of artists
    initialized in the database

    */
    @GetMapping("/mostPlayedArtists")
    public List<Artist> getUserMostPlayedArtists(@RequestParam String param) {
        return userService.getUserMostPlayedArtists();
    }

    /*
    GET METHOD:
    
    This method is used to list the user's (last 5) recently played musics,
    since this project has no support for metrics that allow this to be
    a functional route, the result of this method will be a fixed set of musics
    initialized in the database
    */
    @GetMapping("/recentMusics")
    public List<Music> getUserRecentMusics(@RequestParam String param) {
        return userService.getUserRecentMusics();
    }

    /*
    GET METHOD:
    
    This method is used to list the user's 5 most played musics,
    since this project has no support for metrics that allow this to be
    a functional route, the result of this method will be a fixed set of musics
    initialized in the database
    */
    @GetMapping("/mostPlayedMusics")
    public List<Music> getUserMostPlayedMusics(@RequestParam String param) {
        return userService.getUserMostPlayedMusics();
    }

     /*
    GET METHOD:
    
    This method is used to list the user's (last 5) recently played albums,
    since this project has no support for metrics that allow this to be
    a functional route, the result of this method will be a fixed set of albums
    initialized in the database
    */
    @GetMapping("/recentAlbums")
    public List<Album> getUserRecentAlbums(@RequestParam String param) {
        return userService.getUserRecentAlbums();
    }

    /*
    GET METHOD:

    THis method is used to list the user's followers, since this project
    has no support for this logic, the result of this method will be a
    fixed set of data not initialized in the database
    */ 
    @GetMapping("/followers")
    public List<String> getUserFollowers(@RequestParam String param) {
        List<String> followers =new ArrayList<>(List.of("deadbeat7","xmc0-Infinity","John Doe", "Jose Manuel Alberto Lopez","XCS_2026"));

        return followers;
    }
    
    
    
    
    

    
}
