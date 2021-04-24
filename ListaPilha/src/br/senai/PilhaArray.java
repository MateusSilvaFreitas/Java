package br.senai;

public class PilhaArray<T> implements Pilha<T>{
	
	private int n = 0;
	private int tamanho;
	private T vetor[];
	
	public PilhaArray(int tamanho) {
		this.vetor =  (T[]) new Object[tamanho];
		this.tamanho = tamanho;
	}
	
	@Override
	public void push(T valor) throws Exception {
		if(vetor.length == n) {
			throw new Exception("A pilha já está cheia!");
		}
		vetor[n] = valor;
		n++;
	}	
	
	@Override
	public T pop() throws Exception {
		if(n == 0) {
			throw new Exception("A pilha está vazia");
		}
		T valorAux = vetor[n - 1];
		vetor[n - 1] = null;
		n--;
		return valorAux;
	}
	@Override
	public T top() throws Exception {
		if(n == 0) {
			throw new Exception("A pilha está vazia");
		}
		return vetor[n];
	}
	@Override
	public boolean vazia() {
		return n == 0;
	}
	@Override
	public void libera() {
		this.vetor =  (T[]) new Object[tamanho];
	}
	public Integer size() {
		return n;
	}
	public boolean isFull() {
		return n == vetor.length;
	}
	public T[] toArray() {
		return this.vetor;
	}
	public boolean contains(T valor){
		for (int i = 0; i < this.vetor.length; i++) {
			if(this.vetor[i] == valor) {
				return true;
			}
		}
		return false;
	}
	public int indexOf(T valor){
		for (int i = 0; i < this.vetor.length; i++) {
			if(this.vetor[i] == valor ) {
				return i;
			}
		}
		return -1;
	}
	public int lastIndexOf(T valor){
		Integer ultimoIndice = -1;
		for (int i = 0; i < this.vetor.length; i++) {
			if(this.vetor[i] == valor) {
				ultimoIndice = i;
			}
		}
		return ultimoIndice;
	}

	

}
