package br.senai.sc.mateus;

public class PilhaLinked<T> implements Pilha<T>{

	private NoLista<T> noLista;
	private int counter = 0;
	
	public PilhaLinked() {
		noLista 	= null;
		counter = 0;
	}
	
	@Override
	public void push(T valor) throws Exception {
		NoLista<T> noAdicionar = new NoLista<T>(valor, null);
		if(noLista == null) {
			noAdicionar.setInformacao(valor);
		}
		noAdicionar.setNext(noLista);
		noLista = noAdicionar;
		counter++;
	}

	@Override
	public T pop() throws Exception {
		if(noLista == null) {
			throw new Exception("A lista est� vazia");
		}
		NoLista<T> noRemover = noLista;
		noLista = noLista.getNext();
		counter--;
		return noRemover.getInformacao();
	}

	@Override
	public T top() throws Exception {
		if(noLista == null) {
			throw new Exception("A lista est� vazia");
		}
		return noLista.getInformacao();
	}

	@Override
	public boolean vazia() {
		return counter == 0;
	}

	@Override
	public void libera() {
		noLista = null;
	}
	public Integer size() {
		return counter;
	}
	public boolean contains(T valor){
		NoLista<T> noAux = noLista;
		boolean contem = false;
		while(noAux != null && !contem) {
			contem = noAux.getInformacao() == valor;
			noAux = noAux.getNext();
		}
		return contem;
	}
	public int indexOf(T valor){
		NoLista<T> noAux = noLista;
		int indice = -1;
		int contadorAux = 0;
		while(noAux != null && indice < 0) {
			indice = noAux.getInformacao() == valor ? contadorAux : indice;
			noAux = noAux.getNext();
			contadorAux++;
		}
		return indice;
	}
	public int lastIndexOf(T valor){
		NoLista<T> noAux = noLista;	
		int indice = -1;
		int contadorAux = 0;
		while(noAux != null) {
			indice = noAux.getInformacao() == valor ? contadorAux : indice;
			noAux = noAux.getNext();
			contadorAux++;
		}
		return indice;
	}
	public T[] toArray() {
		T retorno[] = (T[]) new Object[counter];
		NoLista<T> noAux = noLista;
		int counterAux = 0;
		while(noAux != null) {
			retorno[counterAux] = noAux.getInformacao();
			noAux = noAux.getNext();
			counterAux++;
		}
		return retorno;
	}

}
