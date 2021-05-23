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
public abstract class TorresDeHanoiJogo {
    protected int TAMANHO = 5;
    protected boolean fimDeJogo;
    protected int totalJogadas;
    protected double menorJogoPossivel = 0;
    
    
    public boolean fimDeJogo() {
        return fimDeJogo;
    }
    
    public abstract void IniciaJogo(int tamanho) throws Exception;
    
    public abstract String moveDisco(int tO, int tD) throws Exception;

    public String validaJogada(int tO, int tD, TorreHanoi torres[]) throws Exception {
        Integer dO;
        Integer dD;
        if (tO == 99) {
            return "CANCEL";
        }

        if (tO == tD) {
            return "A torre de Origem e a torre de Destino devem ser diferentes!";
        }
        if (tO >= 1 && tO <= 3) {
            if (torres[tO-1].vazia()) {
                return "Torre " + tO + " está vazia!";
            }
            else {
                dO = torres[tO-1].pop();
            }
        }
        else {
            return "Torre de origem não existe. Deve ser 1, 2, ou 3!";
        }

        if (dO != null && tD >= 1 && tD <= 3) {
            if (torres[tD-1].vazia()) {
                torres[tD-1].push(dO);
            }
            else {
                dD = torres[tD-1].pop();

                torres[tD-1].push(dD);

                if (dD < dO) {
                    torres[tO-1].push(dO);
                    return "Jogada não permitida!";
                }
                else {
                    torres[tD-1].push(dO);
                }
            }
        }
        else {
            return "Torre de destino não existe. Deve ser 1, 2, ou 3!";
        }
        if (torres[2].tamanho() == TAMANHO) {
            return imprimeResultado();
        }else {
            return null;
        }
    }
    public String imprimeResultado() {
        String result;
        fimDeJogo = true;
        result = "Fim de jogo.....Você venceu";

        if (totalJogadas > menorJogoPossivel) {
            result = result + ", mas pode melhorar! É possível terminar o jogo em " + menorJogoPossivel + " jogadas. Suas jogadas: " + totalJogadas;
        }
        else {
            result = result + "! " + totalJogadas + " jogadas!";
        }
        return result;
    }
}
