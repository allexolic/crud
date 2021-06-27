package com.aocurvelo.crud.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aocurvelo.crud.dto.ClientDTO;
import com.aocurvelo.crud.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<Page<ClientDTO>> findAll(@RequestParam(name = "page", defaultValue = "0")Integer page,
			@RequestParam(name = "linesPerPage", defaultValue = "10")Integer linesPerPage,
			@RequestParam(name = "direction", defaultValue = "ASC")String direction,
			@RequestParam(name = "orderBy", defaultValue = "name")String orderBy){
		
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<ClientDTO> body = service.findAllPaged(pageRequest);
		
		return ResponseEntity.ok().body(body);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable("id") Long id){
		ClientDTO body = service.findById(id);
		return ResponseEntity.ok().body(body);
	}
}
