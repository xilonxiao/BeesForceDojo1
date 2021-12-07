package com.bees.brewery;

import java.util.Observable;

public class MaquinaMalteacao extends Maquina {

    public static float CAPACIDADE = 1000;
    public static float VAZAO = 100;
    public static int TAXA_PERDA_MIN = 1;
    public static int TAXA_PERDA_MAX = 5;

    @Override
    public Boolean executar(Processo p, Observable observable, Observable observableStatus) {
        return p.executar(observable, getDuration(), observableStatus);
    }

    public long getDuration() {
        return (long) (getQuantidade()/VAZAO) * 1000;
    }

    @Override
    public float getCapacidade() {
        return CAPACIDADE;
    }

    @Override
    public float getProdutoFinal() {
        return getQuantidade() - (getQuantidade() * getTaxaDePerdas());
    }

    @Override
    public float getVazao() {
        return VAZAO;
    }

    @Override
    public float getTaxaDePerdas() {
        return (float) RandomUtil.getRandom(TAXA_PERDA_MIN, TAXA_PERDA_MAX) / 100;
    }
}
