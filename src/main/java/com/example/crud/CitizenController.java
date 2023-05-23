package com.example.crud;

import com.example.crud.entity.Citizen;
import com.example.crud.exception.AppException;
import com.example.crud.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/jpa/")
public class CitizenController {

    @Autowired
    private CitizenService service;

    @PostMapping()
    public ResponseEntity<Citizen> save(Citizen citizen){
        return new ResponseEntity<>(service.save(citizen), HttpStatus.CREATED);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Citizen>> findAll(){
        return new ResponseEntity<>(service.getOrderList(), HttpStatus.ACCEPTED);
    }

    @PatchMapping
    public ResponseEntity<Citizen> patchCitizen(
            @RequestParam("id") Long id,
            @RequestBody Map<Object, Object> citizen)
            throws AppException {
        return new ResponseEntity<>(service.updateCitizen(citizen, id), HttpStatus.ACCEPTED);
    }





}
