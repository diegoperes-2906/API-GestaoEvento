package com.Gestao.Eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gestao.Eventos.dto.ParticipanteDTO;
import com.Gestao.Eventos.entities.Evento;
import com.Gestao.Eventos.entities.Participante;
import com.Gestao.Eventos.repositories.EventoRepository;
import com.Gestao.Eventos.repositories.ParticipanteRepository;

import jakarta.transaction.Transactional;

@Service
public class ParticipanteService {
	
	@Autowired
	ParticipanteRepository participanteRepository;
	
	@Autowired
	EventoRepository eventoRepository;
	
	@Transactional
	public List<ParticipanteDTO> todosParticipantes(){
		List<Participante> lista = participanteRepository.findAll();
		 return lista.stream().map(participante -> new ParticipanteDTO(participante)).toList();	
	}
	
	@Transactional
	public ParticipanteDTO participantePorId(Long id) {
		Participante entity = participanteRepository.findById(id).get();
		return new ParticipanteDTO(entity);
	}
	
	@Transactional
	public ParticipanteDTO criarParticipante(ParticipanteDTO dto) {
		Participante entity = new Participante();
		
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setTelefone(dto.getTelefone());
		
		entity = participanteRepository.save(entity);
		return new ParticipanteDTO(entity);
	}

	public ParticipanteDTO editarParticipante(ParticipanteDTO dto, Long id){
		Participante entity = participanteRepository.getReferenceById(id);
		
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setTelefone(dto.getTelefone());
		
		entity = participanteRepository.save(entity);
		return new ParticipanteDTO(entity);
	}
	
	public void deletarParticipante(Long id) {
		participanteRepository.deleteById(id);
	}
	
	@Transactional
	public String inscreverParticipanteEvento(Long participanteId, Long eventoId) {
		//validação
	    Participante participante = participanteRepository.findById(participanteId)
	        .orElseThrow(() -> new RuntimeException("Participante não encontrado"));
	    
	    Evento evento = eventoRepository.findById(eventoId)
	        .orElseThrow(() -> new RuntimeException("Evento não encontrado"));

	    // verificar se o usuario esta inscrito
	    if (evento.getParticipantes().contains(participante)) {
	        return "Participante já inscrito no evento.";
	    }

	    //verificação do limite de vagas
	    if (evento.getParticipantes().size() >= evento.getVagas()) {
	        return "Não há vagas disponíveis para este evento.";
	    }

	    // Faz a inscrição
	    evento.getParticipantes().add(participante);
	    participante.getEventos().add(evento);

	 
	    participanteRepository.save(participante);
	    eventoRepository.save(evento);

	    return "Inscrição realizada com sucesso!";
	}
	
	@Transactional
	public String cancelarInscricao(Long participanteId, Long eventoId) {
		//validação participante e evento exististentes
	    Participante participante = participanteRepository.findById(participanteId)
	        .orElseThrow(() -> new RuntimeException("Participante não encontrado"));
	    
	    Evento evento = eventoRepository.findById(eventoId)
	        .orElseThrow(() -> new RuntimeException("Evento não encontrado"));

	    //confirmar se o participante está inscrito
	    if (!evento.getParticipantes().contains(participante)) {
	        return "Participante não está inscrito neste evento.";
	    }
	    
	    //removendo usuario do evento
	    evento.getParticipantes().remove(participante);
	    participante.getEventos().remove(evento);

	    participanteRepository.save(participante);
	    eventoRepository.save(evento);

	    return "Inscrição cancelada com sucesso!";
	}
}
