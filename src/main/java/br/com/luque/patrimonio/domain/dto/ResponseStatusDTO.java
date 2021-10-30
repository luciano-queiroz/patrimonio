package br.com.luque.patrimonio.domain.dto;

import br.com.luque.patrimonio.domain.entities.BaseEntity;
import lombok.Data;

@Data
public abstract class ResponseStatusDTO<T extends BaseEntity>{

    private String code;
    private String status;
    private String message;
    private T data;
    
}
