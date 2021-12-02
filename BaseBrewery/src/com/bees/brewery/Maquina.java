package com.bees.brewery;

public abstract class Maquina {

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
     * Executar processo da maquina
     * @param p processo
     * @return true se com sucesso, false com falha.
     */
    protected abstract Boolean executar(Processo p /* processo. Ex: Moagem, Filtragem, Separação */);
}
