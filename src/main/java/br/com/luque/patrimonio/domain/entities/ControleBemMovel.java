package br.com.luque.patrimonio.domain.entities;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.luque.patrimonio.domain.enuns.EnumEstadoConservacao;
import br.com.luque.patrimonio.domain.enuns.EnumSimNao;
import lombok.Data;

@Data
@Entity
@Table(name = "controle_bem_movel")
@AttributeOverride(name = "codigo", column = @Column(name = "cd_controle_bem_movel"))
public class ControleBemMovel extends BaseEntity {

    @Column(name = "cd_etiqueta_patrimonio", length = 32, nullable = true)
    private String etiqueta;

    @Column(name = "dt_atualizacao", nullable = false)
    private LocalDate dataAtualizacao;

    @Column(name = "sg_estado_conservacao", length = 1, nullable = false)
    private EnumEstadoConservacao estadoConservacao;

    @Column(name = "tx_observacao", nullable = true)
    private String observacao;

    @Column(name = "st_novo", length = 1, nullable = false)
    private EnumSimNao novo;

    @Column(name = "vl_bem_movel", precision = 15, scale = 2, nullable = false)
    private Double valor;

    @Column(name = "st_doacao", length = 1, nullable = false)
    private EnumSimNao doacao;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "cd_bem_movel", referencedColumnName = "cd_bem_movel")
    private BemMovel bemMovel;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "cd_nota_fiscal", referencedColumnName = "cd_nota_fiscal")
    private NotaFiscal notaFiscal;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "cd_localizacao", referencedColumnName = "cd_localizacao")
    private Localizacao localizacao;
    
}
