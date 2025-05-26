package com.Gestao.Eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gestao.Eventos.entities.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

   }


		    
