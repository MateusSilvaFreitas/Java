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
public class FilaLista<T> implements iFila<T> {

    private NoLista ini;
    private NoLista fim;
    private int n;
    
    /**
     *
     */
    public FilaLista() {
        n = 0;
        ini = null;
        fim = null;
    }
        
    /**
     *
     * @param v
     * @throws Exception
     */
    @Override
    public void insere(T v) throws Exception {
        NoLista no = new NoLista();
        no.setInfo(v);
        n++;
        
        if (ini==null) {
            ini = no;
        }
        
        if (fim!=null) {
            fim.setProximo(no);
            fim = no;
        }
        else {
            fim = no;
        }
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public T retira() throws Exception {
        if (n <= 0) {
            throw new ArrayIndexOutOfBoundsException("Lista vazia!"); //To change body of generated methods, choose Tools | Templates.
        }
        else {
            NoLista ant = ini;
            ini = ant.getProximo();
            n--;
            return (T) ant.getInfo();
        }
    }

    /**
     *
     * @return
     */
    @Override
    public boolean vazia() {
        return n ==0;
    }

    /**
     *
     */
    @Override
    public void libera() {
        n = 0;
        ini = null;
        fim = null;
    }
    
}
