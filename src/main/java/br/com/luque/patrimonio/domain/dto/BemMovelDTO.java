package br.com.luque.patrimonio.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BemMovelDTO {
    
    @NotBlank(message = "Descrição não pode estar em branco")
    @Size(max = 60)
    private String descricao;

    @Size(max = 45)
    private String marca;

    @JsonProperty("categoria")
    @NotNull(message = "Código da categoria não pode ser nulo.")
    private Integer codigoCategoria;

}
