package br.com.luque.patrimonio.domain.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "instituicao")
@AttributeOverride(name = "codigo", column = @Column(name = "cd_instituicao"))
public class Instituicao extends BaseEntity {
    
    @Column(name = "no_instituicao", length = 60, nullable = false)
    private String nome;

    @Column(name = "nu_cnpj", length = 14, nullable = true)
    private String cnpj;

    @Column(name = "nu_telefone_1", length = 30, nullable = true)
    private String telefonePrincipal;    

    @Column(name = "nu_telefone_2", length = 30, nullable = true)
    private String telefoneAdicional;
    
    @Column(name = "tx_email", length = 75, nullable = true)
    private String email;    

    @Column(name = "sg_instituicao", length = 45, nullable = true)
    private String sigla;
    
    @Column(name = "dt_fundacao", nullable = true)
    private String dataFundacao;    
}
