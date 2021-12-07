package com.bees.brewery;

public abstract class Maquina {

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
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

    /**
     * Quantidade de ingrediente inserida na máquina
     */
    protected float quantidade;

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

    public float getProdutoFinal() {
        return produtoFinal;
    }

    /**
     * Quantidade de produto resultante dos processos da máquina
     */
    protected float produtoFinal;

    /**
     * Executar processo da maquina
     * @param p processo
     * @return true se com sucesso, false com falha.
     */
    protected abstract Boolean executar(Processo p /* processo. Ex: Moagem, Filtragem, Separação */);
}
