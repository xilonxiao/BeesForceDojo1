package com.bees.brewery;

import java.util.Observable;

public class ProcessoMalteacao implements Processo {
    @Override
    public Boolean executar(Observable observable) {
        Thread execution = new Thread("MaquinaMalteacao Thread") {
            public void run() {
                ((MalteacaoObservable) observable).setStatus("Umidecer...");
                try {
                    sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ((MalteacaoObservable) observable).setStatus("Secar...");
                try {
                    sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ((MalteacaoObservable) observable).setStatus("Torrar...");
            }
        };
        execution.start();
        return true;
    }
}
