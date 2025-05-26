package com.Gestao.Eventos.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_eventos")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int vagas;
	private String nome;
	private String descricao;
	private Instant momento;
	private String local;
	
	@ManyToMany(mappedBy = "participantes")
    private Set<Participante> participantes = new HashSet<>();

	
	public Evento() {
		}


	public Evento(Long id, int vagas, String nome, String descricao, Instant momento, String local) {
		this.id = id;
		this.vagas = vagas;
		this.nome = nome;
		this.descricao = descricao;
		this.momento = momento;
		this.local = local;
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
	
	
	
}

	
	