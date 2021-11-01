package br.com.luque.patrimonio.domain.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NotFound;

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

    @Basic(optional = false)
    @Column(name = "ds_categoria", length = 45, nullable = false)
    @NotBlank
    private String descricao;

}
