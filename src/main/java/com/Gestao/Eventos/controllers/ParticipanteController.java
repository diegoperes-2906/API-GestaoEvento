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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/participantes")
public class ParticipanteController {

    @Autowired
    ParticipanteService participanteService;

    @Operation(summary = "Lista todos os participantes", description = "Busca todos os participantes cadastrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna todos os participantes cadastrados"),
        @ApiResponse(responseCode = "400", description = "Não há participantes cadastrados")
    })
    @GetMapping("")
    public List<ParticipanteDTO> todosParticipantes() {
        return participanteService.todosParticipantes();
    }

    @Operation(summary = "Busca participante por ID", description = "Retorna um participante pelo seu ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Participante encontrado"),
        @ApiResponse(responseCode = "400", description = "Não existe participante com o ID informado")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<ParticipanteDTO> participantePorId(@PathVariable Long id) {
        ParticipanteDTO dto = participanteService.participantePorId(id);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Cria um novo participante", description = "Cadastra um novo participante")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Participante cadastrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Já existe um participante com o ID informado")
    })
    @PostMapping(value = "/criar")
    public ResponseEntity<ParticipanteDTO> criarParticipante(@RequestBody ParticipanteDTO dto) {
        dto = participanteService.criarParticipante(dto);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Edita um participante", description = "Edita um participante existente pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Participante editado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Não existe participante com o ID informado")
    })
    @PutMapping(value = "/editar/{id}")
    public ResponseEntity<ParticipanteDTO> editarParticipante(@RequestBody ParticipanteDTO dto, @PathVariable Long id) {
        dto = participanteService.editarParticipante(dto, id);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Deleta um participante", description = "Remove um participante existente pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Participante deletado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Não existe participante com o ID informado")
    })
    @DeleteMapping(value = "/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        participanteService.deletarParticipante(id);
    }

    @Operation(summary = "Inscreve participante em evento", description = "Inscreve um participante em um evento")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Inscrição realizada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro ao realizar inscrição")
    })
    @PostMapping("/{participanteId}/inscrever/{eventoId}")
    public ResponseEntity<String> inscrever(@PathVariable Long participanteId, @PathVariable Long eventoId) {
        String resposta = participanteService.inscreverParticipanteEvento(participanteId, eventoId);
        return ResponseEntity.ok(resposta);
    }

    @Operation(summary = "Cancela inscrição do participante", description = "Cancela a inscrição de um participante em um evento")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Inscrição cancelada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro ao cancelar inscrição")
    })
    @DeleteMapping("/{participanteId}/cancelar/{eventoId}")
    public ResponseEntity<String> cancelar(@PathVariable Long participanteId, @PathVariable Long eventoId) {
        String resposta = participanteService.cancelarInscricao(participanteId, eventoId);
        return ResponseEntity.ok(resposta);
    }
}
