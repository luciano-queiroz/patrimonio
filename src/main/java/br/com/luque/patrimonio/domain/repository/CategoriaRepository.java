package br.com.luque.patrimonio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luque.patrimonio.domain.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
