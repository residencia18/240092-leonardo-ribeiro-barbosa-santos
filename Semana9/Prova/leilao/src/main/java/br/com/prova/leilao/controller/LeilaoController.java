package br.com.prova.leilao.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import br.com.prova.leilao.controller.dto.LeilaoDTO;
import br.com.prova.leilao.controller.form.LeilaoForm;
import br.com.prova.leilao.modelo.Leilao;
import br.com.prova.leilao.repository.LeilaoRepository;



@RequestMapping("/leilao/")
@RestController
public class LeilaoController {
	
	
	@Autowired
	private LeilaoRepository leilaoRepository;
	
	@GetMapping
	public List<Leilao> criarUsuario() {
		return leilaoRepository.findAll();
	}
	 
	 @GetMapping("/leilao/")
	    public ResponseEntity<List<LeilaoDTO>> listaTodosLeiloes() {
	        List<Leilao> listaLeilao = leilaoRepository.findAll();
	        List<LeilaoDTO> listaDTO = new ArrayList<>();
	        for (Leilao lei : listaLeilao) {
	            LeilaoDTO leiDTO = new LeilaoDTO(lei);
	            listaDTO.add(leiDTO);
	        }
	        return new ResponseEntity<>(listaDTO, HttpStatus.OK);
	    }
	 
	 
	 
	 	@PostMapping("/leilao/")
	    public ResponseEntity<LeilaoDTO> inserir(UriComponentsBuilder uriBuilder) {
	        Leilao leilao = new Leilao();
	        leilaoRepository.save(leilao);
	        LeilaoDTO leilaoDTO = new LeilaoDTO(leilao);

	        URI uri = uriBuilder.path("/leilao/{id}").buildAndExpand(leilao.getId()).toUri();
	        return ResponseEntity.created(uri).body(leilaoDTO);
	    }

    
	 @GetMapping("/{id}")
		public ResponseEntity<LeilaoDTO> BuscaleilaoId(@PathVariable Integer id, UriComponentsBuilder uriBuilder ) {
		try {
			Leilao leilao = leilaoRepository.getReferenceById(id);
			LeilaoDTO leilaoDTO = new LeilaoDTO(leilao);
			uriBuilder.path("/leilao/{id}");
			return ResponseEntity.ok(leilaoDTO);
		}	catch (Exception e ) {
			return ResponseEntity.notFound().build();
		}


	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<?> alteraLeilao(@PathVariable Integer id, @RequestBody LeilaoForm leilaoAtualizado) {
	     try {
	    	 java.util.Optional<Leilao> optionalLeilao = leilaoRepository.findById(id);
	         
	         if (optionalLeilao.isPresent()) {
	             Leilao leilao = optionalLeilao.get();
	             leilao.setDescricao(leilaoAtualizado.getDescricao());
	             leilao.setValorMinimo(leilaoAtualizado.getValorMinimo());
	             leilao.setStatus(leilaoAtualizado.getStatus());
	             leilaoRepository.save(leilao);
	             
	             LeilaoDTO leilaoDTO = new LeilaoDTO(leilao);
	             return ResponseEntity.ok(leilaoDTO);
	         } else {
	             return ResponseEntity.notFound().build();
	         }
	     } catch (Exception e) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	     }
	 }

	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<?> deletaLeilao(@PathVariable Integer id) {
	     try {
	    	 java.util.Optional<Leilao> optionalLeilao = leilaoRepository.findById(id);
	         
	         if (optionalLeilao.isPresent()) {
	             Leilao leilao = optionalLeilao.get();
	             leilaoRepository.delete(leilao);
	             
	             return ResponseEntity.noContent().build();
	         } else {
	             return ResponseEntity.notFound().build();
	         }
	     } catch (Exception e) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	     }
	 }

	
	 
	 
		private String descricao;
		private String valorMinimo;
		private String status;
		
		
		
		
		public LeilaoController() {}




		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}




		public String getValorMinimo() {
			return valorMinimo;
		}

		public void setValorMinimo(String valorMinimo) {
			this.valorMinimo = valorMinimo;
		}




		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
}

