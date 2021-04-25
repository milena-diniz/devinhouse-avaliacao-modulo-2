package br.com.devinhouse.processos.mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.devinhouse.processos.dto.ProcessoDTO;

@Component
public class ProcessoMock implements Serializable {

	private static final long serialVersionUID = 6591122031422017939L;
		
	public List<ProcessoDTO> obterTodosOsProcessos() {
	    List<ProcessoDTO> listProcessos = new ArrayList<ProcessoDTO>();
	    int qtdProcessos = 40;
	    for (int i = 0; i < qtdProcessos; i++) {
	      ProcessoDTO dto = new ProcessoDTO();
	      dto.setId(i+1);
	      dto.setCdAssunto(i+1);
	      dto.setCdInteressado(i+1);
	      dto.setDescricao("Processo " + (i + 1 ) + "de testes DEV In House ");
	      dto.setDescricaoAssunto("Assunto " + (i + 1 ) + " de testes DEV In House ");
	      dto.setNmInteressado("João Antonio ::: " + i);
	      dto.setNuAnoProcesso(i <=20 ? "2020" : "2021");
	      dto.setNuProcesso(i+1);
	      dto.setSgOrgaoProcesso("SOFT");
	      dto.setChaveProcesso(dto.getSgOrgaoProcesso() + dto.getNuProcesso());
	      listProcessos.add(dto);
	    }
	    return listProcessos;
	  }
	}


