package com.bees.brewery.domain;

import com.bees.brewery.core.RandomUtil;

import java.util.Observable;

public class MaquinaBrassagem extends Maquina {

    public static int DURACAO_MIN = 60;
    public static int DURACAO_MAX = 90;
    public static int TEMPERATURA_FERVURA = 100;

    @Override
    public Boolean executar(Processo p, Observable observable, Observable observableStatus) {
        return p.executar(observable, getDuration(), observableStatus);
    }

    public long getDuration() {
        return (long) (RandomUtil.getRandom(60, 90) * 100);
    }
}
