package br.com.luque.patrimonio.domain.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoria")
@AttributeOverride(name = "codigo", column = @Column(name = "cd_categoria"))
public class Categoria extends BaseEntity {

    @Column(name = "ds_categoria", length = 45, nullable = false)
    private String descricao;

}
