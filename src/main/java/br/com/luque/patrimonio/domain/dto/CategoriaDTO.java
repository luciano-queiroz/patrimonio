package br.com.luque.patrimonio.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CategoriaDTO {
    
    @NotBlank(message = "Descrição não pode estar em branco")
    @Size(max = 45)
    private String descricao;

}
