/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.denicio.main;

import br.senai.sc.denicio.classes.ListaEncadeada;

/**
 *
 * @author Denicio
 */
public class MainListaEncadeada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaEncadeada<Integer> l = new ListaEncadeada();
        
        l.add(9);
        l.add(15);
        l.add(2);
        l.add(33);
        l.add(7);
        
        l.add(1, 76);
        l.add(0, 5);
        l.add(6, 8);
        l.add(4, 31);
        
        Comparable[] lInt;
        lInt = l.toArray();
        for (Comparable i : lInt){
            System.out.println("["+(Integer)i+"]");
        }

        System.out.println("------- FIM ------");
        l.remove(2);
        l.remove(0);
        
        lInt = l.toArray();
        for (Comparable i : lInt){
            System.out.println("["+(Integer)i+"]");
        }

        System.out.println("------- FIM ------");
        if (l.removeFirst(2)) {
            System.out.println("2- removido");
        }
        
        if (l.removeFirst(9)) {
            System.out.println("9- removido");
        }
        
        if (l.removeFirst(8)) {
            System.out.println("8- removido");
        }

        lInt = l.toArray();
        for (Comparable i : lInt){
            System.out.println("["+(Integer)i+"]");
        }
        
        System.out.println("------- FIM ------");
        
        if ( !l.removeFirst(109)) {
            System.out.println("109- NÃO removido");
        }

        lInt = l.toArray();
        for (Comparable i : lInt){
            System.out.println("["+(Integer)i+"]");
        }
        
        System.out.println("------- BUSCA ÍNDICE 2 ------");
        Integer iE = l.get(2);
        System.out.println("["+iE+"]");

        System.out.println("------- SUBSTITUI ÍNDICE 2 ------");
        iE = l.set(2, 88);
        System.out.println("["+iE+"]");

        System.out.println("------- BUSCA ÍNDICE 2 ------");
        iE = l.get(2);
        System.out.println("["+iE+"]");
        
        if (l.contains(133)) {
            System.out.println("[133] existe na lista");
        }
        else {
            System.out.println("[133] NÃO existe na lista");
        }

        if (l.contains(7)) {
            System.out.println("[7] existe na lista");
        }
        else {
            System.out.println("[7] NÃO existe na lista");
        }

        l.add(455);
        l.add(66);
        l.add(387);
        l.add(67);
        l.add(401);
        l.add(1);
        l.add(66);
        l.add(14);
        
        System.out.println("[" + l.indexOf(66) + "] Posição do elemento 66");
        System.out.println("[" + l.lastIndexOf(66) + "] Última posição do elemento 66");
        System.out.println("[" + l.indexOf(1007) + "] Posição do elemento 1007");
        
        System.out.println("------- FIM ------");
        
        lInt = l.toArray();
        for (Comparable i : lInt){
            System.out.println("["+(Integer)i+"]");
        }
        
        System.out.println("Tamanho da lista: " + l.size());
    }
    
}
