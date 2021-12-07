package com.bees.brewery.domain;

import com.bees.brewery.core.RandomUtil;

import java.util.Observable;

public class MaquinaFiltragem extends Maquina {

    public static int MIN_TIME_IN_MINUTES = 55;
    public static int MAX_TIME_IN_MINUTES = 65;
    public static int MINUTES_TO_MILLISECONDS = 100;

    @Override
    public Boolean executar(Processo p, Observable observable, Observable observableStatus) {
        return p.executar(observable, getDuration(), observableStatus);
    }

    public long getDuration() {
        return (long) (RandomUtil.getRandom(MIN_TIME_IN_MINUTES, MAX_TIME_IN_MINUTES) * MINUTES_TO_MILLISECONDS);
    }
}
