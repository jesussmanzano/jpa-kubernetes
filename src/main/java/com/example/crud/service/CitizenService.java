package com.example.crud.service;

import com.example.crud.entity.Citizen;
import com.example.crud.entity.Order;
import com.example.crud.repository.CitizenRepository;
import com.example.crud.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {
    @Autowired
    CitizenRepository repository;

    public Citizen save(Citizen citizen){
        return repository.save(citizen);
    }

    public List<Citizen> getOrderList(){
        return repository.findAll();
    }

    public void deleteById(Long idOrder){
        repository.deleteById(idOrder);
    }

    public void updateOrder(Citizen citizen){
        repository.save(citizen);
    }




}
