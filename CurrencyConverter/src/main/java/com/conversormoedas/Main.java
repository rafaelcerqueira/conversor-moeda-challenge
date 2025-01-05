package CurrencyConverter.src.main.java.com.conversormoedas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMoedas conversor = new ConversorMoedas();
        int opcao;

        do {
            System.out.println("*******************");
            System.out.println("Conversor de Moedas");
            System.out.println("*******************");
            System.out.println("1 - Real para Dólar");
            System.out.println("2 - Dólar para Real");
            System.out.println("3 - Real para Euro");
            System.out.println("4 - Euro para Real");
            System.out.println("5 - Real para Peso Argentino");
            System.out.println("6 - Peso Argentino para Real");
            System.out.println("0 - Sair");
            System.out.println("-------------------------");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conversor.converte("BRL", "USD");
                    break;
                case 2:
                    conversor.converte("USD", "BRL");
                    break;
                case 3:
                    conversor.converte("BRL", "EUR");
                    break;
                case 4:
                    conversor.converte("EUR", "BRL");
                    break;
                case 5:
                    conversor.converte("BRL", "ARS");
                    break;
                case 6:
                    conversor.converte("ARS", "BRL");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}
