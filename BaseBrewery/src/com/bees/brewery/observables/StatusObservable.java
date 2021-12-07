package com.bees.brewery.observables;

import com.bees.brewery.core.Status;

import java.util.Observable;

public class StatusObservable extends Observable {
    private Status status;

    public void setStatus(Status status) {
        this.status = status;
        setChanged();
        notifyObservers(status);
    }

    public Status getStatus() {
        return this.status;
    }
}
