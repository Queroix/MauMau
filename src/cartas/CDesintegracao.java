/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartas;

import game.Jogador;
import game.Jogo;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author paulo
 */
public class CDesintegracao extends Carta {

    public CDesintegracao(String Cor, String Simbolo) {
        super(Cor, Simbolo);
    }

    @Override
    public void descartar(Jogo j) {
        if (j.getBaralho().topoMonte().getCor().equals(this.getCor()) || j.getBaralho().topoMonte().getSimbolo().equals(this.getSimbolo())) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
            j.getJogadorAtivo().getMao().remove(this);
            j.getBaralho().descartada(this);
            System.out.println("A carta " + this.getCor() + " " + this.getSimbolo() + " foi jogada ao monte.");

            Random random = new Random();
            int id1 = random.nextInt(j.getJogadores().size());
            System.out.println("O jogador " + j.getJogadores().get(id1).getNome() + " foi escolhido para ser remido do jogo.");

            ArrayList<Jogador> atualizado = j.getJogadores();
            atualizado.remove(id1);
            j.setJogadores(atualizado);

            j.proximo();
        } else {
            System.out.println("Nao foi possivel jogar esta carta.");
        }
    }

}
