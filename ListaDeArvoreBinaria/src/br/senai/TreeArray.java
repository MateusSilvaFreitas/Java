package br.senai;

public class TreeArray<T> {
	//H se refere a altura
	private int h;
	private T array[];
	private int contValoresLista = 0;
	private int valorMaximoLista;
	
	public TreeArray(int altura) {
		this.h = altura;
		valorMaximoLista = 2 ^ (this.h + 1) - 1;
		this.array = (T[]) new Object[valorMaximoLista];  
	}
	
	public boolean insere(T valor) throws Exception {
		if(cheia()) {
			throw new Exception("A arvore já está cheia!");
		}
		for(int i = 0; i < array.length; i++) {
			if(array[i] == null) {
				array[i] = valor;
				return true;
			}
		}
		return false;
	}
	/**
	 * Filho 1 para o da esquerda, 2 para o da direita
	 * @param valor
	 * @param posicaoPai
	 * @param sobreescrever
	 * @param filho
	 * @return
	 * @throws Exception
	 */
	public boolean insere(T valor, int posicaoPai, boolean sobreescrever, int filho) throws Exception {
		if(cheia() && !sobreescrever) {
			throw new Exception("A arvore já está cheia!");
		}
		if(array[posicaoPai] == null) {
			array[posicaoPai] = valor;
			return true;
		}
		int posicaoFilho = (posicaoPai << 1) + filho;
		
		if(array[posicaoFilho] == null || (array[posicaoFilho] != null && sobreescrever)) {
			array[posicaoFilho] = valor;
			return true;
		}
		return false;
	}
	
	public boolean vazia() {
		return contValoresLista == 0;
	}
	public boolean cheia() {
		return contValoresLista == valorMaximoLista;
	}
	
	public boolean pertence(Integer valor) throws Exception {
		if(cheia()) {
			throw new Exception("A arvore já está cheia!");
		}
		for(int i = 0; i < array.length; i++) {
			if(array[i] == valor) {
				return true;
			}
		}
		return false;
	}
	
	public int getQuantidadeMaximaNos() {
		return valorMaximoLista;
	}
	
	public int getAlturaAtual() {
//		for(i = 2 ^ h; i < 2 ^ (h-1); i--) {
//			
//		}
		return 0;
	}
	
	public void liberarRecursos() {
		this.array =  (T[]) new Object[valorMaximoLista];
	}
	
	public String toString() {
		return null;
	}

}
