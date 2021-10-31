package br.com.luque.patrimonio.domain.dto;

import javax.persistence.Basic;

import lombok.Data;

@Data
public class CategoriaDTO {
    
    @Basic(optional = true)
    private Integer codigo;

    @Basic(optional = false)
    private String descricao;

}
