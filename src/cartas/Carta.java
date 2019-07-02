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
public abstract class Carta {

    protected String cor;
    protected String simbolo;

    public Carta(String Cor, String Simbolo) {
        this.cor = Cor;
        this.simbolo = Simbolo;
    }

    public String getCor() {
        return cor;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public abstract void descartar(Jogo J);
}
