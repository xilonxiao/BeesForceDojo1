package com.bees.brewery.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Observable;

public class MaquinaBrassagemTest {

    private MaquinaBrassagem maquina;
    private ProcessoBrassagem processo;

    @Before
    public void setup() {
        processo = new ProcessoBrassagem();
        maquina = new MaquinaBrassagem();
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

        Assert.assertTrue(duration >= 6000);
        Assert.assertTrue(duration <= 9000);
    }

}
