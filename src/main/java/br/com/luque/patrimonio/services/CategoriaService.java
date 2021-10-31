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
        if(ObjectUtils.isEmpty(dto) || dto.getDescricao().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY,"Descrição não pode ser vazia.");
        }

        Categoria categoria = Categoria.builder().descricao(dto.getDescricao()).build();
        return categoriaRepository.save(categoria);
    }

    public void remover(CategoriaDTO dto){
        if (ObjectUtils.isEmpty(dto) || dto.getCodigo().toString().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY,"Código não pode ser vazio");
        }
        Optional<Categoria> categoria = categoriaRepository.findById(dto.getCodigo());
        if (!categoria.isPresent()){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Código não encontrado");
        }
        categoriaRepository.delete(categoria.get());
    }
}
