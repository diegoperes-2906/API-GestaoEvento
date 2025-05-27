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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/eventos")
public class EventosController {

    @Autowired
    EventoService eventoService;

    @Operation(summary = "Lista todos os eventos", description = "Busca todos os eventos cadastrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna todos os eventos cadastrados"),
        @ApiResponse(responseCode = "400", description = "Não há eventos cadastrados")
    })
    @GetMapping("")
    public List<EventoDTO> todosEventos() {
        return eventoService.todosEventos();
    }

    @Operation(summary = "Busca evento por ID", description = "Retorna um evento pelo seu ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Evento encontrado"),
        @ApiResponse(responseCode = "400", description = "Não existe evento com o ID informado")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<EventoDTO> eventoPorId(@PathVariable Long id) {
        EventoDTO dto = eventoService.eventoPorId(id);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Cria um novo evento", description = "Cadastra um novo evento")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Evento cadastrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Já existe um evento com o ID informado")
    })
    @PostMapping(value = "/criar")
    public ResponseEntity<EventoDTO> criarEvento(@RequestBody EventoDTO dto) {
        dto = eventoService.criarEvento(dto);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Edita um evento", description = "Edita um evento existente pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Evento editado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Não existe evento com o ID informado")
    })
    @PutMapping(value = "/editar/{id}")
    public ResponseEntity<EventoDTO> editarEvento(@RequestBody EventoDTO dto, @PathVariable Long id) {
        dto = eventoService.editarEvento(dto, id);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Deleta um evento", description = "Remove um evento existente pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Evento deletado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Não existe evento com o ID informado")
    })
    @DeleteMapping(value = "/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        eventoService.deletarEvento(id);
    }
}
