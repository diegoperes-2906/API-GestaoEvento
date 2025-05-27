package com.Gestao.Eventos.dto;


import java.util.HashSet;
import java.util.Set;

import com.Gestao.Eventos.entities.Evento;
import com.Gestao.Eventos.entities.Participante;


public class ParticipanteDTO { 

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private Set<Evento> eventos = new HashSet<>();
	
	
	public ParticipanteDTO() {
	}


	public ParticipanteDTO(Long id, String nome, String email, String telefone, Set<Evento> eventos) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.eventos = eventos;
	}
	
	public ParticipanteDTO(Participante entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.telefone = entity.getTelefone();
		this.eventos = entity.getEventos();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public Set<Evento> getEventos() {
		return eventos;
	}


	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}
	
	
	
}
