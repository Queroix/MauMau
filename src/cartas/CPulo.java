/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartas;

import game.Jogo;

/**
 *
 * @author paulo
 */
public class CPulo extends Carta {

    public CPulo(String Cor, String Simbolo) {
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

            j.proximo();
            System.out.println("O jogador " + j.getJogadorAtivo().getNome() + " foi pulado.");
            j.proximo();
        } else {
            System.out.println("Nao foi possivel jogar esta carta.");
        }
    }

}
