package senai;

public abstract class RegraJogoTorresHanoi {
    private boolean jogofinalizado;
    private int tamanhoTorre = 5;
    private double menorJogoPossivel = 0;
    
    
    public boolean fimDeJogo() {
        return jogofinalizado;
    }
    
    public abstract void IniciaJogo(int tamanho) throws Exception;
    
    public abstract String moveDisco(int tO, int tD) throws Exception;

    
    public String imprimeResultado() {
        String result;
        jogofinalizado = true;
        result = "Você venceu";
        return result;
    }

	public boolean isJogofinalizado() {
		return jogofinalizado;
	}

	public void setJogofinalizado(boolean jogofinalizado) {
		this.jogofinalizado = jogofinalizado;
	}

	public int getTamanhoTorre() {
		return tamanhoTorre;
	}

	public void setTamanhoTorre(int tamanhoTorre) {
		this.tamanhoTorre = tamanhoTorre;
	}

	public double getMenorJogoPossivel() {
		return menorJogoPossivel;
	}

	public void setMenorJogoPossivel(double menorJogoPossivel) {
		this.menorJogoPossivel = menorJogoPossivel;
	}
}
