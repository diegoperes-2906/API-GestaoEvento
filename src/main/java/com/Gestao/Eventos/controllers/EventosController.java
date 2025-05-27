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

import com.Gestao.Eventos.dto.EventoDTO;
import com.Gestao.Eventos.service.EventoService;

@RestController
@RequestMapping(value = "/eventos")
public class EventosController {
	
	@Autowired
	EventoService eventoService;
	
	@GetMapping("")
	public List<EventoDTO> todosEventos(){
		return eventoService.todosEventos();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EventoDTO> eventoPorId(@PathVariable Long id){
		EventoDTO dto = eventoService.eventoPorId(id);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping(value = "/criar")
	public ResponseEntity<EventoDTO>  criarEvento(@RequestBody EventoDTO dto){
		dto = eventoService.criarEvento(dto);
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping(value = "/editar/{id}")
	public ResponseEntity<EventoDTO> editarEvento(@RequestBody EventoDTO dto, @PathVariable Long id){
		dto = eventoService.editarEvento(dto, id);
		return ResponseEntity.ok(dto);
	}
	@DeleteMapping(value = "deletar/{id}")
	public void deletar (@PathVariable Long id) {
		eventoService.deletarEvento(id);
	}
}
