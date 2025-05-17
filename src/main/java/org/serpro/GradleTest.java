package org.serpro;

import java.util.Random;
import java.util.Scanner;

public class GradleTest {
    public static void main(String[] args) {
        System.out.println("Jogo de Advinhação!");
        Scanner scanner = new Scanner(System.in);
        boolean jogarNovamente = true;
        var numeroAleatorio = new Random();
        
        while (jogarNovamente) {
            System.out.println("Adivinhe o número entre 1 e 100.");
            int numeroTentativas = 3;
            int numeroSecreto = numeroAleatorio.nextInt(1,101);
            boolean acertou = false;
            
            while (numeroTentativas > 0 && !acertou) {
                System.out.println("Você tem " + numeroTentativas + " tentativas.");
                System.out.print("Digite seu palpite: ");
                int palpite = scanner.nextInt();

                if (palpite < 1 || palpite > 100) {
                    System.out.println("O número deve estar entre 1 e 100.");
                    continue;
                }

                numeroTentativas--;

                if (palpite == numeroSecreto) {
                    System.out.println("Parabéns! Você acertou o número!");
                    acertou = true;
                } else if (palpite < numeroSecreto) {
                    System.out.println("Muito baixo! Tente novamente.");
                } else {
                    System.out.println("Muito alto! Tente novamente.");
                }
                
                if (numeroTentativas <= 0 && !acertou) {
                    System.out.println("Suas tentativas acabaram! O número correto era: " + numeroSecreto);
                }
            }
            
            System.out.println("Você quer jogar novamente? (s/n)");
            String resposta = scanner.next();
            jogarNovamente = resposta.equalsIgnoreCase("s");
            
            if (!jogarNovamente) {
                System.out.println("Obrigado por jogar!");
            }
        }
    }
}
