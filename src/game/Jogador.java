/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import cartas.Carta;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Jogador {

    private String nomeJogador;
    private ArrayList<Carta> maoJogador;

    public Jogador(String Nome) {
        maoJogador = new ArrayList<>();
        this.nomeJogador = Nome;
    }

    public String getNome() {
        return nomeJogador;
    }

    public void setMao(ArrayList<Carta> c) {
        maoJogador = c;
    }

    public ArrayList<Carta> getMao() {
        return maoJogador;
    }

    public void ReceberCarta(Carta c) {
        this.maoJogador.add(c);
    }

    public Carta descartarCarta(Carta c) {
        this.maoJogador.remove(c);
        return c;
    }

    public void passarVez(Jogo j) {
        System.out.println("O jogador " + this.nomeJogador + " comprou uma carta.");
        j.comprarCarta();
        j.proximo();
    }

}
