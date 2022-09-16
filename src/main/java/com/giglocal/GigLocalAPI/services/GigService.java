package com.giglocal.GigLocalAPI.services;

import com.giglocal.GigLocalAPI.entities.Gig;
import com.giglocal.GigLocalAPI.repositories.GigRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GigService {
    private GigRepository gigRepository;

    public GigService(GigRepository gigRepository) {
        this.gigRepository = gigRepository;
    }

    public List<Gig> getAllGigs() {
        return this.gigRepository.findAll();
    }

    public List<Gig> getAllActiveGigs() {
        return this.gigRepository.findAll()
                .stream()
                .filter(gig -> gig.isActive()).collect(Collectors.toList());
    }

    public Gig findGigById(Integer id) {
        return this.gigRepository.findById(id).orElse(null);
    }

    public Gig saveGig(Gig gig) {
        return this.gigRepository.save(gig);
    }

    public Gig updateGig(Gig gig) {
        return this.gigRepository.save(gig);
    }

    public void deleteGig(Gig gig) {
        gig.setActive(false);
        this.gigRepository.save(gig);
    }
}
