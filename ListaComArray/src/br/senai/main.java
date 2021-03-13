package br.senai;

public class main {
	public static void main(String[] args) {
		ArrayList_SENAI arraylistSenai = new ArrayList_SENAI(10, false);
		arraylistSenai.add(1);
		arraylistSenai.add(2);
		arraylistSenai.add(3);
		arraylistSenai.add(4);
		arraylistSenai.add(5);
		arraylistSenai.add(6);
		arraylistSenai.add(7);
		arraylistSenai.add(8);
		arraylistSenai.add(9);
		arraylistSenai.add(10);

		System.out.println("VALOR RETORNADO: " + arraylistSenai.set(9, 2));
		arraylistSenai.remove(8);
		
		System.out.println("Contém 10? " + arraylistSenai.contains(10));
		System.out.println("Primeiro indice de 2 = " + arraylistSenai.indexOf(2));
		System.out.println("Ultimo indice de 2 = " + arraylistSenai.lastIndexOf(2));
		for (int i = 0; i < arraylistSenai.toArray().length; i++) {
			System.out.println(arraylistSenai.get(i));
		}
	}
}
