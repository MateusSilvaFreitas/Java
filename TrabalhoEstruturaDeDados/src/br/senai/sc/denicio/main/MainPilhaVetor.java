/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.denicio.main;

import br.senai.sc.denicio.classes.PilhaVetor;

/**
 *
 * @author Denicio
 */
public class MainPilhaVetor {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        PilhaVetor<Integer> pilha = new PilhaVetor(6);
        
        pilha.push(9);
        pilha.push(59);
        pilha.push(8);
        pilha.push(990);
        pilha.push(149);
        pilha.push(51);
        //pilha.push(7);
        
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
