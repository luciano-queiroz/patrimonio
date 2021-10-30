package br.com.luque.patrimonio.domain.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDTO {
    
    private String code;
    private String title;
    private String detail;
}
