package com.danielmonteiro.empresaAerea.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielmonteiro.empresaAerea.controllerDTO.PilotoDTO;
import com.danielmonteiro.empresaAerea.model.Piloto;
import com.danielmonteiro.empresaAerea.repositorio.PilotoRepositorio;

@RestController
public class PilotoController {
    
	@Autowired
	private PilotoRepositorio pilotoRepo;
	
	@RequestMapping("/pilotos")
	public List<PilotoDTO> listaDePilotos(){
		
		List<Piloto> listaPilotos = (ArrayList<Piloto>) pilotoRepo.findAll();
		List<PilotoDTO> lista = new ArrayList<PilotoDTO>();
		for(Piloto piloto: listaPilotos) {
			PilotoDTO pilotoDTO = new PilotoDTO(piloto);
			lista.add(pilotoDTO);
		}
		
		return lista;
	} 
	
}
