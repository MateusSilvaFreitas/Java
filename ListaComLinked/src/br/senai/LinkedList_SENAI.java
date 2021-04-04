package br.senai;

public class LinkedList_SENAI{
	private NoLista first;
	private NoLista last;
	private int counter = 0;
	
	public LinkedList_SENAI() {
		first 	= null;
		last 	= null;
		counter = 0;
	}
	
	public void add(Integer informacao) {
		NoLista noAdicionar = new NoLista(informacao, null);
		if(first == null) {
			first = noAdicionar;
		} else {
			last.setNext(noAdicionar);
		}
		last = noAdicionar;
		counter++;
	}
	public void add(int posicao, Integer informacao) throws Exception {
		validaPosicao(posicao);
		NoLista noAdicionar = new NoLista(informacao, null);
		NoLista noAdicionarAux = first;
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

	public Integer remove(int posicao) throws Exception {
		validaPosicao(posicao);
		NoLista noAux = first;
		NoLista noAntecessor = null;
		Integer retorno = null;
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
	public boolean removeFirst(Integer valor) {
		NoLista noAux = first;
		NoLista noAntecessor = null;
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
	
	public Integer get(int posicao) throws Exception {
		validaPosicao(posicao);
		NoLista noAux = first;
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
	
	public Integer set(int posicao, Integer valor) throws Exception {
		validaPosicao(posicao);
		NoLista noAux = first;
		Integer infoSobreescrita = null;
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
	private boolean validaExisteNo(NoLista noAux) {
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
	
	public boolean contains(Integer valor){
		NoLista noAux = first;
		boolean contem = false;
		while(validaExisteNo(noAux) && !contem) {
			contem = noAux.getInformacao() == valor;
			noAux = noAux.getNext();
		}
		return contem;
	}
	public int indexOf(Integer valor){
		NoLista noAux = first;
		int indice = -1;
		int contadorAux = 0;
		while(validaExisteNo(noAux) && indice < 0) {
			indice = noAux.getInformacao() == valor ? contadorAux : indice;
			noAux = noAux.getNext();
			contadorAux++;
		}
		return indice;
	}
	public int lastIndexOf(Integer valor){
		NoLista noAux = first;
		int indice = -1;
		int contadorAux = 0;
		while(validaExisteNo(noAux)) {
			indice = noAux.getInformacao() == valor ? contadorAux : indice;
			noAux = noAux.getNext();
			contadorAux++;
		}
		return indice;
	}
	public Integer[] toArray() {
		Integer retorno[] = (Integer[]) new Object[counter];
		NoLista noAux = first;
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

