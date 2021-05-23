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
public class PilhaLista<T> implements iPilha<T> {

    private NoLista topo = null;
    
    @Override
    public void push(T v) throws Exception {
        NoLista no = new NoLista();
        no.setInfo(v);
        no.setProximo(topo);
        topo = no;
    }

    @Override
    public T pop() throws Exception {
        if (topo != null) {
            NoLista ant = topo;
            topo = topo.getProximo();
            return (T) ant.getInfo();
        }
        else {
            throw new ArrayIndexOutOfBoundsException("Não existem elementos na pilha");
        }
    }

    @Override
    public boolean vazia() {
        return topo == null;
    }

    @Override
    public void libera() {
        topo = null;
    }
    
}
