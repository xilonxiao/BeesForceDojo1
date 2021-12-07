package com.bees.brewery.domain;

import java.util.Observable;

public class MaquinaFervura extends Maquina {

    public static long ONE_SECOND_TO_A_PROCESS = 4000;

    @Override
    public Boolean executar(Processo p, Observable observable, Observable observableStatus) {
        return p.executar(observable, ONE_SECOND_TO_A_PROCESS, observableStatus);
    }
}
