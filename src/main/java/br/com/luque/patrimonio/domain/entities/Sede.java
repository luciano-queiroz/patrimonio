package br.com.luque.patrimonio.domain.entities;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "sede")
@AttributeOverride(name = "codigo", column = @Column(name = "cd_sede"))
public class Sede extends BaseEntity {

    @Column(name = "ds_sede", length = 60, nullable = false)
    private String nome;

    @Column(name = "tx_bairro", length = 45, nullable = true)
    private String bairro;

    @Column(name = "tx_cidade", length = 45, nullable = false)
    private String cidade;

    @Column(name = "sg_uf", length = 2, nullable = false)
    private String uf;

    @Column(name = "nu_endereco", length = 10, nullable = true)
    private String numero;

    @Column(name = "nu_cep", length = 8, nullable = true)
    private String cep;

    @Column(name = "tx_logradouro", length = 60, nullable = false)
    private String logradouro;

    @Column(name = "dt_fundacao", nullable = true)
    private LocalDate dataFundacao;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "cd_instituicao", referencedColumnName = "cd_instituicao")
    private Instituicao instituicao;
}
