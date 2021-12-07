package com.bees.brewery;

import java.util.Observable;

public class MalteacaoObservable extends Observable {
    private String processo;

    public void setProcesso(String processo) {
        this.processo = processo;
        setChanged();
        notifyObservers(processo);
    }
}
