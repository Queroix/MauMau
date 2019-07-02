/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartas;

import game.Jogador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author paulo
 */
public class Baralho {

    private Stack<Carta> Monte;
    private Stack<Carta> Deque;

    public Baralho() {
        Deque = new Stack<>();
        Monte = new Stack<>();
        for (int i = 0; i < 10; i++) { //As 40 cartas simples
            String numero = "";
            numero += i;
            CartaSimples cs = new CartaSimples("Verde", numero);
            Deque.push(cs);
            cs = new CartaSimples("Vermelha", numero);
            Deque.push(cs);
            cs = new CartaSimples("Azul", numero);
            Deque.push(cs);
            cs = new CartaSimples("Amarelo", numero);
            Deque.push(cs);
        }
        //as duas Desintegração
        CDesintegracao cd = new CDesintegracao("Vermelha", "X");
        Deque.push(cd);
        cd = new CDesintegracao("Amarelo", "X");
        Deque.push(cd);

        //as duas Ataque Cruel
        CAtaqueCruel cac = new CAtaqueCruel("Verde", "C");
        Deque.push(cac);
        cac = new CAtaqueCruel("Azul", "C");
        Deque.push(cac);

        //as quatro Pulo
        CPulo cp = new CPulo("Verde", "P");
        Deque.push(cp);
        cp = new CPulo("Vermelha", "P");
        Deque.push(cp);
        cp = new CPulo("Azul", "P");
        Deque.push(cp);
        cp = new CPulo("Amarelo", "P");
        Deque.push(cp);

        //as quatro Reversao
        CReversao cr = new CReversao("Verde", "R");
        Deque.push(cr);
        cr = new CReversao("Vermelha", "R");
        Deque.push(cr);
        cr = new CReversao("Azul", "R");
        Deque.push(cr);
        cr = new CReversao("Amarelo", "R");
        Deque.push(cr);

        //as quatro Ataque
        CAtaque ca = new CAtaque("Verde", "A");
        Deque.push(ca);
        ca = new CAtaque("Vermelha", "A");
        Deque.push(ca);
        ca = new CAtaque("Azul", "A");
        Deque.push(ca);
        ca = new CAtaque("Amarelo", "A");
        Deque.push(ca);

        //as quatro Ataque Retroativo
        CAtaqueRetroativo car = new CAtaqueRetroativo("Verde", "T");
        Deque.push(car);
        car = new CAtaqueRetroativo("Vermelha", "T");
        Deque.push(car);
        car = new CAtaqueRetroativo("Azul", "T");
        Deque.push(car);
        car = new CAtaqueRetroativo("Amarelo", "T");
        Deque.push(car);

        //as quatro Ataque Geral
        CAtaqueGeral cag = new CAtaqueGeral("Verde", "G");
        Deque.push(cag);
        cag = new CAtaqueGeral("Vermelha", "G");
        Deque.push(cag);
        cag = new CAtaqueGeral("Azul", "G");
        Deque.push(cag);
        cag = new CAtaqueGeral("Amarelo", "G");
        Deque.push(cag);

        //as quatro Customizadas
        CCustom cc = new CCustom("Verde", "Z");
        Deque.push(cc);
        cc = new CCustom("Vermelha", "Z");
        Deque.push(cc);
        cc = new CCustom("Azul", "Z");
        Deque.push(cc);
        cc = new CCustom("Amarelo", "Z");
        Deque.push(cc);

        Collections.shuffle(Deque);
    }

    public void DestribuirCartas(ArrayList<Jogador> jogadores) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < jogadores.size(); j++) {
                jogadores.get(j).ReceberCarta(Deque.pop());
            }
        }
        Monte.push(Deque.pop());
    }

    public void RefazerDeque() {
        if (Deque.isEmpty()) {
            Carta AntigoTopo = Monte.pop();
            while (!Monte.isEmpty()) {
                Deque.push(Monte.pop());
            }
            Collections.shuffle(Deque);
            Monte.push(AntigoTopo);
        }
    }
    
    public Carta topoMonte(){
        return Monte.peek();
    }
    
    public Carta topoDeque(){
        return Deque.pop();
    }
    
    public void descartada(Carta c){
        Monte.push(c);
    }
    
    

}
