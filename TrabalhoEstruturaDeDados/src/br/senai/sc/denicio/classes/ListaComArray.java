/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.denicio.classes;

import br.senai.sc.denicio.interfaces.iLista;

/**
 *
 * @author Denicio
 * @param <T>
 */
public class ListaComArray<T> implements iLista<T> {

    private T[] array;
    private boolean resizable;
    private int initialCapacity;
    private int counter;
    private static final int X = 3;
    
    public ListaComArray (int initialCapacity, boolean resizable) {
        this.initialCapacity = initialCapacity;
        this.resizable = resizable;
        this.counter = 0;
        this.array = (T[]) new Comparable[this.initialCapacity];
    }

    public ListaComArray() {
        this(X, true);
    }

    public ListaComArray(int initialCapacity) {
        this(initialCapacity, true);
    }
    
    @Override
    public void add(T eArray) {
        resizeArrayList();
        array[counter] = eArray;
        counter++;
    }

    @Override
    public void add(int pos, T eArray) {
        resizeArrayList();
        T copia;
        
        for (int i=pos; i<counter; i++) {
            if (i==pos) {
                copia = array[i];
                array[i] = eArray;
                eArray = copia;
                counter++;
            }
            else
            if (i>pos) {
                copia = array[i];
                array[i] = eArray;
                eArray = copia;
            }
        }
    }

    @Override
    public T remove(int indice) {
        if (indice<0 || indice>counter-1) {
            throw new ArrayIndexOutOfBoundsException("Índice fora do range da lista");
        }
        
        T ret = null;
        if (indice < counter) {
            ret = array[indice];
            
            for (int i=indice; i<counter-1; i++) {
                array[i] = array[i+1];
            }
            array[counter-1] = null;
            counter--;
        }
        return ret;
    }

    @Override
    public boolean removeFirst(T eArray) {
        boolean ret = false;
        for (int i=0; i<counter; i++) {
            if (array[i].equals(eArray)) {
                ret = true;
                for (int z=i; z<counter-1; z++) {
                    array[z] = array[z+1];
                }
                array[counter-1] = null;
                counter--;
                break;
            }
        }
        return ret;
    }

    @Override
    public T get(int indice) {
        if (indice<0 || indice>counter-1) {
            throw new ArrayIndexOutOfBoundsException("Índice fora do range da lista");
        }
        return array[indice];
    }

    @Override
    public void clear() {
        for (int i=0; i<counter-1; i++) {
            array[i] = null;
        }
        counter = 0;
    }

    @Override
    public T set(int indice, T eArray) {
        if (indice<0 || indice>counter-1) {
            throw new ArrayIndexOutOfBoundsException("Índice fora do range da lista");
        }
        T aAntes = array[indice];
        array[indice] = eArray;
        return aAntes;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }
    
    public boolean isFull() {
        return counter == array.length;
    }

    @Override
    public boolean contains(T eArray) {
        boolean ret = false;
        int i = 0;
        
        while (!ret && i<counter) {
            ret = array[i].equals(eArray);
            i++;
        }
        return ret;
    }

    @Override
    public int indexOf(T eArray) {
        int ret = -1;
        int i = 0;
        
        while (ret<0 && i<counter) {
            if (array[i].equals(eArray)) {
                ret = i;
            }
            i++;
        }
        return ret;
    }

    @Override
    public int lastIndexOf(T eArray) {
        int ret = -1;
        int i = counter-1;
        
        while (ret<0 && i>=0) {
            if (array[i].equals(eArray)) {
                ret = i;
            }
            i--;
        }
        return ret;
    }

    @Override
    public T[] toArray() {
        T[] ret = (T[]) new Comparable[counter];
        System.arraycopy(array, 0, ret, 0, counter);
        return ret;       
    }

    private void resizeArrayList() {
        if (counter >= array.length) {
            if (!resizable) {
                throw new ArrayIndexOutOfBoundsException("Limite do array atingido");
            }
            
            T[] copia = (T[]) new Comparable[counter + X];

            System.arraycopy(array, 0, copia, 0, counter);
            array = copia;
        }
    }
    
}
