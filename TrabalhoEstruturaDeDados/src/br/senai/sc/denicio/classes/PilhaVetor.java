/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.denicio.classes;

import br.senai.sc.denicio.interfaces.iPilha;

/**
 *
 * @author Denicio
 * @param <T>
 */
public class PilhaVetor<T> implements iPilha<T> {

    private int n;
    private int tam;
    private T[] vet;
    
    public PilhaVetor() {
        this(10);
       
    }

    public PilhaVetor(int tamanho) {
        n = 0;
        tam = tamanho;
        vet = (T[]) new Comparable[tam];
    }

    @Override
    public void push(T v) throws Exception {
        if (n < tam) {
            n++;
            vet[n-1] = v;
        }
        else {
            throw new ArrayIndexOutOfBoundsException("Limite da pilha atingido");
        }
    }

    @Override
    public T pop() throws Exception {
        if (n > 0) {
            T ret = vet[n-1];
            n--;
            return (T) ret;
        }
        else {
            throw new ArrayIndexOutOfBoundsException("Não existem elementos na pilha");
        }
    }

    @Override
    public boolean vazia() {
        return n==0;
    }

    @Override
    public void libera() {
        n = 0;
        for (int i = 0; i < tam; i++) {
            vet[i] = null;
        }
    }
    
}
