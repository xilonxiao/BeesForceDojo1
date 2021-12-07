package com.bees.brewery.domain;

import com.bees.brewery.core.RandomUtil;

import java.util.Observable;

public class MaquinaMalteacao extends Maquina {

    public static float CAPACIDADE = 1000;
    public static float VAZAO = 100;
    public static int TAXA_PERDA_MIN = 1;
    public static int TAXA_PERDA_MAX = 5;
    public static int HUNDRED_PER_CENT = 100;
    public static int SECONDS_TO_MILLISECONDS = 1000;

    @Override
    public Boolean executar(Processo p, Observable observable, Observable observableStatus) {
        return p.executar(observable, getDuration(), observableStatus);
    }

    public long getDuration() {
        return (long) (getQuantidade()/VAZAO) * SECONDS_TO_MILLISECONDS;
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
        return (float) RandomUtil.getRandom(TAXA_PERDA_MIN, TAXA_PERDA_MAX) / HUNDRED_PER_CENT;
    }
}
