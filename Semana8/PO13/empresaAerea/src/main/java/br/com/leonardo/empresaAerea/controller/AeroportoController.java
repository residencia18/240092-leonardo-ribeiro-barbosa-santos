package br.com.leonardo.empresaAerea.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leonardo.empresaAerea.controllerDTO.AeroportoDTO;
import br.com.leonardo.empresaAerea.model.Aeroporto;
import br.com.leonardo.empresaAerea.repositorio.AeroportoRepositorio;

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
