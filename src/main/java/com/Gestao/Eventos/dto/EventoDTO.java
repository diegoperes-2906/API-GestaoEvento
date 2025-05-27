package com.Gestao.Eventos.dto;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.Gestao.Eventos.entities.Evento;
import com.Gestao.Eventos.entities.Participante;

public class EventoDTO {

	    private Long id;
	    private int vagas;
	    private String nome;
	    private String descricao;
	    private Instant momento;
	    private String local;
	    
	    private Set<ParticipanteDTO> participantes = new HashSet<>();

	    public EventoDTO() {
	    	
	    }

		public EventoDTO(Long id, int vagas, String nome, String descricao, Instant momento, String local, Set<ParticipanteDTO> participantes) {
			this.id = id;
			this.vagas = vagas;
			this.nome = nome;
			this.descricao = descricao;
			this.momento = momento;
			this.local = local;
			this.participantes = participantes;
		}

	 public EventoDTO(Evento entity) {
		 this.id = entity.getId();
		 this.vagas = entity.getVagas();
		 this.nome = entity.getNome();
		 this.descricao = entity.getDescricao();
		 this.momento = entity.getMomento();
		 this.local = entity.getLocal();
		 
		 for (Participante p : entity.getParticipantes()) {
			    this.participantes.add(new ParticipanteDTO(p));
			} //listagem dos usuarios inscritos
		 
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Set<ParticipanteDTO> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Set<ParticipanteDTO> participantes) {
		this.participantes = participantes;
	}
	 
	 
} 
	        
	        	
	  
	  
	    



