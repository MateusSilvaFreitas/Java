/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.torresdehanoi;

/**
 *
 * @author Denicio
 */
public class TorresDeHanoiArray extends TorresDeHanoiJogo {
    private final TorreArray[] torres;
    
    /**
     *
     */
    public TorresDeHanoiArray() {
        fimDeJogo = false;
        torres = new TorreArray[3];
        torres[0] = new TorreArray(TAMANHO);
        torres[1] = new TorreArray(TAMANHO);
        torres[2] = new TorreArray(TAMANHO);
    }
    
    @Override
    public void IniciaJogo(int tamanho) throws Exception {
        fimDeJogo = false;
        TAMANHO = tamanho;
        for (int i = 0; i < TAMANHO; i++) {
            torres[0].push(TAMANHO - i);
        }
        imprimeTorres();
        menorJogoPossivel = Math.pow(2, tamanho) -1;
    }
    
    @Override
    public String moveDisco(int tO, int tD) throws Exception {
        String jogada = validaJogada(tO, tD, torres);
        imprimeTorres();
        totalJogadas++;
        return jogada;
    }
    
    private void imprimeTorres() throws Exception {
        String linha;
        Integer d;
        
        TorreArray[] torresC = new TorreArray[3];
        torresC[0] = new TorreArray(TAMANHO);
        torresC[1] = new TorreArray(TAMANHO);
        torresC[2] = new TorreArray(TAMANHO);
        
        System.out.println("");
        System.out.println("");
        
        linha = "  ";
        
        for (int i = 0; i < TAMANHO; i++) {
            linha = linha + " ";
        }
        
        linha = linha + "|  ";
        
        for (int i = 0; i < TAMANHO * 2; i++) {
            linha = linha + " ";
        }
        
        linha = linha + "|  ";
        
        for (int i = 0; i < TAMANHO * 2; i++) {
            linha = linha + " ";
        }
        
        linha = linha + "|";
        
        System.out.println(linha);

        for (int contaLin = 0; contaLin < TAMANHO; contaLin++) {
            linha = "";

            for (int contaTorre = 0; contaTorre < 3; contaTorre++) {

                if (torres[contaTorre].tamanho() < TAMANHO - contaLin) {
                    linha = linha + "  ";
                    
                    for (int i = 0; i < TAMANHO; i++) {
                        linha = linha + " ";
                    }
                    
                    linha = linha + "|";
                    
                    for (int i = 0; i < TAMANHO; i++) {
                        linha = linha + " ";
                    }
                }
                else {
                    if (!torres[contaTorre].vazia()) {
                        linha = linha + "  ";
                        d = torres[contaTorre].pop();
                        
                        for (int z = 1; z <= TAMANHO - d; z++) {
                            linha = linha + " ";
                        }
                        
                        for (int z = 1; z <= d; z++) {
                            linha = linha + "o";
                        }
                        
                        linha = linha + "|";
                        
                        for (int z = 1; z <= d; z++) {
                            linha = linha + "o";
                        }
                        
                        for (int z = 1; z <= TAMANHO - d; z++) {
                            linha = linha + " ";
                        }
                        
                        //linha = linha + "  ";
                        
                        torresC[contaTorre].push(d);
                    }
                    else {
                        linha = linha + "    ";
                        
                        for (int i = 0; i < TAMANHO; i++) {
                            linha = linha + " ";
                        }
                    
                        linha = linha + "|";
                    
                        for (int i = 0; i < TAMANHO; i++) {
                            linha = linha + " ";
                        }

                    }
                }
            }
            
            System.out.println(linha);
        }
        
        linha = "  ";
        
        for (int i = 0; i < TAMANHO; i++) {
            linha = linha + " ";
        }
        
        linha = linha + "1";
        
        linha = linha + "  ";
        
        for (int i = 0; i < TAMANHO * 2; i++) {
            linha = linha + " ";
        }
        
        linha = linha + "2";
        
        linha = linha + "  ";
        
        for (int i = 0; i < TAMANHO * 2; i++) {
            linha = linha + " ";
        }
        
        linha = linha + "3";
        
        System.out.println(linha);
        
        // Volta as informações para a posição correta
        for (int contaTorre = 0; contaTorre < 3; contaTorre++) {
            while (!torresC[contaTorre].vazia()) {
                d = torresC[contaTorre].pop();
                torres[contaTorre].push(d);
            }
        }

    }
}
