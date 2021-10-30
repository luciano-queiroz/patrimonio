package br.com.luque.patrimonio.domain.entities;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "nota_fiscal")
@AttributeOverride(name = "codigo", column = @Column(name = "cd_nota_fiscal"))
public class NotaFiscal extends BaseEntity {

    @Column(name = "nu_nota_fiscal", length = 32, nullable = false)
    private String numero;

    @Column(name = "nu_serie", length = 32, nullable = true)
    private String serie;

    @Column(name = "dt_nota_fiscal", nullable = true)
    private LocalDate dataEmissao;

    @Column(name = "vl_nota_fiscal", nullable = false, precision = 15, scale = 2)
    private Double valor;

}
