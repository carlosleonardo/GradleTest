package org.serpro;

import java.util.Scanner;

public class GradleTest {
    public static void main(String[] args) {
        System.out.println("Jogo de advinhação!");
        System.out.println("Adivinhe o número entre 1 e 100.");
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;
        int numeroTentativas = 3;
        int numeroSecreto = (int) (Math.random() * 100) + 1;
        while (numeroTentativas != 0 && continua) {
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
                break;
            } else if (palpite < numeroSecreto) {
                System.out.println("Muito baixo! Tente novamente.");
            } else {
                System.out.println("Muito alto! Tente novamente.");
            }

            if (numeroTentativas <= 0) {
                System.out.println("Você perdeu! O número era: " + numeroSecreto);
                System.out.println("Você quer continuar jogando? (s/n)");
                String resposta = scanner.next();
                if (resposta.equalsIgnoreCase("n")) {
                    continua = false;
                    System.out.println("Obrigado por jogar!");
                } else {
                    numeroTentativas = 3;
                    numeroSecreto = (int) (Math.random() * 100) + 1;
                }
            }
        }
    }
}
