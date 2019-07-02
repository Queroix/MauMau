/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartas;

import game.Jogador;
import game.Jogo;

/**
 *
 * @author paulo
 */
public class CAtaqueGeral extends Carta {

    public CAtaqueGeral(String Cor, String Simbolo) {
        super(Cor, Simbolo);
    }

    @Override
    public void descartar(Jogo j) {
        if (j.getBaralho().topoMonte().getCor().equals(this.getCor()) || j.getBaralho().topoMonte().getSimbolo().equals(this.getSimbolo())) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
            j.getJogadorAtivo().descartarCarta(this);
            j.getBaralho().descartada(this);
            System.out.println("A carta " + this.getCor() + " " + this.getSimbolo() + " foi jogada ao monte.");

            Jogador atual = j.getJogadorAtivo();
            j.getJogadores().get(j.jogadorProximo()).ReceberCarta(j.getBaralho().topoDeque());
            j.getJogadores().get(j.jogadorProximo()).ReceberCarta(j.getBaralho().topoDeque());
            j.proximo();
            System.out.println("O jogador " + j.getJogadorAtivo().getNome() + " comprou duas cartas.");
            while (j.getJogadorAtivo() != atual) {
                j.getJogadores().get(j.jogadorProximo()).ReceberCarta(j.getBaralho().topoDeque());
                j.getJogadores().get(j.jogadorProximo()).ReceberCarta(j.getBaralho().topoDeque());
                j.proximo();
                System.out.println("O jogador " + j.getJogadorAtivo().getNome() + " comprou duas cartas.");
            }
            j.proximo();
        } else {
            System.out.println("Nao foi possivel jogar esta carta.");
        }
    }

}
