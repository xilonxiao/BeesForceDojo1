package com.bees.brewery.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Observable;

public class MaquinaFiltragemTest {

    private MaquinaFiltragem maquina;
    private ProcessoFiltragem processo;

    @Before
    public void setup() {
        processo = new ProcessoFiltragem();
        maquina = new MaquinaFiltragem();
    }

    @Test
    public void checkIfExecuteMethodReturnsTrue() {
        Observable anyObservable = new Observable();
        Boolean success = maquina.executar(processo, anyObservable, anyObservable);

        Assert.assertTrue(success);
    }

    @Test
    public void checkGetDurationRandomMilliseconds() {
        long duration = maquina.getDuration();

        Assert.assertTrue(duration >= 5500);
        Assert.assertTrue(duration <= 6500);
    }
}
