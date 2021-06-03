package senai;

public class PilhaLincada<T>{

	private NoTorre<T> noLista;
	private int counter = 0;
	
	public PilhaLincada() {
		noLista 	= null;
		counter = 0;
	}
	
	public void push(T valor) throws Exception {
		NoTorre<T> noAdicionar = new NoTorre<T>(valor, null);
		if(noLista == null) {
			noAdicionar.setInformacao(valor);
		}
		noAdicionar.setNext(noLista);
		noLista = noAdicionar;
		counter++;
	}

	public T pop() throws Exception {
		if(noLista == null) {
			throw new Exception("Lista vazia");
		}
		NoTorre<T> noRemover = noLista;
		noLista = noLista.getNext();
		counter--;
		return noRemover.getInformacao();
	}

	public T top() throws Exception {
		if(noLista == null) {
			throw new Exception("Lista vazia");
		}
		return noLista.getInformacao();
	}

	public boolean vazia() {
		return counter == 0;
	}

	public Integer size() {
		return counter;
	}
	public boolean contains(T valor){
		NoTorre<T> noAux = noLista;
		boolean contem = false;
		while(noAux != null && !contem) {
			contem = noAux.getInformacao() == valor;
			noAux = noAux.getNext();
		}
		return contem;
	}
}
