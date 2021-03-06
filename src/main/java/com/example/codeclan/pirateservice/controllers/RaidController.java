package com.example.codeclan.pirateservice.controllers;

import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.repositories.RaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RaidController {

    @Autowired
    RaidRepository raidRepository;

    //    INDEX
    @GetMapping(value="/raids")
    public ResponseEntity <List<Raid>> getAllRaids(){
        return new ResponseEntity<>(raidRepository.findAll(), HttpStatus.OK);
    }

    //    SHOW
    @GetMapping(value="/raids/{id}")
    public ResponseEntity getRaid(@PathVariable Long id){
        return new ResponseEntity<>(raidRepository.findById(id), HttpStatus.OK);
    }

    //    POST
    @PostMapping(value = "/raids")
    public ResponseEntity<Raid> postRaid(@RequestBody Raid raid){
        raidRepository.save(raid);
        return new ResponseEntity<>(raid, HttpStatus.CREATED);
    }
}

