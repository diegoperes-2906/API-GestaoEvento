package com.Gestao.Eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gestao.Eventos.dto.EventoDTO;
import com.Gestao.Eventos.entities.Evento;
import com.Gestao.Eventos.repositories.EventoRepository;

import jakarta.transaction.Transactional;

@Service
public class EventoService {
	
	@Autowired
	EventoRepository eventoRepository;
	

	@Transactional
	public List<EventoDTO> todosEventos(){
		List<Evento> lista = eventoRepository.findAll();
		 return lista.stream().map(evento -> new EventoDTO(evento)).toList();	
	}//lista com todos os eventos
	
	@Transactional
	public EventoDTO eventoPorId(Long id) {
		Evento entity = eventoRepository.findById(id).get();
		return new EventoDTO(entity);
	}// exibir eventos por id
	
	@Transactional
	public EventoDTO criarEvento(EventoDTO dto) {
		Evento entity = new Evento();
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
		entity.setLocal(dto.getLocal());
		entity.setMomento(dto.getMomento());
		entity.setVagas(dto.getVagas());
		
		entity = eventoRepository.save(entity);
		return new EventoDTO(entity);
	}// criando evento
	
	
	@Transactional
	public EventoDTO editarEvento (EventoDTO dto, Long id) {
		Evento entity = eventoRepository.getReferenceById(id);
		
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
		entity.setLocal(dto.getLocal());
		entity.setMomento(dto.getMomento());
		entity.setVagas(dto.getVagas());	
		
		entity = eventoRepository.save(entity);
		return new EventoDTO(entity);
	}
	
	public void deletarEvento(Long id) {
		eventoRepository.deleteById(id);
	}

}
