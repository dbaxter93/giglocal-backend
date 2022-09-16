package com.giglocal.GigLocalAPI.controllers;

import com.giglocal.GigLocalAPI.entities.Gig;
import com.giglocal.GigLocalAPI.services.GigService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gigs")
@CrossOrigin("*")
public class GigController {

    private GigService gigService;

    public GigController(GigService gigService) {
        this.gigService = gigService;
    }

    @GetMapping("")
    public List<Gig> getAllActiveGigs() {
        return this.gigService.getAllActiveGigs();
    }

    @GetMapping("{id}")
    public ResponseEntity<Gig> getGigById(@PathVariable Integer id) {
        Gig gig = this.gigService.findGigById(id);
        HttpStatus status;
        ResponseEntity response;

        if(gig != null) {
            status = HttpStatus.OK;
            response = new ResponseEntity(gig, status);
        } else {
            status = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("This gig does not exist", status);
        }

        return response;
    }

    @PostMapping("save_gig")
    public Gig postGig(@RequestBody Gig gig) {
        return this.gigService.saveGig(gig);
    }

    @PutMapping("update_gig")
    public ResponseEntity<Gig> putGig(@RequestBody Gig gig) {
        Gig foundGig = this.gigService.findGigById(gig.getId());
        HttpStatus status;
        ResponseEntity response;

        if(foundGig != null) {
            status = HttpStatus.OK;
            this.gigService.updateGig(gig);
            response = new ResponseEntity(gig, status);
        } else {
            status = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("This gig does not exist", status);
        }

        return response;
    }

}
