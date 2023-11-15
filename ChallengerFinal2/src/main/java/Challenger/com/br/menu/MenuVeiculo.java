package Challenger.com.br.menu;

import Challenger.com.br.Api.VeiculoAPI;

import java.util.Scanner;
public class MenuVeiculo {
    public static String mostrarMenu(String placa, String carro) {
        System.out.println("Menu do seu veículo");
        System.out.println("Sua placa é: " + placa);
        System.out.println("Seu carro é: " + carro);

        VeiculoAPI veiculoAPI = new VeiculoAPI();

        String imagemUrl = veiculoAPI.obterImagemPorModelo(carro);

        if (imagemUrl != null) {
            System.out.println("Imagem do seu veículo: " + imagemUrl);
        } else {
            System.out.println("Imagem do veículo não encontrada.");
        }

        System.out.println("Quer realizar um chamado? (Digite 'sim' ou 'nao')");
        Scanner scanner = new Scanner(System.in);
        String resposta = scanner.nextLine();

        if ("sim".equalsIgnoreCase(resposta)) {
            // Se a resposta for "sim", chame o método diretamente na classe Chamado
            Chamado.realizarChamado();
        }

        return imagemUrl;
    }
}


