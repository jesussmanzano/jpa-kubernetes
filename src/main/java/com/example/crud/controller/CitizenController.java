package com.example.crud.controller;

import com.example.crud.entity.Citizen;
import com.example.crud.exception.AppException;
import com.example.crud.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jpa/")
public class CitizenController {

    private final CitizenService service;

    public CitizenController(CitizenService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Citizen> save(@RequestBody Citizen citizen){
        return new ResponseEntity<>(service.save(citizen), HttpStatus.CREATED);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Citizen>> findAll(){
        Collections.sort(service.getOrderList(), (o2, o1) -> {return o2.getName().compareTo(o1.getName());});
        //return new ResponseEntity<>(service.getOrderList(), HttpStatus.OK);
        return new ResponseEntity<>(service.getOrderList().stream().sorted(Comparator.comparing(Citizen::getName)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Citizen> patchCitizen(
            @RequestParam("id") Long id,
            @RequestBody Map<Object, Object> citizen)
            throws AppException {
        return new ResponseEntity<>(service.updateCitizen(citizen, id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Page<Citizen>> findByPage(Pageable pageable){
        return new ResponseEntity<>(service.findAllByPage(pageable), HttpStatus.OK);
    }

    @GetMapping("findByCitizen")
    public ResponseEntity<List<Citizen>> findByCitizen(@RequestBody Citizen citizen){
        return new ResponseEntity<>(service.findByCitizen( citizen), HttpStatus.OK);
    }
    @GetMapping("findByCitizenJDBC")
    public ResponseEntity<List<Citizen>> findByCitizenJDBC(@RequestBody Citizen citizen){
        return new ResponseEntity<>(service.findByCitizenJDBC( citizen), HttpStatus.OK);
    }




}
