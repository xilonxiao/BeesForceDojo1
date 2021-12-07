package com.bees.brewery.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Observable;

public class MaquinaMalteacaoTest {

    private Maquina maquina;
    private Processo processo;

    @Before
    public void setup() {
        processo = new ProcessoMalteacao();
        maquina = new MaquinaMalteacao();
    }

    @Test
    public void checkIfExecuteMethodReturnsTrue() {
        Observable anyObservable = new Observable();
        Boolean success = maquina.executar(processo, anyObservable, anyObservable);

        Assert.assertTrue(success);
    }

    @Test
    public void checkMaquinaMalteacaoCapacidade() {
        float capacidade = maquina.getCapacidade();

        Assert.assertEquals(MaquinaMalteacao.CAPACIDADE, capacidade, 0.1);
    }

    @Test
    public void checkMaquinaMalteacaoProdutoFinal() {
        maquina.setQuantidade(500);
        float produtoFinal = maquina.getProdutoFinal();

        Assert.assertTrue(produtoFinal >= 475);
        Assert.assertTrue(produtoFinal <= 495);
    }

    @Test
    public void checkMaquinaMalteacaoVazao() {
        maquina.setQuantidade(500);
        float vazao = maquina.getVazao();

        Assert.assertEquals(MaquinaMalteacao.VAZAO, vazao, 0.1);
    }

    @Test
    public void checkSetQuantidadeMalteacaoOK() {
        Assert.assertTrue(maquina.setQuantidade(750));
    }

    @Test
    public void checkSetQuantidadeMalteacaoNotOK() {
        Assert.assertFalse(maquina.setQuantidade(1200));
    }
}