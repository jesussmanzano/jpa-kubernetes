package com.example.crud.service;

import com.example.crud.entity.Citizen;
import com.example.crud.exception.AppException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CitizenService {
    Citizen save(Citizen citizen);

    List<Citizen> getOrderList();

    void deleteById(Long idOrder);

    Citizen updateCitizen(Map<Object, Object> fields, Long id) throws AppException;


    Page<Citizen> findAllByPage(Pageable pageable);


    List<Citizen> findByCitizen(Citizen citizen);

    List<Citizen> findByCitizenJDBC(Citizen citizen);
}
