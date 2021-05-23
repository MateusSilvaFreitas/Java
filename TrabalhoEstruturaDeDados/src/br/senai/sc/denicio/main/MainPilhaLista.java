/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.denicio.main;

import br.senai.sc.denicio.classes.PilhaLista;

/**
 *
 * @author Denicio
 */
public class MainPilhaLista {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        PilhaLista<Integer> pilha = new PilhaLista();
        
        pilha.push(9);
        pilha.push(59);
        pilha.push(8);
        pilha.push(990);
        pilha.push(149);
        pilha.push(51);
        pilha.push(7);
        pilha.push(38);
        pilha.push(171);
        pilha.push(1000);
        pilha.push(11);
        pilha.push(12);
        pilha.push(64);
        
        System.out.println("Retirado: " + pilha.pop());
        System.out.println("Retirado: " + pilha.pop());
        
        pilha.push(17);
        
        System.out.println("");
        System.out.println("Limpa lista");
        
        while (!pilha.vazia()) {
            System.out.println("Retirado: " + pilha.pop());
        }
    }
    
}
