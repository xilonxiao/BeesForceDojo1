package com.bees.brewery;

public class ProcessoMalteacao implements Processo {
    @Override
    public Boolean executar() {
        System.out.println("Umidecer...");
        System.out.println("Secar...");
        System.out.println("Torrar...");
        return true;
    }
}
