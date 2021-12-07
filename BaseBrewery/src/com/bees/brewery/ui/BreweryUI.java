package com.bees.brewery.ui;

import com.bees.brewery.domain.*;
import com.bees.brewery.core.Grao;
import com.bees.brewery.core.Status;
import com.bees.brewery.observables.ProcessoObservable;
import com.bees.brewery.observables.StatusObservable;

import javax.swing.*;
import java.awt.*;

public class BreweryUI {

    ProcessoObservable processoObservable = new ProcessoObservable();
    StatusObservable statusObservable = new StatusObservable();
    JFrame frame;

    JLabel label_status_brasagem;
    JLabel label_status_filtragem;
    JLabel label_status_fervura;
    JButton button_malteacao;

    public void execute() {

        createFrame();
        createPanelMalteacao();
        createPanelBrasagem();
        createPanelFiltragem();
        createFervura();

    }

    private void createFrame() {
        frame = new JFrame("Cervejaria Weiss");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label_processos;
        label_processos = new JLabel("Processos");
        label_processos.setBounds(150, 20, 100, 30);

        frame.setSize(385, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void createPanelMalteacao() {

        JPanel panel_malteacao = new JPanel();
        panel_malteacao.setBounds(10, 50, 350, 150);
        panel_malteacao.setBackground(Color.gray);

        JLabel label_malteacao;
        label_malteacao = new JLabel("Malteação");
        label_malteacao.setBounds(20, 50, 100, 30);

        JLabel label_tipo_grao;
        label_tipo_grao = new JLabel("Selecione o seu grão:");
        label_tipo_grao.setBounds(20, 80, 150, 30);
        String tipo_grao[] = {
                Grao.ARROZ.getValue(),
                Grao.AVEIA.getValue(),
                Grao.TRIGO.getValue(),
                Grao.MILHO.getValue(),
                Grao.CEVADA.getValue()
        };

        JComboBox combo_box_tipo_grao = new JComboBox(tipo_grao);
        combo_box_tipo_grao.setBounds(150, 85, 90, 20);

        JLabel label_quant_kg;
        label_quant_kg = new JLabel("Quantidade em Kg:");
        label_quant_kg.setBounds(20, 105, 150, 30);

        JTextArea area_quant_kg = new JTextArea();
        area_quant_kg.setBounds(150, 110, 90, 20);

        JLabel label_status;
        label_status = new JLabel("");
        label_status.setBounds(20, 130, 300, 60);

        button_malteacao = new JButton("Inicializar");
        button_malteacao.setBounds(250, 550, 110, 40);

        button_malteacao.addActionListener(e -> {
            if(campoNumerico(area_quant_kg.getText())){
                Maquina maquinaMalteacao = new MaquinaMalteacao();
                Maquina maquinaBrassagem = new MaquinaBrassagem();
                Maquina maquinaFiltragem = new MaquinaFiltragem();
                Maquina maquinaFervura = new MaquinaFervura();

                if (maquinaMalteacao.setQuantidade(Float.parseFloat(area_quant_kg.getText()))) {
                    Processo processoMalteacao = new ProcessoMalteacao();
                    Processo processoBrassagem = new ProcessoBrassagem();
                    Processo processoFiltragem = new ProcessoFiltragem();
                    Processo processoFervura = new ProcessoFervura();

                    maquinaMalteacao.setIngrediente(tipo_grao[combo_box_tipo_grao.getSelectedIndex()]);

                    processoObservable.addObserver((observable, arg) -> {
                        if (Status.IN_PROGRESS_BRASSAGEM.equals(statusObservable.getStatus())) {
                            label_status_brasagem.setText((String) arg);
                        } else if (Status.IN_PROGRESS_MALTEACAO.equals(statusObservable.getStatus())) {
                            label_status.setText((String) arg);
                        } else if (Status.IN_PROGRESS_FILTRAGEM.equals(statusObservable.getStatus())) {
                            label_status_filtragem.setText((String) arg);
                        } else if (Status.IN_PROGRESS_FERVURA.equals(statusObservable.getStatus())) {
                            label_status_fervura.setText((String) arg);
                        }
                    });

                    statusObservable.addObserver((o, arg) -> {
                        if (Status.FINISHED_MALTEACAO.equals(arg)) {
                            float resultado = maquinaMalteacao.getProdutoFinal();
                            label_status.setText("Processo de Malteação Finalizado! Gerou: " + resultado + " Kgs de Malte");

                            maquinaBrassagem.setQuantidade(resultado);
                            maquinaBrassagem.setIngrediente("Malte");
                            maquinaBrassagem.executar(processoBrassagem, processoObservable, statusObservable);
                        } else if (Status.FINISHED_BRASSAGEM.equals(arg)) {
                            label_status_brasagem.setText("Processo de Brassagem Finalizado!");

                            maquinaFiltragem.executar(processoFiltragem, processoObservable, statusObservable);
                        } else if (Status.FINISHED_FILTRAGEM.equals(arg)) {
                            label_status_filtragem.setText("Processo de Filtragem Finalizado!");

                            maquinaFervura.executar(processoFervura, processoObservable, statusObservable);
                        } else if (Status.FINISHED_FERVURA.equals(arg)) {
                            label_status_fervura.setText("Processo de Fervura Finalizado!");
                        }
                    });

                    maquinaMalteacao.executar(processoMalteacao, processoObservable, statusObservable);
                } else {
                    label_status.setText("O valor digitado está acima da capaciade da máquina!!");
                }
            }else{
                label_status.setText("Digitar apenas números!!");
            }
        });

        frame.add(label_malteacao);
        frame.add(label_tipo_grao);
        frame.add(label_quant_kg);
        frame.add(area_quant_kg);
        frame.add(button_malteacao);
        frame.add(label_status);
        frame.add(panel_malteacao);
        frame.add(combo_box_tipo_grao);

    }

    private void createPanelBrasagem() {

        JPanel panel_brasagem = new JPanel();
        panel_brasagem.setBounds(10, 210, 350, 100);
        panel_brasagem.setBackground(Color.gray);
        JLabel label_brasagem;

        label_brasagem = new JLabel("Brasagem");
        label_brasagem.setBounds(20, 210, 100, 30);

        label_status_brasagem = new JLabel("");
        label_status_brasagem.setBounds(20, 260, 300, 30);

        frame.add(label_brasagem);
        frame.add(label_status_brasagem);
        frame.add(panel_brasagem);
    }

    private void createPanelFiltragem() {

        JPanel panel_filtragem = new JPanel();
        panel_filtragem.setBounds(10, 320, 350, 100);
        panel_filtragem.setBackground(Color.gray);

        JLabel label_filtragem;
        label_filtragem = new JLabel("Filtragem");
        label_filtragem.setBounds(20, 320, 100, 30);


        label_status_filtragem = new JLabel("");
        label_status_filtragem.setBounds(20, 350, 300, 30);


        frame.add(label_filtragem);
        frame.add(label_status_filtragem);
        frame.add(panel_filtragem);
    }

    private void createFervura(){

        JPanel panel_fervura = new JPanel();
        panel_fervura.setBounds(10, 430, 350, 100);
        panel_fervura.setBackground(Color.gray);

        JLabel label_fervura;
        label_fervura = new JLabel("Fervura");
        label_fervura.setBounds(20, 430, 100, 30);

        label_status_fervura = new JLabel("");
        label_status_fervura.setBounds(20, 450, 300, 30);

        frame.add(label_fervura);
        frame.add(label_status_fervura);
        frame.add(panel_fervura);
    }

    private boolean campoNumerico(String campo) {
        return campo.matches("[0-9]+");
    }
}