package br.com.luque.patrimonio.domain.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(name = "codigo")
    @GeneratedValue
    private Integer codigo;
}
