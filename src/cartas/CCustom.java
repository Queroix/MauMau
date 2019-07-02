/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartas;

import game.Jogo;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author paulo
 */
public class CCustom extends Carta {

    public CCustom(String Cor, String Simbolo) {
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
            int id1 = random.nextInt(j.getJogadores().size()),
                    id2 = random.nextInt(j.getJogadores().size());

            while (id1 == id2) {
                id1 = random.nextInt(j.getJogadores().size());
                id2 = random.nextInt(j.getJogadores().size());
            }
            
            ArrayList<Carta> aux = j.getJogadores().get(id1).getMao();
            j.getJogadores().get(id1).setMao(j.getJogadores().get(id2).getMao());
            j.getJogadores().get(id2).setMao(aux);
            System.out.printf("Os jogadores %s e %s trocaram seus baralhos.", j.getJogadores().get(id1).getNome(), j.getJogadores().get(id2).getNome());

            j.proximo();
        } else {
            System.out.println("Nao foi possivel jogar esta carta.");
        }
    }

}
