package br.com.luque.patrimonio.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luque.patrimonio.config.ApplicationConstants;
import br.com.luque.patrimonio.domain.dto.CategoriaDTO;
import br.com.luque.patrimonio.domain.entities.BaseEntity;
import br.com.luque.patrimonio.domain.entities.Categoria;
import br.com.luque.patrimonio.services.CategoriaService;

@RestController
@RequestMapping(ApplicationConstants.API_VERSION)
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping(path = "/categoria")
    public ResponseEntity<Categoria> postCategoria(@RequestBody CategoriaDTO body){
        Categoria response = categoriaService.adicionar(body);
        return new ResponseEntity<Categoria>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/categoria")
    public ResponseEntity deleteCategoria(@RequestBody CategoriaDTO body){
        categoriaService.remover(body);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }    
    
}
