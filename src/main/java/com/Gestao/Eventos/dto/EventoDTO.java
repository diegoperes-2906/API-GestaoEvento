package com.Gestao.Eventos.dto;

import java.time.Instant;

public class EventoDTO {

	    private Long id;
	    private int vagas;
	    private String nome;
	    private String descricao;
	    private Instant momento;
	    private String local;

	    public EventoDTO() {}

	    public EventoDTO(Long id, int vagas, String nome, String descricao, Instant momento, String local) {
	        this.id = id;
	        this.vagas = vagas;
	        this.nome = nome;
	        this.descricao = descricao;
	        this.momento = momento;
	        this.local = local;
	    }
	    
	    public EventoDTO( com.Gestao.Eventos.dto.EventoDTO evento) {
	        this.id = evento.getId();
	        this.vagas = evento.getVagas();
	        this.nome = evento.getNome();
	        this.descricao = evento.getDescricao();
	        this.momento = evento.getMomento();
	        this.local = evento.getLocal();
	    }

	    // Getters e Setters

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
	   
	        {
	        	
	        }
	        
	    }  
} 
	        
	        	
	  
	  
	    



