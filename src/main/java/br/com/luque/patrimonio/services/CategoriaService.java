package br.com.luque.patrimonio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import br.com.luque.patrimonio.domain.dto.CategoriaDTO;
import br.com.luque.patrimonio.domain.entities.Categoria;
import br.com.luque.patrimonio.domain.repository.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria adicionar(CategoriaDTO dto){
        Categoria categoria = Categoria.builder().descricao(dto.getDescricao()).build();
        return categoriaRepository.save(categoria);
    }

    public void remover(Integer codCategoria){
        categoriaRepository.delete(findCategoria(codCategoria));
    }

    public void alterar(CategoriaDTO dto, Integer codCategoria){
        Categoria categoria = findCategoria(codCategoria);

        categoria.setDescricao(dto.getDescricao());
        categoriaRepository.save(categoria);
    }    

    public Categoria consultaPorId(Integer codCategoria){
        return findCategoria(codCategoria);
    }    

    public Categoria findCategoria(Integer codCategoria) {
        Optional<Categoria> categoria = categoriaRepository.findById(codCategoria);
        if (!categoria.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Código da categoria não encontrado");
        }
        return categoria.get();
    }
}
