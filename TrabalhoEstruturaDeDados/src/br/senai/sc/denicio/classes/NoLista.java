/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.denicio.classes;

/**
 *
 * @author Denicio
 * @param <T>
 */
public class NoLista<T> {
    private T info;
    private NoLista proximo;
    
    public NoLista() {
        this(null, null);
    }
    
    public NoLista(T elemento, NoLista referencia) {
        info = elemento;
        proximo = referencia;
    }
    
    public T getInfo() {
        return info;
    }
    
    public void setInfo(T elemento) {
        info = elemento;
    }
    
    public NoLista getProximo() {
        return proximo;
    }
    
    public void setProximo(NoLista referencia) {
        proximo = referencia;
    }    
    
    @Override
    public String toString() {
        return info.toString();
    }
}
