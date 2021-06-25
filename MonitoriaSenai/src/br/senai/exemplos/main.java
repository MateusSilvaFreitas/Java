package br.senai.exemplos;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String texto = "O meu texto";

        long numerosTambem = 10;
        float numerosQuebrados = 1.6F;
        double numerosQuebradosTambem = 7.5;
        boolean verdadeiroOuFalso = true;

        int numeros, numeros2;
        String operador;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número: ");
        numeros = scanner.nextInt();
        System.out.println("Digite outro número: ");
        numeros2 = scanner.nextInt();
        System.out.println("Digite o operador: ");
        operador = scanner.nextLine();
        switch (operador){
            case "+":
                //Código
                break;
            case "-":
                //Código
                break;

            case "*":
                //Código
                break;

            case "/":
                //Código
                break;

            default:
                //Código
                break;
        }
    }
}
