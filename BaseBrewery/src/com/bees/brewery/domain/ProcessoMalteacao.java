package com.bees.brewery.domain;

import com.bees.brewery.core.Status;
import com.bees.brewery.observables.MalteacaoObservable;
import com.bees.brewery.observables.StatusObservable;

import java.util.Arrays;
import java.util.List;
import java.util.Observable;

public class ProcessoMalteacao implements Processo {
    private List<String> processosInternos = Arrays.asList("Umedecer", "Secar", "Torrar");

    @Override
    public Boolean executar(Observable observableProcesso, long duration, Observable observableStatus) {
        Thread execution = new Thread("MaquinaMalteacao Thread") {
            public void run() {
                for (String processoInterno: processosInternos) {
                    ((MalteacaoObservable) observableProcesso).setProcesso(processoInterno +"...");

                    try {
                        sleep(duration/ processosInternos.size());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                ((StatusObservable) observableStatus).setStatus(Status.FINISHED);
            }
        };
        execution.start();
        return true;
    }
}
