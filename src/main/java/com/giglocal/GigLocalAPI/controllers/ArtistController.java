package com.giglocal.GigLocalAPI.controllers;

import com.giglocal.GigLocalAPI.entities.Artist;
import com.giglocal.GigLocalAPI.services.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("artists")
@CrossOrigin("*")
public class ArtistController {

    private ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping("save_artist")
    public Artist postArtist(@RequestBody Artist artist) {
        return this.artistService.saveArtist(artist);
    }

    @PutMapping("update_artist")
    public ResponseEntity<Artist> putArtist(@RequestBody Artist artist) {
        Artist foundArtist = this.artistService.getArtistById(artist.getId());
        HttpStatus status;
        ResponseEntity response;

        if(foundArtist != null) {
            status = HttpStatus.OK;
            this.artistService.updateArtist(artist);
            response = new ResponseEntity(artist, status);
        } else {
            status = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("Account does not exist", status);
        }

        return response;
    }

    @GetMapping("")
    public List<Artist> getAllArtists() {
        return this.artistService.getAllArtists();
    }

    @GetMapping("{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Integer id) {
        Artist artist = this.artistService.getArtistById(id);
        HttpStatus status;
        ResponseEntity response;

        if(artist != null) {
            status = HttpStatus.OK;
            response = new ResponseEntity(artist, status);
        } else {
            status = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("Account does not exist", status);
        }

        return response;
    }

}
