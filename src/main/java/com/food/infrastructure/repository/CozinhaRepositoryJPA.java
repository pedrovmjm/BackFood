package com.food.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.food.domain.model.Cozinha;
import com.food.domain.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryJPA implements CozinhaRepository{

	@PersistenceContext
	private EntityManager manager;
		
	@Override
	public List<Cozinha> listar() {
		return manager.createQuery("from Cozinha", Cozinha.class)
				.getResultList();
	}

	@Override
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}

	@Transactional
	@Override
	public Cozinha salvar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}

	@Transactional
	@Override
	public void remover(Cozinha cozinha) {
		cozinha= buscar(cozinha.getId());
		manager.remove(cozinha);
	}

	
}
