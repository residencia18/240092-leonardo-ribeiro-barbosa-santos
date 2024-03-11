package br.com.prova.leilao.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prova.leilao.controller.dto.LanceDTO;
import br.com.prova.leilao.modelo.Lance;
import br.com.prova.leilao.repository.LanceRepository;

		
@RequestMapping("/lance/")
@RestController	
public class LanceController {
	
	
	@Autowired
	private LanceRepository lanceRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<LanceDTO> buscaLancePorId(@PathVariable Long id) {
	    Optional<Lance> optionalLance = lanceRepository.findById(id);
	    if (optionalLance.isPresent()) {
	        Lance lance = optionalLance.get();
	        LanceDTO lanceDTO = new LanceDTO(lance.getLeilao(), lance.getConcorrente(), lance.getValor());
	        return ResponseEntity.ok(lanceDTO);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}


