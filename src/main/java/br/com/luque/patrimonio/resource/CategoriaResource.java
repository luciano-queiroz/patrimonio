package br.com.luque.patrimonio.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.luque.patrimonio.config.ApplicationConstants;
import br.com.luque.patrimonio.domain.dto.CategoriaDTO;
import br.com.luque.patrimonio.domain.entities.Categoria;
import br.com.luque.patrimonio.services.CategoriaService;

@RestController
@RequestMapping(ApplicationConstants.API_VERSION)
@Validated
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping(path = "/categoria")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria postCategoria(@RequestBody @Valid CategoriaDTO body){
        return categoriaService.adicionar(body);
    }

    @DeleteMapping(path = "/categoria/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategoria(
        @PathVariable Integer codigo){
        categoriaService.remover(codigo);
    }

    @PutMapping(path = "/categoria/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public void alterarCategoria(
        @RequestBody @Valid CategoriaDTO body,
        @PathVariable Integer codigo){

        categoriaService.alterar(body, codigo);
    }

    @GetMapping(path = "/categoria/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria consultaCategoriaPorId(
        @PathVariable Integer codigo){
            
        return categoriaService.consultaPorId(codigo);
    }    
}
