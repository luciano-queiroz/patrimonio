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
@Table(name = "bem_movel")
@AttributeOverride(name = "codigo", column = @Column(name = "cd_bem_movel"))
public class BemMovel extends BaseEntity {

    @Column(name = "ds_bem_movel", length = 60, nullable = false)
    private String descricao;

    @Column(name = "no_marca", length = 45, nullable = true)
    private String marca;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "cd_categoria", referencedColumnName = "cd_categoria")
    private Categoria categoria;

}
