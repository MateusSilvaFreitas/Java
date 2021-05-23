/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.denicio.interfaces;

/**
 *
 * @author Denicio
 * @param <T>
 */
public interface iPilha<T> {
    public void push(T v) throws Exception;
    public T pop () throws Exception;
    public boolean vazia();
    public void libera();
}
