/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.torresdehanoi;

import br.senai.sc.mateus.PilhaLinked;

/**
 *
 * @author Denicio
 */
public class TorreLinked implements TorreHanoi {
    private final PilhaLinked<Integer> t;
    private int tamanho;
    
    public TorreLinked() {
        t = new PilhaLinked<>();
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
