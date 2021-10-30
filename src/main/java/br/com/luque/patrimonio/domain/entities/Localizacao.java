package br.com.luque.patrimonio.domain.entities;

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
@Table(name = "localizacao")
@AttributeOverride(name = "codigo", column = @Column(name = "cd_localizacao"))
public class Localizacao extends BaseEntity {
    
    @Column(name = "ds_localizacao", length = 45, nullable = false)
    private String descricao;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "cd_sede", referencedColumnName = "cd_sede")
    private Sede sede;
}
