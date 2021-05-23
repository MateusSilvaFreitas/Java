package br.senai.sc.mateus;

public class NoLista<T> {
	private T informacao;
	private NoLista<T> next;
	
	
	
	public NoLista() {
		this.informacao = null;
		this.next = null;
	}
	public NoLista(T informacao, NoLista<T> next) {
		this.informacao = informacao;
		this.next = next;
	}

	public T getInformacao() {
		return informacao;
	}
	public void setInformacao(T informacao) {
		this.informacao = informacao;
	}
	public NoLista<T> getNext() {
		return next;
	}
	public void setNext(NoLista<T> next) {
		this.next = next;
	}
}

	