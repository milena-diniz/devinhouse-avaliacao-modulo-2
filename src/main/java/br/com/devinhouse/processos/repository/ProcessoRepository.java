package br.com.devinhouse.processos.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.devinhouse.processos.dto.ProcessoDTO;
import br.com.devinhouse.processos.mock.ProcessoMock;

@Repository
public class ProcessoRepository {
	
	@Autowired
	private ProcessoMock processoMock;
	
	public List<ProcessoDTO> obterProcessos() {
		return processoMock.obterTodosOsProcessos();
	}
}
