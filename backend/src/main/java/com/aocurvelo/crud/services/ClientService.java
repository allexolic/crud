package com.aocurvelo.crud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aocurvelo.crud.dto.ClientDTO;
import com.aocurvelo.crud.entities.Client;
import com.aocurvelo.crud.repositories.ClientRepository;
import com.aocurvelo.crud.services.exceptions.NotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));		
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> cli = repository.findById(id);
		Client entity = cli.orElseThrow(() -> new NotFoundException());
		return new ClientDTO(entity);
	}

	
}
