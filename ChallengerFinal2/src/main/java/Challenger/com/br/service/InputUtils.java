package Challenger.com.br.service;

import java.util.Scanner;

public class InputUtils {

        public static Scanner createScanner() {
            return new Scanner(System.in);
        }
    private static final Scanner scanner = new Scanner(System.in);


    public static String obterRespostaTombado() {
        System.out.println("O veículo está tombado? (S/N):");
        return scanner.nextLine().toUpperCase();
    }


    public static int obterTipoModificacao() {
        System.out.println("Seu veículo contém modificações?");
        System.out.println("1. Número de eixos");
        System.out.println("2. Carga");
        System.out.println("3. Tipo de carga");

        // Lê a resposta como um número inteiro
        return scanner.nextInt();
    }
}

