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
public class ListaEncadeada<T> implements iLista<T> {
    
    private NoLista primeiro;
    private NoLista ultimo;
    private int     contador;

    private boolean estaNoRange(int indice) {
        boolean ret = false;
        if (indice<0 || indice>=contador) {
            throw new ArrayIndexOutOfBoundsException("Índice fora do range da lista");
        }
        else {
            ret = true;
        }
        return ret;
    }
    
    public ListaEncadeada() {
        primeiro = null;
        ultimo   = null;
        contador = 0;
    }


    @Override
    public void add(T eArray) {
        NoLista novo = new NoLista();
        novo.setInfo(eArray);
        
        if (ultimo != null) {
            ultimo.setProximo(novo);
            ultimo = novo;
        } else {
            ultimo = novo;
        }
        
        if (primeiro == null) {
            primeiro = novo;
        }
        contador++;
    }

    @Override
    public void add(int pos, T eArray) {
        if (estaNoRange(pos)) {
            NoLista novo = new NoLista();
            novo.setInfo(eArray);
            // atualiza primeiro elemento
            if (pos==0) {
                novo.setProximo(primeiro);
                primeiro = novo;
                contador++;
            }
            else {
                // Atualiza último elemento
                if (pos==contador-1) {
                    ultimo.setProximo(novo);
                    ultimo = novo;
                    contador++;
                }
                else {
                    // Deve buscar elemento anterior
                    NoLista el = primeiro;
                    NoLista elAnt = null;
                    int iAnt = 0;
                    
                    while (el!=null && iAnt!=pos) {
                        iAnt++;
                        elAnt = el;
                        el = el.getProximo();
                    }
                    
                    if (iAnt!=pos || elAnt==null) {
                        throw new ArrayIndexOutOfBoundsException("Erro ao buscar índice: " + pos);
                    }
                    else {
                        elAnt.setProximo(novo);
                        novo.setProximo(el);
                        contador++;
                    }
                }
            }
        }
    }

    @Override
    public T remove(int indice) {
        T ret = null;
        if (estaNoRange(indice)) {

            // Retorna o primeiro elemento
            if (indice==0) {
                ret = (T) primeiro.getInfo();
                primeiro = primeiro.getProximo();
                contador--;
            }
            else {
                int iAnt = 0;
                NoLista el = primeiro;
                NoLista elAnt = null;
        
                while (el!=null && iAnt!=indice) {
                    iAnt++;
                    elAnt = el;
                    el = el.getProximo();
                }
        
                if (iAnt!=indice || elAnt==null || el==null) {
                    throw new ArrayIndexOutOfBoundsException("Erro ao buscar índice: " + indice);
                }
                else {
                    ret = (T) el.getInfo();
                    // Ajusta último elemento
                    if (indice==contador-1) {
                        ultimo = elAnt;
                        ultimo.setProximo(null);
                    }
                    else {
                        elAnt.setProximo(el.getProximo());
                    }
                    contador--;
                }
            }
        
        }
        
        return ret;
    }

    @Override
    public boolean removeFirst(T eArray) {
        boolean ret = false;
        NoLista el = primeiro;
        NoLista elAnt = null;
        
        while (el!=null && !ret) {
            if (el.equals(eArray)) {
                ret = true;
                
                // É o primeiro elemento
                if (elAnt==null) {
                   primeiro = el.getProximo();
                }
                else {
                    // É o último elemento
                    if (el.getProximo()==null) {
                        ultimo = elAnt;
                        ultimo.setProximo(null);
                    }
                    else {
                        elAnt.setProximo(el.getProximo());
                    }
                }
                contador--;
            }
            elAnt = el;
            el = el.getProximo();
        }
        
        return ret;
    }

    @Override
    public T get(int indice) {
        T ret = null;
        if (estaNoRange(indice)) {
            NoLista el = primeiro;
            int iEl = 0;

            while (el!=null && ret==null) {
                if (iEl==indice) {
                    ret = (T) el.getInfo();
                }
                el = el.getProximo();
                iEl++;
            }
        }
        
        return ret;
    }

    @Override
    public void clear() {
        primeiro = null;
        ultimo   = null;
        contador = 0;
    }

    @Override
    public T set(int indice, T eArray) {
        T ret = null;
        if (estaNoRange(indice)) {
            NoLista el = primeiro;
            int iEl = 0;

            while (el!=null && ret==null) {
                if (iEl==indice) {
                    ret = (T) el.getInfo();
                    el.setInfo(eArray);
                }
                el = el.getProximo();
                iEl++;
            }
        }
        
        return ret;
    }

    @Override
    public int size() {
        return contador;
    }

    @Override
    public boolean isEmpty() {
        return contador <= 0;
    }

    @Override
    public boolean contains(T eArray) {
        boolean ret = false;
        NoLista el = primeiro;

        while (el!=null && !ret) {
            ret = el.equals(eArray);
            el = el.getProximo();
            
        }
        
        return ret;
    }

    @Override
    public int indexOf(T eArray) {
        int ret = -1;
        NoLista el = primeiro;
        int iEl = 0;
        
        while (el!=null && ret==-1) {
            if (el.equals(eArray)) {
                ret = iEl;
            }
            el = el.getProximo();
            iEl++;
        }
        
        return ret;
    }

    @Override
    public int lastIndexOf(T eArray) {
        int ret = -1;
        NoLista el = primeiro;
        int iEl = 0;
        
        while (el!=null) {
            if (el.equals(eArray)) {
                ret = iEl;
            }
            el = el.getProximo();
            iEl++;
        }
        
        return ret;
    }

    @Override
    public T[] toArray() {
        T[] ret = null;
        int indice = 0;

        if (contador>0) {
            ret = (T[]) new Comparable[contador];
            NoLista el = primeiro;            
            while (el != null) {
                ret[indice] = (T) el.getInfo();
                el = el.getProximo();
                indice++;
            }
        }
        
        return ret;
    }
    
}
