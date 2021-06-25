/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.torresdehanoi;

import java.util.Scanner;

/**
 *
 * @author Denicio
 */
public class TorresDeHanoi {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    
    
    public static void main(String[] args) throws Exception {
        boolean contigua = true;
        boolean sobre = false;
        boolean dinamica = false;
        for (String arg : args) {
            contigua = contigua || ("contigua".equalsIgnoreCase(arg) || "contígua".equalsIgnoreCase(arg));
            sobre = sobre || ("sobre".equalsIgnoreCase(arg));
            dinamica = dinamica || ("dinamica".equalsIgnoreCase(arg));
        }
        
        if (sobre) {
            System.out.println("Alunos: Denicio Fritzke");
            System.out.println("        Mateus Silva Freitas");
        }
        if (contigua || dinamica) {
            int tOrigem = 0;
            int tDestino = 0;
            Scanner ent = new Scanner(System.in);
            String rMov = "";
            TorresDeHanoiJogo torre = new TorresDeHanoiArray();
            if (contigua) {
                torre = new TorresDeHanoiArray();
                System.out.println("Utilizando lista contigua...");
            }else if(dinamica) {
                torre = new TorresDeHanoiLinked();
                System.out.println("Utilizando lista dinâmica...");
            }
            torre = new TorresDeHanoiLinked();
            torre.IniciaJogo(retornaValor(ent, "Digite a quantidade de discos: \n"));
            while (!torre.fimDeJogo() && !"CANCEL".equals(rMov)) {
                tOrigem = retornaValor(ent, "Digite a torre de origem: \n");
                tDestino = retornaValor(ent, "Digite a torre de destino: \n");
                rMov = torre.moveDisco(tOrigem, tDestino);
                System.out.println(rMov != null ? rMov : "");
            }
        } else if(!sobre){
        	throw new Exception("Não foi passado nenhuma informação por parâmetros para o jar, por favor informe: contigua, dinamica ou sobre.");
        }        
    }

    private static int retornaValor(Scanner ent, String s) {
        boolean valorValido;
        int valor = 0;
        do {
            try {
                System.out.print(s);
                valor = Integer.parseInt(ent.nextLine());
                if(s.contains("torre de") && valor > 3) {
                	throw new Exception();
                }
                valorValido = true;
            } catch (Exception e) {
                System.out.println("Valor digitado inválido.");
                valorValido = false;
            }
        } while (!valorValido);
        return valor;
    }

}
