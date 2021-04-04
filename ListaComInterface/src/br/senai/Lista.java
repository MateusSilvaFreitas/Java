package br.senai;

public interface Lista<T> {
	public void add(T valor);
	
	public void add(int indice, T valor) throws Exception;
	
	public T remove(int indice) throws Exception;
	
	public boolean removeFirst(T valor) throws Exception;
	
	public T get(int indice) throws Exception;
	
	public void clear();
	
	public T set(int indice, T valor) throws Exception;
	
	public int size();	
	
	public boolean isEmpty();
	
	public boolean contains(T valor);
	
	public int indexOf(T valor);
	
	public int lastIndexOf(T valor);
	
	public T[] toArray();
}
