package com.example.crud.service.implementation;

import com.example.crud.entity.Citizen;
import com.example.crud.exception.AppException;
import com.example.crud.repository.CitizenRepository;
import com.example.crud.service.CitizenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class CitizenServiceImpl implements CitizenService {
    private final CitizenRepository repository;

    @Autowired
    public CitizenServiceImpl(CitizenRepository repository){
        this.repository = repository;
    }

    @Override
    public Citizen save(Citizen citizen){
        return repository.save(citizen);
    }

    @Override
    public List<Citizen> getOrderList(){
        return repository.findAll();
    }

    @Override
    public void deleteById(Long idOrder){
        repository.deleteById(idOrder);
    }

    @Override
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

    @Override
    public Page<Citizen> findAllByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Citizen> findByCitizen(Citizen citizen) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIncludeNullValues().
                withIgnorePaths("id","name","firstLastName", "secondLastName", "uniquePopulationRegistryCode");
        return repository.findAll(Example.of(citizen, matcher));
    }

    @Override
    public List<Citizen> findByCitizenJDBC(Citizen citizen) {
        return repository.findByCitizenJDBC(citizen.getName(), citizen.getFirstLastName());
    }


}
