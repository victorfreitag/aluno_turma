package com.turma_aluno.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turma_aluno.entities.Turma;
import com.turma_aluno.repository.TurmaRepository;


@Service
public class TurmaService {

	private final TurmaRepository TurmaRepository;

	@Autowired
	public TurmaService(TurmaRepository TurmaRepository) {
		this.TurmaRepository = TurmaRepository;
	}

	public List<Turma> buscaTodosTurma(){
		return TurmaRepository.findAll();
	}

	public Turma buscaTurmaId (Long id) {
		Optional <Turma> Aluno = TurmaRepository.findById(id);
		return Aluno.orElse(null);			
	}

	public Turma salvaTurma(Turma cliente) {
		return TurmaRepository.save(cliente);
	}

	public Turma alterarTurma(Long id, Turma alterarTurma) {
		Optional <Turma> existeTurma = TurmaRepository.findById(id);
		if (existeTurma.isPresent()) {
			alterarTurma.setId(id);
			return TurmaRepository.save(alterarTurma);
		}
		return null;
	}		

	public boolean apagarTurma(Long id) {
		Optional <Turma> existeTurma = TurmaRepository.findById(id);
		if (existeTurma.isPresent()) {
			TurmaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}