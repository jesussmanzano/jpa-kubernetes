package com.example.crud.service;

import com.example.crud.entity.Citizen;
import com.example.crud.exception.AppException;
import com.example.crud.repository.CitizenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class CitizenService {
    private final CitizenRepository repository;

    @Autowired
    public CitizenService(CitizenRepository repository){
        this.repository = repository;
    }

    public Citizen save(Citizen citizen){
        return repository.save(citizen);
    }

    public List<Citizen> getOrderList(){
        return repository.findAll();
    }

    public void deleteById(Long idOrder){
        repository.deleteById(idOrder);
    }

    public Citizen updateCitizen(Map<Object, Object> fields, Long id) throws AppException {

        Optional<Citizen> citizen = Optional.of(repository.findById(id))
                .orElseThrow(() -> new AppException("No user found with the ID:" + id));

        if(citizen!= null && citizen.isPresent()){
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Citizen.class, (String) key);
                if(field != null){
                field.setAccessible(true);
                ReflectionUtils.setField(field, citizen.get(), value);
            }});

            log.info("Object to update" + citizen.get().toString());
            return repository.save(citizen.get());

        }

        throw new AppException("Exception occurred on updateCitizen method");
    }


}
