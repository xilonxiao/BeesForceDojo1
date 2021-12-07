package com.bees.brewery.observables;

import java.util.Observable;

public class ProcessoObservable extends Observable {
    private String processo;

    public void setProcesso(String processo) {
        this.processo = processo;
        setChanged();
        notifyObservers(processo);
    }
}
