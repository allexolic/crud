package com.aocurvelo.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aocurvelo.crud.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
