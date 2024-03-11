package com.danielmonteiro.empresaAerea.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielmonteiro.empresaAerea.controllerDTO.ModeloAeronaveDTO;
import com.danielmonteiro.empresaAerea.model.ModeloAeronave;
import com.danielmonteiro.empresaAerea.repositorio.ModeloAeronaveRespositorio;

@RestController
public class ModeloAeronaveController {

	@Autowired
	private ModeloAeronaveRespositorio modelAeroRepo;
	
	@RequestMapping("/modelosaeronaves")
	public List<ModeloAeronaveDTO> listaModelos(){
		
		List<ModeloAeronave> listaModAero = (ArrayList<ModeloAeronave>) modelAeroRepo.findAll();
		List<ModeloAeronaveDTO> lista = new ArrayList<ModeloAeronaveDTO>();
		for(ModeloAeronave modelAero: listaModAero) {
			ModeloAeronaveDTO modelAeroDTO = new ModeloAeronaveDTO(modelAero);
			lista.add(modelAeroDTO);
		}
		
		return lista;		
	}

}
