package br.senai.sc.denicio.main;

import br.senai.sc.denicio.classes.ListaComArray;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Denicio
 */
public class MainListaComArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaComArray<String> lca = new ListaComArray<>();
        String aPos;
        boolean bPos;
        int iPos;
        
        lca.add("40");
        lca.add("21");
        lca.add("80");
        lca.add("35");
        lca.add("73");
        lca.add("5");
        lca.add("8");
        
        System.out.println("Tamanho do array: " + lca.size());

        System.out.println(lca.get(2));
        lca.add(2, "99");
        System.out.println("Novo tamanho do array: " + lca.size());
        System.out.println(lca.get(2));
        System.out.println(lca.get(3));
        
        aPos = lca.remove(5);
        System.out.println("Tamanho após remove(): " + lca.size());
        if (aPos != null) {
            System.out.println("Elemento removido: " + aPos);
        }
        
        bPos = lca.removeFirst("100");
        if (bPos) {
            System.out.println("Elemento removido: 100");
        }
        else {
            System.out.println("Elemento 100 não foi removido, porque não existe!");
        }
        
        bPos = lca.removeFirst("99");
        if (bPos) {
            System.out.println("Elemento removido: 99");
        }
        else {
            System.out.println("Elemento 99 não foi removido, porque não existe!");
        }
        
        System.out.println("Tamanho após removeFirst(): " + lca.size());

        lca.add("101");
        lca.add("44");
        lca.add("38");
        lca.add("98");
        lca.add("20");
        lca.add("61");
        
        System.out.println("Tamanho: " + lca.size());
        
        iPos = lca.indexOf("20");
        if (iPos>=0) {
            System.out.println("Posição do elemento 20: " + iPos);
        }
        else {
            System.out.println("Elemento 20 não existe!");
        }
        
        iPos = lca.lastIndexOf("98");
        if (iPos>=0) {
            System.out.println("Última posição do elemento 98: " + iPos);
        }
        else {
            System.out.println("Elemento 98 não existe!");
        }
        
        System.out.println("-----------------------");
        System.out.println("Lista array");
        System.out.println("-----------------------");
        
        Comparable[] str;
        str = lca.toArray();
        for (Comparable s : str){
            System.out.println("["+(String)s+"]");
        }
    }
    
}
