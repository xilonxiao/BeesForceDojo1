package com.bees.brewery.domain;

import com.bees.brewery.core.Status;
import com.bees.brewery.observables.ProcessoObservable;
import com.bees.brewery.observables.StatusObservable;

import java.util.Arrays;
import java.util.List;
import java.util.Observable;

public class ProcessoMalteacao implements Processo {
    private List<String> processosInternos = Arrays.asList("Umedecer", "Secar", "Torrar");

    @Override
    public Boolean executar(Observable observableProcesso, long duration, Observable observableStatus) {
        Thread execution = new Thread("ProcessoMalteacao Thread") {
            public void run() {
                ((StatusObservable) observableStatus).setStatus(Status.IN_PROGRESS_MALTEACAO);

                for (String processoInterno: processosInternos) {
                    ((ProcessoObservable) observableProcesso).setProcesso(processoInterno +"...");

                    try {
                        sleep(duration/ processosInternos.size());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                ((StatusObservable) observableStatus).setStatus(Status.FINISHED_MALTEACAO);
            }
        };
        execution.start();
        return true;
    }
}
