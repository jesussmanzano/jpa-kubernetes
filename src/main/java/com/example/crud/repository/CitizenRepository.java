package com.example.crud.repository;
import com.example.crud.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long>{


    @Query(value = "SELECT c.* FROM Citizen c WHERE :citizen is null or c.name = :citizen AND (:firstLastName is null or c.first_last_name = :firstLastName)", nativeQuery = true)
        //@Query(value = "SELECT c.* FROM Citizen c WHERE :citizen is null or c.name = :citizen", nativeQuery = true)
        List<Citizen> findByCitizenJDBC(String citizen, String firstLastName);
}
