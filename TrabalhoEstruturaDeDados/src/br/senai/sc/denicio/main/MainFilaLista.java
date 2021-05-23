/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.denicio.main;

import br.senai.sc.denicio.classes.FilaLista;

/**
 *
 * @author Denicio
 */
public class MainFilaLista {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        FilaLista<Integer> lst = new FilaLista();
        
        lst.insere(56);
        lst.insere(23);
        lst.insere(2);
        lst.insere(7);
        lst.insere(8);
        lst.insere(4);
        lst.insere(16);
        
        System.out.println("Retirado: " + lst.retira());
        System.out.println("Retirado: " + lst.retira());
        
        lst.insere(100);
        lst.insere(200);
        
        System.out.println("Retirado: " + lst.retira());
        System.out.println("Retirado: " + lst.retira());
        
        lst.insere(17);
        lst.insere(58);
        lst.insere(34);
        lst.insere(166);
        
        System.out.println("");
        System.out.println("Limpa lista");
        
        while (!lst.vazia()) {
            System.out.println("Retirado: " + lst.retira());
        }
    }
    
}
