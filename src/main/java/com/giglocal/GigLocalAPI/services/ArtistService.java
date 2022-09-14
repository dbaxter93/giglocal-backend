package com.giglocal.GigLocalAPI.services;

import com.giglocal.GigLocalAPI.entities.Artist;
import com.giglocal.GigLocalAPI.repositories.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistService {
    private ArtistRepository artistRepo;

    public ArtistService(ArtistRepository artistRepo) {
        this.artistRepo = artistRepo;
    }

    public Artist saveArtist(Artist artist) {
        return this.artistRepo.save(artist);
    }

    public Artist updateArtist(Artist artist) {
        return this.artistRepo.save(artist);
    }

    public List<Artist> getAllArtists() {
        return this.artistRepo.findAll();
    }

    public List<Artist> getAllActiveArtists() {
        return this.artistRepo.findAll()
            .stream()
            .filter(artist -> artist.isActive()).collect(Collectors.toList());
    }

    public Artist getArtistById(Integer id) {
        return this.artistRepo.findById(id).orElse(null);
    }

}
