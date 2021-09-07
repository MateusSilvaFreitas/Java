public class ArvoreBinariaComEncadeamento {

    NoArvoreBinaria raiz;

    public void espelhar() {
        espelhar(raiz);
    }

    private NoArvoreBinaria espelhar(NoArvoreBinaria no) {
        if (no.getFilhoEsquerda() == null && no.getFilhoDireita() == null) {
            return no;
        }
        espelhar(no.getFilhoEsquerda());
        espelhar(no.getFilhoDireita());
        NoArvoreBinaria noAux = no.getFilhoEsquerda();
        no.setFilhoEsquerda(no.getFilhoDireita());
        no.setFilhoDireita(noAux);
        return no;
    }

    public boolean isCheia() {
        return !validaArvore(raiz);
    }

    private boolean validaArvore(NoArvoreBinaria no) {
        if (no.getFilhoEsquerda() == null && no.getFilhoDireita() == null) {
            //É uma folha
            return false;
        } else if ((no.getFilhoEsquerda() != null && no.getFilhoDireita() == null)
                || (no.getFilhoEsquerda() == null && no.getFilhoDireita() != null)) {
            //Possui um espaço vago
            return true;
        }
        return validaArvore(no.getFilhoEsquerda()) || validaArvore(no.getFilhoDireita());
    }

    public String listarNos(int nivel) {
        if (raiz == null) {
            return "Arvore vazia";
        }
        int countPercorrendo = 0;
        return retornaNoNivel(raiz, nivel, countPercorrendo);
    }

    private String retornaNoNivel(NoArvoreBinaria no, int nivel, int nivelPercorrendo) {
        if (nivel == nivelPercorrendo) {
            return no != null && no.getInformacao() != null ? no.getInformacao().toString() + "," : "";
        } else if(no.getFilhoEsquerda() != null || no.getFilhoDireita() != null){
            nivelPercorrendo++;
            StringBuilder retornoFilhos = new StringBuilder();
            retornoFilhos.append(retornaNoNivel(no.getFilhoEsquerda(), nivel, nivelPercorrendo));
            retornoFilhos.append(retornaNoNivel(no.getFilhoDireita(), nivel, nivelPercorrendo));
            return retornoFilhos.toString();
        } else {
            return "Nivel inexistente";
        }
    }

}
