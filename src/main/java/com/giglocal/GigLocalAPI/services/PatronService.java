package com.giglocal.GigLocalAPI.services;

import com.giglocal.GigLocalAPI.entities.Patron;
import com.giglocal.GigLocalAPI.repositories.PatronRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatronService {
    private PatronRepository patronRepo;

    public PatronService(PatronRepository patronRepo) {
        this.patronRepo = patronRepo;
    }

    public Patron savePatron(Patron patron) {
        return this.patronRepo.save(patron);
    }

    public Patron updatePatron(Patron patron) {
        return this.patronRepo.save(patron);
    }

    public List<Patron> getAllActivePatrons() {
        return this.patronRepo.findAll()
            .stream()
            .filter(patron -> patron.isActive()).collect(Collectors.toList());
    }

    public Patron getPatronById(Integer id) {
        return this.patronRepo.findById(id).orElse(null);
    }

}
