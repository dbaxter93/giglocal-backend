package com.giglocal.GigLocalAPI.controllers;

import com.giglocal.GigLocalAPI.entities.Artist;
import com.giglocal.GigLocalAPI.entities.Patron;
import com.giglocal.GigLocalAPI.services.PatronService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patrons")
@CrossOrigin("*")
public class PatronController {

    private PatronService patronService;

    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    @PostMapping("save_patron")
    public Patron postPatron(@RequestBody Patron patron) {
        return this.patronService.savePatron(patron);
    }

    @PutMapping("update_patron")
    public ResponseEntity<Patron> putPatron(@RequestBody Patron patron) {
        Patron foundPatron = this.patronService.getPatronById(patron.getId());
        HttpStatus status;
        ResponseEntity response;

        if(foundPatron != null) {
            status = HttpStatus.OK;
            this.patronService.updatePatron(patron);
            response = new ResponseEntity(patron, status);
        } else {
            status = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("Account does not exist", status);
        }

        return response;
    }

    @GetMapping("{id}")
    public ResponseEntity<Patron> getPatronById(@PathVariable Integer id) {
        Patron patron = this.patronService.getPatronById(id);
        HttpStatus status;
        ResponseEntity response;

        if(patron != null) {
            status = HttpStatus.OK;
            response = new ResponseEntity(patron, status);
        } else {
            status = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("User does not exist", status);
        }

        return response;
    }

}
