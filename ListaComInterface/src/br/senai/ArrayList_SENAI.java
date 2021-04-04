package br.senai;

public class ArrayList_SENAI<T> implements Lista<T>{
	private T array[];
	private boolean resizable;
	private int initialCapacity;
	private int counter = 0;
	private static final int X = 7;
	
	public ArrayList_SENAI() {
		this(7);
	}
	public ArrayList_SENAI(int tamanho) {
		this(tamanho, true);
	}
	public ArrayList_SENAI(int tamanho, boolean resizable) {
		this.initialCapacity = tamanho;
		this.resizable = resizable;
		this.array = (T[]) new Object[initialCapacity]; 
	}
	
	public void add(T valor) {
		this.array[this.counter] = valor;
		this.counter++;
		resizeArrayList();
	}

	public void add(int posicao, T valor) throws Exception {
		validaPosicao(posicao);
		if(this.array[posicao] == null) {
			this.array[posicao] = valor;
		} else {
			if(this.array[counter + 1] == null) {
				for (int i = counter; i > posicao; i--) {
					this.array[i + 1] = this.array[i];
					this.array[posicao] = valor;
				}
			} else {
				throw new Exception("Não é possivel adicionar o valor na lista pois ela está cheia.");
			}
		}	
		counter++;
		resizeArrayList();
	}
	
	private void resizeArrayList() {
		if(resizable && counter + 2 == this.array.length) {
			T arrayAux[] = (T[]) new Object[this.array.length + X];
			for (int i = 0; i < this.array.length; i++) {
				arrayAux[i] = this.array[i];
			}
			this.array = arrayAux;
		} 
	}
	
	public T remove(int posicao) throws Exception {
		validaPosicao(posicao);
		T valAntigo = this.array[posicao];
		counter--;
		this.array[posicao] = null;
		for (int i = posicao; i < this.counter; i++) {
			if(this.array.length > i + 1) {
				this.array[i] = this.array[i + 1];
				this.array[i + 1] = null;
			} else {
				this.array[i] = null;
				break;
			}			
		}
		return valAntigo;
	}
	
	public boolean removeFirst(T valorIntegerRemover) throws Exception {
		for (int i = 0; i < this.array.length; i++) {
			if(this.array[i] == valorIntegerRemover) {
				remove(i);
				return true;
			}
		}
		return false;
	}
	
	public T get(int posicao) throws Exception {
		validaPosicao(posicao);
		return this.array[posicao];
	}
	
	public void clear() {
		this.array = (T[]) new Object[initialCapacity];
	}
	
	public T set(int posicao, T valor) throws Exception {
		validaPosicao(posicao);
		T valAntigo = this.array[posicao];
		this.array[posicao] = valor;
		return valAntigo;
	}
	public int size() {
		return counter;
	}
	public boolean isEmpty() {
		return counter == 0;
	}
	public boolean isFull() {
		return counter == array.length;
	}
	
	public T[] toArray() {
		return this.array;
	}
	public boolean contains(T valor){
		for (int i = 0; i < this.array.length; i++) {
			if(this.array[i] == valor) {
				return true;
			}
		}
		return false;
	}
	public int indexOf(T valor){
		for (int i = 0; i < this.array.length; i++) {
			if(this.array[i] == valor ) {
				return i;
			}
		}
		return -1;
	}
	public int lastIndexOf(T valor){
		Integer ultimoIndice = -1;
		for (int i = 0; i < this.array.length; i++) {
			if(this.array[i] == valor) {
				ultimoIndice = i;
			}
		}
		return ultimoIndice;
	}
	private void validaPosicao(int posicao) throws Exception {
		if(posicao < 0 || posicao > counter) {
			throw new Exception("Posição inválida");
		}
	}
}
