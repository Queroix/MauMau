/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import cartas.Baralho;
import cartas.Carta;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Gabriel
 */
public class Jogo {

    private ArrayList<Jogador> jogadores;
    private Baralho baralho;
    private int jogadorAtivo;
    private int direcao;

    public Jogo(ArrayList<Jogador> jogadores) {
        this.baralho = new Baralho();
        this.jogadores = jogadores;
        this.baralho.DestribuirCartas(this.jogadores);
        this.jogadorAtivo = 0;
        this.direcao = 1;
    }

    public Baralho getBaralho() {
        return baralho;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public Jogador getJogadorAtivo() {
        return jogadores.get(jogadorAtivo);
    }

    public void setJogadorAtivo(int jogadorAtivo) {
        this.jogadorAtivo = jogadorAtivo;
    }

    public int getDirecao() {
        return direcao;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }

    public void comprarCarta() {
        getJogadorAtivo().ReceberCarta(baralho.topoDeque());
    }

    public void proximo() {
        jogadorAtivo += direcao;
        if (jogadorAtivo == jogadores.size()) {
            jogadorAtivo = 0;
        } else {
            if (jogadorAtivo < 0) {
                jogadorAtivo = jogadores.size()-1;
            }
        }
    }

    public int jogadorAnterior() {
        int ja = jogadorAtivo - direcao;
        if (ja == jogadores.size()) {
            ja = 0;
        } else {
            if (ja < 0) {
                ja = jogadores.size()-1;
            }
        }
        return ja;
    }

    public int jogadorProximo() {
        int jp = jogadorAtivo + direcao;
        if (jp == jogadores.size()) {
            jp = 0;
        } else {
            if (jp < 0) {
                jp = jogadores.size()-1;
            }
        }
        return jp;
    }

    public boolean gameOver() {
        if (jogadores.size() < 2) {
            System.out.println("Fim de jogo!");
            return false;
        } else if (jogadores.get(jogadorAnterior()).getMao().isEmpty()) {
            System.out.println("Fim de jogo!");
            return false;
        }
        return true;
    }

}
