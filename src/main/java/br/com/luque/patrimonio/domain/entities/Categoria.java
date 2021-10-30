package br.com.luque.patrimonio.domain.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "categoria")
@AttributeOverride(name = "codigo", column = @Column(name = "cd_categoria"))
public class Categoria extends BaseEntity {
    
    @Column(name = "ds_categoria", length = 45, nullable = false)
    private String descricao;

}
