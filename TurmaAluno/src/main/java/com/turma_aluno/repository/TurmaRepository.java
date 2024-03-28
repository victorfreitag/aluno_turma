package com.turma_aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turma_aluno.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
	
	
}