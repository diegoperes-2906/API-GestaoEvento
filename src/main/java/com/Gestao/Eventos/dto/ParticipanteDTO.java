package com.Gestao.Eventos.dto;

import com.Gestao.Eventos.entities.Participante;

public class ParticipanteDTO { 

	    private Long id;
	    private String nome;
	    private String email;
	    private Long eventoId;
	    private String eventoNome;

	    public ParticipanteDTO() {}

	    public ParticipanteDTO(Long id, String nome, String email, Long eventoId, String eventoNome) {
	        this.id = id;
	        this.nome = nome;
	        this.email = email;
	        this.eventoId = eventoId;
	        this.eventoNome = eventoNome;
	    }

	    public ParticipanteDTO(Participante participante) {
	        this.id = participante.getId();
	        this.nome = participante.getNome();
	        this.email = participante.getEmail();
	        if (participante.getEvento() != null) {
	            this.eventoId = participante.getId();
	            this.eventoNome = participante.getNome();
	        }
	    }

	    // Getters e Setters

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

	    public Long getEventoId() {
	        return eventoId;
	    }

	    public void setEventoId(Long eventoId) {
	        this.eventoId = eventoId;
	    }

	    public String getEventoNome() {
	        return eventoNome;
	    }

	    public void setEventoNome(String eventoNome) {
	        this.eventoNome = eventoNome;
	    }
	}


