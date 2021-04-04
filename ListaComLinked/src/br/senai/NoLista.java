package br.senai;

public class NoLista {
	private Integer informacao;
	private NoLista next;
	
	
	
	public NoLista() {
		this.informacao = null;
		this.next = null;
	}
	public NoLista(Integer informacao, NoLista next) {
		this.informacao = informacao;
		this.next = next;
	}
	
	
	public Integer getInformacao() {
		return informacao;
	}
	public void setInformacao(Integer informacao) {
		this.informacao = informacao;
	}
	public NoLista getNext() {
		return next;
	}
	public void setNext(NoLista next) {
		this.next = next;
	}
	
}
