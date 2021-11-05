package br.com.luque.patrimonio.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.luque.patrimonio.config.ApplicationConstants;
import br.com.luque.patrimonio.domain.dto.BemMovelDTO;
import br.com.luque.patrimonio.domain.entities.BemMovel;
import br.com.luque.patrimonio.services.BemMovelService;

@RestController
@RequestMapping(ApplicationConstants.API_VERSION)
@Validated
public class BemMovelResource {

    @Autowired
    private BemMovelService bemMovelService;

    @PostMapping(path = "/bemmovel")
    @ResponseStatus(HttpStatus.CREATED)
    public BemMovel postBemMovel(@RequestBody @Valid BemMovelDTO body){
        return bemMovelService.adiciona(body);
    }

    @DeleteMapping(path = "/bemmovel")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBemMovel(@RequestHeader Integer codigo){
        bemMovelService.remover(codigo);
    }

    @PutMapping(path = "/bemmovel")
    @ResponseStatus(HttpStatus.OK)
    public void alterarBemMovel(
        @RequestBody @Valid BemMovelDTO body,
        @RequestHeader Integer codigo){

        bemMovelService.alterar(body, codigo);
    }

    @GetMapping(path = "/bemmovel")
    @ResponseStatus(HttpStatus.OK)
    public BemMovel consultaBemMovelPorId(
        @RequestHeader Integer codigo){
            
        return bemMovelService.consultaPorId(codigo);
    }        
    
}
