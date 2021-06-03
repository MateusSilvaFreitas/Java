package senai;

public class PilhaVetor<T>{
	
	private int n = 0;
	private int tamanho;
	private T vetor[];
	
	public PilhaVetor(int tamanho) {
		this.vetor =  (T[]) new Object[tamanho];
		this.tamanho = tamanho;
	}
	
	public void push(T valor) throws Exception {
		if(vetor.length == n) {
			throw new Exception("pilha cheia!");
		}
		vetor[n] = valor;
		n++;
	}	
	
	public T pop() throws Exception {
		if(n == 0) {
			throw new Exception("Pilha vazia");
		}
		T valorAux = vetor[n - 1];
		vetor[n - 1] = null;
		n--;
		return valorAux;
	}

	public T top() throws Exception {
		if(n == 0) {
			throw new Exception("A pilha est� vazia");
		}
		return vetor[n];
	}

	public boolean vazia() {
		return n == 0;
	}

	public void libera() {
		this.vetor =  (T[]) new Object[tamanho];
	}
	public Integer size() {
		return n;
	}

	public boolean contains(T valor){
		for (int i = 0; i < this.vetor.length; i++) {
			if(this.vetor[i] == valor) {
				return true;
			}
		}
		return false;
	}
}
