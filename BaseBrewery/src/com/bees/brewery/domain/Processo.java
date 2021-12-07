package com.bees.brewery.domain;

import java.util.Observable;

public interface Processo {

    Boolean executar(Observable observable, long duration, Observable observableStatus);
}
