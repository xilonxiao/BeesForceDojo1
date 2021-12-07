package com.bees.brewery.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Observable;

public class MaquinaFervuraTest {

    private MaquinaFervura maquina;
    private ProcessoFervura processo;

    @Before
    public void setup() {
        processo = new ProcessoFervura();
        maquina = new MaquinaFervura();
    }

    @Test
    public void checkIfExecuteMethodReturnsTrue() {
        Observable anyObservable = new Observable();
        Boolean success = maquina.executar(processo, anyObservable, anyObservable);

        Assert.assertTrue(success);
    }
}
