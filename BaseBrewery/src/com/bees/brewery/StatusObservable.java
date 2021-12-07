package com.bees.brewery;

import java.util.Observable;

public class StatusObservable extends Observable {
    private Status status;

    public void setStatus(Status status) {
        this.status = status;
        setChanged();
        notifyObservers(status);
    }
}
