package br.com.luque.patrimonio.domain.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CategoriaDTO {
    
    private Integer codigo;

    @NotBlank(message = "Descrição não pode estar em branco")
    private String descricao;

}
