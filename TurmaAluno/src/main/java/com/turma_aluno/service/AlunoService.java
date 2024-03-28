package com.turma_aluno.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turma_aluno.entities.Aluno;
import com.turma_aluno.repository.AlunoRepository;


@Service
public class AlunoService {

	private final AlunoRepository AlunoRepository;

	@Autowired
	public AlunoService(AlunoRepository AlunoRepository) {
		this.AlunoRepository = AlunoRepository;
	}

	public List<Aluno> buscaTodosAluno(){
		return AlunoRepository.findAll();
	}

	public Aluno buscaAlunoId (Long id) {
		Optional <Aluno> Aluno = AlunoRepository.findById(id);
		return Aluno.orElse(null);			
	}

	public Aluno salvaAluno(Aluno cliente) {
		return AlunoRepository.save(cliente);
	}

	public Aluno alterarAluno(Long id, Aluno alterarAluno) {
		Optional <Aluno> existeAluno = AlunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			alterarAluno.setId(id);
			return AlunoRepository.save(alterarAluno);
		}
		return null;
	}

	public boolean apagarAluno(Long id) {
		Optional <Aluno> existeAluno = AlunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			AlunoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}