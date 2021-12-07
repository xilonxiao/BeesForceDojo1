package com.bees.brewery;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        Maquina maquinaMalteacao = new MaquinaMalteacao();
        Processo processoUmidecer = new ProcessoMalteacao();

        maquinaMalteacao.executar(processoUmidecer);

//        SwingExamples examples = new SwingExamples();
//        examples.execute();
    }
}
