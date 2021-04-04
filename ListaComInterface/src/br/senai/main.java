package br.senai;

public class main {
	public static void main(String[] args) throws Exception {
		ArrayList_SENAI<Integer> lista = new ArrayList_SENAI<Integer>();
		
		lista.add(1);
		System.out.println(lista.size());
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
		lista.toArray();
		
		lista.add(5, 6);
		
		lista.toArray();
		
		lista.remove(0);
		lista.remove(3);
		lista.remove(3);
		
		lista.toArray();
		
		lista.add(5);
		lista.add(6);

		lista.toArray();
		
		lista.set(0, 5);
		lista.set(4, 1);
		
		lista.toArray();
		
		System.out.println(lista.size());
		System.out.println(lista.isEmpty());
		System.out.println(lista.contains(1));
		
		lista.add(1);
		System.out.println(lista.toArray());
		System.out.println(lista.indexOf(1));
		System.out.println(lista.lastIndexOf(1));
		
	}
}
