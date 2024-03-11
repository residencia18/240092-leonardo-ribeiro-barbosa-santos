package br.com.leonardo.empresaAerea.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leonardo.empresaAerea.controllerDTO.ModeloAeronaveDTO;
import br.com.leonardo.empresaAerea.model.ModeloAeronave;
import br.com.leonardo.empresaAerea.repositorio.ModeloAeronaveRespositorio;

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
