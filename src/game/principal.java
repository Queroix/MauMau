/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Gabriel
 */
public class principal {

    public static void main(String[] args) {

        Scanner tc = new Scanner(System.in);
        boolean status = true;

        System.out.print("Digite a quantidades de jogadores: ");
        int qtJogadores = tc.nextInt();
        if (qtJogadores >= 2) {
            //pode jogar
            ArrayList<Jogador> ListaJogadores = new ArrayList();
            for (int i = 1; i <= qtJogadores; i++) {
                System.out.printf("Digite o nome do %dº jogador: ", i);
                Jogador x = new Jogador(tc.next());
                ListaJogadores.add(x);
            }

            Jogo game = new Jogo(ListaJogadores);
            while (status == true) {
                System.out.println("--------------------------------------------------");
                System.out.println("Jogador " + game.getJogadorAtivo().getNome());
                System.out.println("--------------------------------------------------");
                System.out.println("Carta do topo do monte: " + game.getBaralho().topoMonte().getCor() + " " + game.getBaralho().topoMonte().getSimbolo());
                System.out.println("1- Checar mão\n2- Jogar carta\n3- Passar vez\n0- Encerrar o jogo");
                int op = tc.nextInt();
                System.out.println("--------------------------------------------------");

                switch (op) {
                    case 1:
                        System.out.println("--------------------------------------------------");
                        System.out.println("Mao de " + game.getJogadorAtivo().getNome() + ":");
                        for (int i = 0; i < game.getJogadorAtivo().getMao().size(); i++) {
                            System.out.println(i + " " + game.getJogadorAtivo().getMao().get(i).getCor()
                                    + " " + game.getJogadorAtivo().getMao().get(i).getSimbolo());
                        }
                        System.out.println("--------------------------------------------------");
                        break;

                    case 2:
                        System.out.print("Digite o ID da carta a ser descartada: ");
                        int id = tc.nextInt();
                        if (id < game.getJogadorAtivo().getMao().size()) {
                            game.getJogadorAtivo().getMao().get(id).descartar(game);
                        } else {
                            System.out.println("ID invalido");
                        }
                        break;

                    case 3:
                        game.getJogadorAtivo().passarVez(game);
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        break;

                    case 0:
                        System.out.println("Fim de jogo");
                        status = false;
                        break;

                    default:
                        System.out.println("-TECLA INVALIDA-");
                        break;
                }
                if (game.getJogadores().size() < 2) {
                    System.out.println(game.getJogadores().get(0).getNome() + "Ganhou!");
                    status = false;
                } else if (game.getJogadores().get(game.jogadorAnterior()).getMao().isEmpty()) {
                    System.out.println(game.getJogadores().get(game.jogadorAnterior()).getNome() + "Ganhou!");
                    status = false;
                }

            }

        } //nao tem jogadores suficientes
        else {
            System.out.println("Minimo de 2 jogadores necessarios");
        }
    }
}
