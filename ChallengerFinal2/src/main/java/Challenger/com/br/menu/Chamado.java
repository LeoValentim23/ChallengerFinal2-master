package Challenger.com.br.menu;

import Challenger.com.br.guincho.*;
import Challenger.com.br.service.InputUtils;

import java.util.Scanner;

public class Chamado {
    public static boolean realizarChamado() {
        System.out.println("Chamado");


        try (Scanner scanner = InputUtils.createScanner()) {
            String respostaTombado = InputUtils.obterRespostaTombado();
            int tipoModificacao = InputUtils.obterTipoModificacao();

            boolean veiculoTombado = respostaTombado.equalsIgnoreCase("S");

            System.out.println("Seu veículo contém modificações?");
            System.out.println("1. Número de eixos");
            System.out.println("2. Carga");
            System.out.println("3. Tipo de carga");

            switch (tipoModificacao) {
                case 1:
                    // Lógica para modificação do número de eixos
                    break;
                case 2:
                    // Lógica para modificação da carga
                    break;
                case 3:
                    // Lógica para modificação do tipo de carga
                    break;
                default:
                    System.out.println("Opção de modificação inválida.");
                    break;
            }

            Guincho[] guinchos = {
                    new GuinchoPesadoComPlatHidraulicaMunck(),
                    new GuinchoPesadoComPlataformaHidraulicaEBand(),
                    new GuinchoPesadoComQuintaRodaELanca(),
                    new GuinchoPesadoComQuintaRodaPesadoComTorreELanca(),
                    new GuinchoPesadoNãoPadrao(),
                    new GuinchoTecnicoPesadoParaQuinchoPesado()
            };

            int guinchoSelecionado = -1;
            double diferencaPesoMaisProximo = Double.MAX_VALUE;


            for (int i = 0; i < guinchos.length; i++) {
                double pesoVeiculo = 0.0;
                if (guinchos[i].pesoAdequado((int) pesoVeiculo) && (!veiculoTombado || guinchos[i].podeLevantarTombado())) {
                    double capacidadePesoGuincho = guinchos[i].getCapacidadePeso();
                    double diferencaPeso = Math.abs(capacidadePesoGuincho - pesoVeiculo);
                    if (diferencaPeso < diferencaPesoMaisProximo) {
                        diferencaPesoMaisProximo = diferencaPeso;
                        guinchoSelecionado = i;
                    }
                }
            }

            if (guinchoSelecionado != -1) {
                Guincho guincho = guinchos[guinchoSelecionado];
                System.out.println("Guincho selecionado: " + guincho.getNome());
            } else {
                System.out.println("Nenhum guincho disponível para o veículo informado.");
            }

            return veiculoTombado;
        }
    }
}
