package com.bees.brewery;

import java.util.Observable;

public abstract class Maquina {

    /**
     * Quantidade de ingrediente inserida na máquina
     */
    protected float quantidade;

    /**
     * Ingrediente inserido na máquina
     */
    protected String ingrediente;

    /**
     * Capacidade da maquina (kg), positivo. Ex: 99.2 kg
     */
    protected float capacidade;

    /**
     * Vazao da maquina (kg/seg), positivo. Ex: 50.2 kg/seg
     */
    protected float vazao;

    /**
     * Taxa de perdas de material da maquina, em %, positivo. Ex: 2.5%
     */
    protected float taxaDePerdas;

    /**
     * Tempo de execução da maquina, em segundos. Ex: 1000 seg
     */
    protected long tempoDeExecucao;

    /**
     * Quantidade de produto resultante dos processos da máquina
     */
    protected float produtoFinal;

    /**
     * Executar processo da maquina
     * @param p processo
     * @return true se com sucesso, false com falha.
     */
    public abstract Boolean executar(Processo p, Observable observable, Observable observableStatus);

    public float getQuantidade() {
        return quantidade;
    }

    public boolean setQuantidade(float quantidade) {
        if (quantidade <= getCapacidade()) {
            this.quantidade = quantidade;
            return true;
        } else {
            return false;
        }
    }

    public float getCapacidade() {
        return capacidade;
    }

    public float getVazao() {
        return vazao;
    }

    public float getTaxaDePerdas() {
        return taxaDePerdas;
    }

    public long getTempoDeExecucao() {
        return tempoDeExecucao;
    }

    public void setTempoDeExecucao(long tempoDeExecucao) {
        this.tempoDeExecucao = tempoDeExecucao;
    }

    public float getProdutoFinal() {
        return produtoFinal;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }
}
