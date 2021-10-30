package br.com.luque.patrimonio.domain.enuns;

public enum EnumEstadoConservacao {

    RUIM("R"), BOM("B"), OTIMO("O");

    private String valor;

    EnumEstadoConservacao(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }
}
