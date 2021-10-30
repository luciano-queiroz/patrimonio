package br.com.luque.patrimonio.domain.enuns;

public enum EnumSimNao {

    SIM("S"), NAO("N");

    private String valor;

    EnumSimNao(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }
}
