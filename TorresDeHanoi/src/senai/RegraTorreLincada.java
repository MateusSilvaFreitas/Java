package senai;


public class RegraTorreLincada extends RegraJogoTorresHanoi {
    private final TorreLincada[] torres;
    
    public RegraTorreLincada() {
    	
        torres = new TorreLincada[3];
        torres[0] = new TorreLincada();
        torres[1] = new TorreLincada();
        torres[2] = new TorreLincada();
    }
    @Override
    public void IniciaJogo(int tamanho) throws Exception {
        setTamanhoTorre(tamanho);
        setJogofinalizado(false);
        for (int i = 0; i < tamanho; i++) {
            torres[0].push(tamanho - i);
        }
        imprimeTorres();
    }
    
    @Override
    public String moveDisco(int tO, int tD) throws Exception {
        String jogada = validaJogada(tO, tD, torres);
        imprimeTorres();
        return jogada;
    }
    private void imprimeTorres() throws Exception {
        String linha;
        Integer d;
        
        TorreLincada[] torresC = new TorreLincada[3];
        torresC[0] = new TorreLincada();
        torresC[1] = new TorreLincada();
        torresC[2] = new TorreLincada();
        
        System.out.println();
        System.out.println();
        
        linha = "  ";
        
        for (int i = 0; i < getTamanhoTorre(); i++) {
            linha = linha + " ";
        }
        
        linha = linha + "|  ";
        
        for (int i = 0; i < getTamanhoTorre() << 1; i++) {
            linha = linha + " ";
        }
        
        linha = linha + "|  ";
        
        for (int i = 0; i < getTamanhoTorre() << 1; i++) {
            linha = linha + " ";
        }
        
        linha = linha + "|";
        
        System.out.println(linha);

        for (int contaLin = 0; contaLin < getTamanhoTorre(); contaLin++) {
            linha = "";

            for (int contaTorre = 0; contaTorre < 3; contaTorre++) {

                if (torres[contaTorre].tamanho() < getTamanhoTorre() - contaLin) {
                    linha = linha + "  ";
                    
                    for (int i = 0; i < getTamanhoTorre(); i++) {
                        linha = linha + " ";
                    }
                    
                    linha = linha + "|";
                    for (int i = 0; i < getTamanhoTorre(); i++) {
                        linha = linha + " ";
                    }
                }
                else {
                    if (!torres[contaTorre].vazia()) {
                        linha = linha + "  ";
                        d = torres[contaTorre].pop();
                        
                        for (int z = 1; z <= getTamanhoTorre() - d; z++) {
                            linha = linha + " ";
                        }
                        for (int z = 1; z <= d; z++) {
                            linha = linha + "-";
                        }
                        linha = linha + "|";
                        for (int z = 1; z <= d; z++) {
                            linha = linha + "-";
                        }
                        for (int z = 1; z <= getTamanhoTorre() - d; z++) {
                            linha = linha + " ";
                        }
                        torresC[contaTorre].push(d);
                    }
                    else {
                        linha = linha + "    ";
                        
                        for (int i = 0; i < getTamanhoTorre(); i++) {
                            linha = linha + " ";
                        }
                    
                        linha = linha + "|";
                    
                        for (int i = 0; i < getTamanhoTorre(); i++) {
                            linha = linha + " ";
                        }

                    }
                }
            }
            
            System.out.println(linha);
        }
        
        linha = "  ";
        
        for (int i = 0; i < getTamanhoTorre(); i++) {
            linha = linha + " ";
        }
        
        linha = linha + "1";
        
        linha = linha + "  ";
        
        for (int i = 0; i < getTamanhoTorre() << 1; i++) {
            linha = linha + " ";
        }
        
        linha = linha + "2";
        
        linha = linha + "  ";
        
        for (int i = 0; i < getTamanhoTorre() << 1; i++) {
            linha = linha + " ";
        }
        
        linha = linha + "3";
        
        System.out.println(linha);

        for (int contaTorre = 0; contaTorre < 3; contaTorre++) {
            while (!torresC[contaTorre].vazia()) {
                d = torresC[contaTorre].pop();
                torres[contaTorre].push(d);
            }
        }
    }    
    public String validaJogada(int tO, int tD, TorreLincada torre[]) throws Exception {
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
        if (torres[2].tamanho() == getTamanhoTorre()) {
            return imprimeResultado();
        }else {
            return null;
        }
    }
}
