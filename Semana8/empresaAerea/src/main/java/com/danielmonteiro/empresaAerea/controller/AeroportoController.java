package com.danielmonteiro.empresaAerea.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.danielmonteiro.empresaAerea.controllerDTO.AeroportoDTO;
import com.danielmonteiro.empresaAerea.model.Aeroporto;
import com.danielmonteiro.empresaAerea.repositorio.AeroportoRepositorio;

@RestController
public class AeroportoController {

	@Autowired
	private AeroportoRepositorio aeroRepo;
	
	
	@RequestMapping("/aeroportos")
	public List<AeroportoDTO> listaAeroportos(){
		
		List<Aeroporto> listaAeroporto = (ArrayList<Aeroporto>) aeroRepo.findAll();
		List<AeroportoDTO> lista = new ArrayList<AeroportoDTO>();
		for(Aeroporto aeroporto: listaAeroporto) {
			AeroportoDTO aeroDTO = new AeroportoDTO(aeroporto);
			lista.add(aeroDTO);
		}
		
		return lista;
	}
}
