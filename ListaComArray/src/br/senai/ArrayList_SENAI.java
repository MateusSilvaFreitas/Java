package br.senai;

import java.util.Iterator;

public class ArrayList_SENAI {
	private Integer array[];
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
		this.array = new Integer[initialCapacity]; 
	}
	
	public void add(Integer valor) {
		this.array[this.counter] = valor;
		this.counter++;
		resizeArrayList();
	}
	
	//Puxar ao com o for de tras para frente
	public void add(int posicao, Integer valor) {
		if(this.array[posicao] == null) {
			this.array[posicao] = valor;
		} else {
			Integer arrayAux[] = new Integer[counter + 1];
			int countInterno = 0;
			for (int i = posicao; i < counter; i++) {
				arrayAux[countInterno] = this.array[i];
				countInterno++;
			}
			this.array[posicao] = valor;
			countInterno = 0;
			for (int i = posicao + 1; i <= counter; i++) {
				this.array[i] = arrayAux[countInterno];
				countInterno++;
			}
		}	
		counter++;
		resizeArrayList();
	}
	
	private void resizeArrayList() {
		if(resizable && counter + 2 == this.array.length) {
			Integer arrayAux[] = new Integer[this.array.length + X];
			for (int i = 0; i < this.array.length; i++) {
				arrayAux[i] = this.array[i];
			}
			this.array = arrayAux;
		} 
	}
	
	public Integer remove(int posicao) {
		Integer valAntigo = this.array[posicao];
		this.array[posicao] = null;
		for (int i = posicao; i < this.counter; i++) {
			if(this.array.length > i + 1) {
				this.array[i] = this.array[i + 1];
			} else {
				this.array[i] = null;
			}			
		}
		return valAntigo;
	}
	
	public boolean removeFirst(Integer valorIntegerRemover) {
		for (int i = 0; i < this.array.length; i++) {
			if(this.array[i] == valorIntegerRemover) {
				this.array[i] = null;
				for (int y = i; y < this.counter; y++) {
					if(this.array.length >= y + 1) {
						this.array[y] = this.array[y + 1];
					} else {
						this.array[y] = null;
					}			
				}
				return true;
			}
		}
		return false;
	}
	
	public Integer get(Integer posicao) {
		return this.array[posicao];
	}
	
	public void clear() {
		this.array = new Integer[initialCapacity];
	}
	
	public Integer set(int posicao, Integer valor) {
		Integer valAntigo = this.array[posicao];
		this.array[posicao] = valor;
		return valAntigo;
	}
	public Integer size() {
		return counter;
	}
	public boolean isEmpty() {
		return counter == 0;
	}
	public boolean isFull() {
		return counter == array.length;
	}
	
	public Integer[] toArray() {
		return this.array;
	}
	public boolean contains(Integer valor){
		for (int i = 0; i < this.array.length; i++) {
			if(this.array[i] == valor) {
				return true;
			}
		}
		return false;
	}
	public Integer indexOf(Integer valor){
		for (int i = 0; i < this.array.length; i++) {
			if(this.array[i] == valor ) {
				return i;
			}
		}
		return -1;
	}
	public Integer lastIndexOf(Integer valor){
		Integer ultimoIndice = -1;
		for (int i = 0; i < this.array.length; i++) {
			if(this.array[i] == valor) {
				ultimoIndice = i;
			}
		}
		return ultimoIndice;
	}
}
