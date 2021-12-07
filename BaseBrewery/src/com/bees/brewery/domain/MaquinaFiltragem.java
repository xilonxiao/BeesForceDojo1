package com.bees.brewery.domain;

import com.bees.brewery.core.RandomUtil;

import java.util.Observable;

public class MaquinaFiltragem extends Maquina {

    @Override
    public Boolean executar(Processo p, Observable observable, Observable observableStatus) {
        return p.executar(observable, getDuration(), observableStatus);
    }

    public long getDuration() {
        return (long) (RandomUtil.getRandom(55, 65) * 100);
    }
}
