package com.bees.brewery;

public abstract class Armazenamento<Liquido> {

    /**
     * Altura do armazenamento, em metros.
     */
    protected int altura;

    /**
     * Largura do armazenamento, em metros.
     */
    protected int largura;

    /**
     * Profundidade do armazenamento, em metros.
     */
    protected int profundidade;

    /**
     * Tipo de liquido armazenado.
     */
    protected Liquido tipoDeLiquido;

    /**
     * Temperatura do liquido, em Celsius.
     */
    protected float temperaturaDoLiquido;

    /**
     * Tempo de armazenamento do liquido, em segundos.
     */
    protected long tempoDeArmazenamento;
}
