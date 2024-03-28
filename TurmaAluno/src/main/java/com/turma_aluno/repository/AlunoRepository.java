package com.turma_aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turma_aluno.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	
}