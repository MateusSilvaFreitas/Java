/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.denicio.classes;

import br.senai.sc.denicio.interfaces.iFila;

/**
 *
 * @author Denicio
 * @param <T>
 */
public class FilaVetor<T> implements iFila<T> {

    private int n;
    private int ini;
    private int tam;
    private T[] vet;
    
    public FilaVetor() {
        this(10);
    }
    
    public FilaVetor(int tamanho) {
        n = 0;
        ini = -1;
        tam = tamanho;
        vet = (T[]) new Comparable[tam];
    }
    
    @Override
    public void insere(T v) throws Exception {
        int fim;
        if (n < tam) {
            if (ini < 0) {
                ini = 0;
            }
            
            fim = (ini + n) % tam;
            vet[fim] = v;
            n++;
        }
        else {
            throw new ArrayIndexOutOfBoundsException("Limite da lista atingido");
        }
    }

    @Override
    public T retira() throws Exception {
        T result;
        if (ini >= 0) {
            result = (T)vet[ini];
            
            if (ini < tam -1) {
                ini++;
            }
            else {
                ini = 0;
            }
            n--;
            return result;
        }
        else {
            throw new ArrayIndexOutOfBoundsException("Não existem elementos na lista");
        }
    }

    @Override
    public boolean vazia() {
        return n==0;
    }

    @Override
    public void libera() {
        for (int i = 0; i < tam; i++) {
            vet[i] = null;
        }
        n = 0;
        ini = -1;
    }
    
}
