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
public interface iLista<T> {
    public void add(T eArray);
    public void add(int pos, T eArray);
    public T remove(int indice);    
    public boolean removeFirst(T eArray);
    public T get(int indice);
    public void clear();
    public T set(int indice, T eArray);
    public int size();
    public boolean isEmpty();
    public boolean contains(T eArray);
    public int indexOf(T eArray);
    public int lastIndexOf(T eArray);
    public T[] toArray(); 
}
