package com.bees.brewery;

public class MaquinaMalteacao extends Maquina {
    @Override
    protected Boolean executar(Processo p) {
        return p.executar();
    }
}
