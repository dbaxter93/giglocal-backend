package com.giglocal.GigLocalAPI.repositories;

import com.giglocal.GigLocalAPI.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}
