/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.torresdehanoi;

import br.senai.sc.mateus.PilhaArray;

/**
 *
 * @author Denicio
 */
public class TorreArray implements TorreHanoi{
    private final PilhaArray<Integer> t;
    private int tamanho;
    
    public TorreArray() {
        this(5);
    }
    
    public TorreArray(int discos) {
        t = new PilhaArray<>(discos);
        tamanho = 0;
    }
    @Override
    public void push(int disco) throws Exception {
        t.push(disco);
        tamanho++;
    }

    @Override
    public int pop() throws Exception {
        tamanho--;
        return t.pop();
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean vazia() {
        return t.vazia();
    }
}
