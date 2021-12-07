package com.bees.brewery;

import java.util.Observable;

public class MalteacaoObservable extends Observable {
    private String status;

    public void setStatus(String status) {
        this.status = status;
        setChanged();
        notifyObservers(status);
    }
}
