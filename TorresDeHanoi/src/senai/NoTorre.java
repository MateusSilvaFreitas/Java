package senai;

public class NoTorre<T> {
	private T informacao;
	private NoTorre<T> next;
	
	
	
	public NoTorre() {
		this.informacao = null;
		this.next = null;
	}
	public NoTorre(T informacao, NoTorre<T> next) {
		this.informacao = informacao;
		this.next = next;
	}

	public T getInformacao() {
		return informacao;
	}
	public void setInformacao(T informacao) {
		this.informacao = informacao;
	}
	public NoTorre<T> getNext() {
		return next;
	}
	public void setNext(NoTorre<T> next) {
		this.next = next;
	}
}

	