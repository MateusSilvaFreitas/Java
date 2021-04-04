package br.senai;

public class LinkedList_SENAI<T> implements Lista<T>{
	private NoLista<T> first;
	private NoLista<T> last;
	private int counter = 0;
	
	public LinkedList_SENAI() {
		first 	= null;
		last 	= null;
		counter = 0;
	}
	
	public void add(T informacao) {
		NoLista<T> noAdicionar = new NoLista<T>(informacao, null);
		if(first == null) {
			first = noAdicionar;
		} else {
			last.setNext(noAdicionar);
		}
		last = noAdicionar;
		counter++;
	}
	public void add(int posicao, T informacao) throws Exception {
		validaPosicao(posicao);
		NoLista<T> noAdicionar = new NoLista<T>(informacao, null);
		NoLista<T> noAdicionarAux = first;
		int counterInterno = 0;
		while (validaExisteNo(noAdicionarAux)) {
			if(counterInterno == posicao - 1) {
				noAdicionar.setNext(noAdicionarAux.getNext());
				noAdicionarAux.setNext(noAdicionar);
				break;
			} else {
				noAdicionarAux = noAdicionarAux.getNext();
			}
			counterInterno++;
		}
		counter++;
	}

	public T remove(int posicao) throws Exception {
		validaPosicao(posicao);
		NoLista<T> noAux = first;
		NoLista<T> noAntecessor = null;
		T retorno = null;
		int counterInterno = 0;
		while (validaExisteNo(noAux)) {
			if(counterInterno == posicao) {
				retorno = noAux.getInformacao();
				if(noAntecessor != null) {
					if(noAux.getNext() == null) {
						noAntecessor.setNext(null);;
						last = noAntecessor;
					}else {
						noAntecessor.setNext(noAux.getNext());
					}
				}else {
					first = noAux.getNext();
				}
				counter--;
				break;
			} else {
				counterInterno++;
				noAntecessor = noAux;
				noAux = noAux.getNext();
			}
			
		}
		return retorno;
	}
	public boolean removeFirst(T valor) {
		NoLista<T> noAux = first;
		NoLista<T> noAntecessor = null;
		while (validaExisteNo(noAux)) {
			if(noAux.getInformacao() == valor) {
				if(noAntecessor != null) {
					if(noAux.getNext() == null) {
						noAux = null;
						last = noAntecessor;
					}else {
						noAntecessor.setNext(noAux.getNext());
					}
				}else {
					first = noAux.getNext();
				}
				counter--;
				return true;
			} else {
				noAntecessor = noAux;
				noAux = noAux.getNext();
			}
		}
		return false;
	}
	
	public T get(int posicao) throws Exception {
		validaPosicao(posicao);
		NoLista<T> noAux = first;
		int counterAux = 0;
		while(validaExisteNo(noAux)) {
			if(posicao == counterAux) {
				return noAux.getInformacao();
			} else {
				noAux = noAux.getNext();
			}
		}
		return null;
	}
	
	public T set(int posicao, T valor) throws Exception {
		validaPosicao(posicao);
		NoLista<T> noAux = first;
		T infoSobreescrita = null;
		int counterAux = 0;
		while(validaExisteNo(noAux)) {
			if(posicao == counterAux) {
				infoSobreescrita = noAux.getInformacao();
				noAux.setInformacao(valor);
				break;
			}
			noAux = noAux.getNext();
			counterAux++;
		}
		return infoSobreescrita;
	}
	private boolean validaExisteNo(NoLista<T> noAux) {
		return noAux != null;
	}
	
	public int size() {
		return counter;
	}
	
	public void clear() {
		first = null;
		last = null;
	}
	public boolean isEmpty() {
		return counter == 0;
	}
	
	public boolean contains(T valor){
		NoLista<T> noAux = first;
		boolean contem = false;
		while(validaExisteNo(noAux) && !contem) {
			contem = noAux.getInformacao() == valor;
			noAux = noAux.getNext();
		}
		return contem;
	}
	public int indexOf(T valor){
		NoLista<T> noAux = first;
		int indice = -1;
		int contadorAux = 0;
		while(validaExisteNo(noAux) && indice < 0) {
			indice = noAux.getInformacao() == valor ? contadorAux : indice;
			noAux = noAux.getNext();
			contadorAux++;
		}
		return indice;
	}
	public int lastIndexOf(T valor){
		NoLista<T> noAux = first;
		int indice = -1;
		int contadorAux = 0;
		while(validaExisteNo(noAux)) {
			indice = noAux.getInformacao() == valor ? contadorAux : indice;
			noAux = noAux.getNext();
			contadorAux++;
		}
		return indice;
	}
	public T[] toArray() {
		T retorno[] = (T[]) new Object[counter];
		NoLista<T> noAux = first;
		int counterAux = 0;
		while(validaExisteNo(noAux)) {
			retorno[counterAux] = noAux.getInformacao();
			noAux = noAux.getNext();
			counterAux++;
		}
		return retorno;
	}
	private void validaPosicao(int posicao) throws Exception {
		if(posicao < 0 || posicao > counter) {
			throw new Exception("Posição inválida");
		}
	}
}

