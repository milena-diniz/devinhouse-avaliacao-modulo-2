package br.com.devinhouse.processos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devinhouse.processos.dto.ProcessoDTO;
import br.com.devinhouse.processos.service.ProcessoService;

@RestController
@RequestMapping(value = "/processos")
public class ProcessoController {

	@Autowired
	private ProcessoService processoService;

	//- Deverá haver um endpoint para listagem de todos os processos, retornando todos os atributos de cada processo

	@RequestMapping(value = "/v1/consulta-json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> obterProcessos() {
		return processoService.obterProcessos();
	}

	// Deverá haver um endpoint para criação de um processo;
	
	@RequestMapping(value="/v1/cadastro/processo", method = RequestMethod.POST ,consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> criarProcessos(@RequestBody ProcessoDTO processo) {
		return processoService.criarProcessos(processo);
	}
	
	
	//Deverá haver um endpoint para buscar um processo baseado na sua identificação única (id);
	
	@RequestMapping(value = "/v1/consulta/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProcessoDTO buscarProcessoId(@PathVariable Integer id) {
		return processoService.pegarIdProcesso(id);
		
	}
	
	//Deverá haver um endpoint para buscar um processo baseado no seu número de processo (chaveProcesso); usar @requestParan
	
	@RequestMapping(value = "/v1/consulta/chaveProcesso", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> buscarChaveProcesso(@RequestParam String chaveProcesso) {
		return processoService.pegarChaveProcesso(chaveProcesso);
	}
	
		
	//Deverá haver um endpoint para atualização de todos os atributos de um processobaseado na sua identificação única (id);	
	
	@RequestMapping(value = "/v1/update/{id}", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public List<ProcessoDTO> atualizarProcesso(@PathVariable Integer id, @RequestBody ProcessoDTO newProcesso ) {
		return processoService.atualizarProcesso(id, newProcesso);
	}
	
	// Deverá haver um endpoint para exclusão de um processo baseado na sua identificação única (id); 
	
	@RequestMapping(value = "/v1/delete/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public List<ProcessoDTO> deletarProcesso(@PathVariable Integer id) {
		return processoService.deletarProcesso(id);
	}
}










	
