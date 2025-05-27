package com.Gestao.Eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gestao.Eventos.dto.ParticipanteDTO;
import com.Gestao.Eventos.service.ParticipanteService;

@RestController
@RequestMapping(value = "/participantes")
public class ParticipanteController {
	
	@Autowired
	ParticipanteService participanteService;
	
	@GetMapping("")
	public List<ParticipanteDTO>  todosParticipantes(){
		return participanteService.todosParticipantes();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ParticipanteDTO> participantePorId(@PathVariable Long id){
		ParticipanteDTO dto = participanteService.participantePorId(id);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping(value = "/criar")
	public ResponseEntity<ParticipanteDTO> criarParticipante(@RequestBody ParticipanteDTO dto){
		dto = participanteService.criarParticipante(dto);
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping(value = "/editar/{id}")
	public ResponseEntity<ParticipanteDTO> editarParticipante(@RequestBody ParticipanteDTO dto, @PathVariable Long id){
		dto = participanteService.editarParticipante(dto, id);
		return ResponseEntity.ok(dto);
	}
	@DeleteMapping(value = "deletar/{id}")
	public void deletar (@PathVariable Long id) {
		participanteService.deletarParticipante(id);
	}
	
	@PostMapping("/{participanteId}/inscrever/{eventoId}")
	public ResponseEntity<String> inscrever(@PathVariable Long participanteId, @PathVariable Long eventoId) {
	    String resposta = participanteService.inscreverParticipanteEvento(participanteId, eventoId);
	    return ResponseEntity.ok(resposta);
	}

	@DeleteMapping("/{participanteId}/cancelar/{eventoId}")
	public ResponseEntity<String> cancelar(@PathVariable Long participanteId, @PathVariable Long eventoId) {
	    String resposta = participanteService.cancelarInscricao(participanteId, eventoId);
	    return ResponseEntity.ok(resposta);
	}

}
