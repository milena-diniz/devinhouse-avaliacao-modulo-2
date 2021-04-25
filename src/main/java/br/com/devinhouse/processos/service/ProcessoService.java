package br.com.devinhouse.processos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devinhouse.processos.dto.ProcessoDTO;
import br.com.devinhouse.processos.repository.ProcessoRepository;

@Service
public class ProcessoService {

	@Autowired
	private ProcessoRepository processoRepository;

	public List<ProcessoDTO> obterProcessos() {
		return processoRepository.obterProcessos();
	}

	public List<ProcessoDTO> criarProcessos(ProcessoDTO processo) {
		List<ProcessoDTO> processos = obterProcessos();
		
		processos.add(processo);
		
		return processos;
	}
	
	public ProcessoDTO pegarIdProcesso(Integer id) {
		List<ProcessoDTO> todosOsProcessos = obterProcessos();
		for (ProcessoDTO processo : todosOsProcessos) { 
			if (processo.getId().equals(id)) { 
				return processo;
			}
		}
		return null; 	
	}
	
	public List<ProcessoDTO> pegarChaveProcesso(String chaveProcesso) {
		List<ProcessoDTO> todasChavesProcesso = obterProcessos();
		List<ProcessoDTO> chavesFiltrados = new ArrayList<ProcessoDTO>();
		
		for (ProcessoDTO processoChave : todasChavesProcesso ) {
			if (processoChave.getChaveProcesso().equals(chaveProcesso)) {
				chavesFiltrados.add(processoChave);
			}
		}
		return chavesFiltrados;
	}
	
	public List<ProcessoDTO> atualizarProcesso (Integer id, ProcessoDTO newProcesso) {
		List<ProcessoDTO> todosProcessos = obterProcessos();
		for (ProcessoDTO processoDTO : todosProcessos) {
			if (id == processoDTO.getId()) {
				processoDTO.setDescricao(newProcesso.getDescricao());
				processoDTO.setNmInteressado(newProcesso.getNmInteressado()); 
				processoDTO.setChaveProcesso(newProcesso.getChaveProcesso());
				processoDTO.setSgOrgaoProcesso(newProcesso.getSgOrgaoProcesso());
				processoDTO.setNuProcesso(newProcesso.getNuProcesso());
				processoDTO.setNuAnoProcesso(newProcesso.getNuAnoProcesso());
				processoDTO.setCdAssunto(newProcesso.getCdAssunto());
				processoDTO.setDescricao(newProcesso.getDescricao());
				processoDTO.setCdInteressado(newProcesso.getCdInteressado());
			}
		}
		return todosProcessos;
	}
	
	public List<ProcessoDTO> deletarProcesso (Integer id) {
		
		List<ProcessoDTO> todosProcessos = obterProcessos();
		List<ProcessoDTO> processosFiltrados = new ArrayList<ProcessoDTO>();
		
		for (ProcessoDTO processo : todosProcessos ) {
			if (processo.getId() != id) {
				processosFiltrados.add(processo);
			}
		}
		return processosFiltrados;
	}
	
}
