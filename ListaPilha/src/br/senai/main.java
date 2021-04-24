package br.senai;

public class main {
	public static void main(String[] args) throws Exception {
		PilhaLinked<String> pilhaLinked = new PilhaLinked<String>();
		pilhaLinked.push("TESTE 1");
		pilhaLinked.push("TESTE 2");
		pilhaLinked.push("TESTE 3");
		System.out.println(pilhaLinked.pop());
		pilhaLinked.push("TESTE 4");
		pilhaLinked.push("TESTE 5");
		pilhaLinked.toArray();
		System.out.println(pilhaLinked.pop());
		System.out.println(pilhaLinked.pop());
		System.out.println(pilhaLinked.pop());
		System.out.println(pilhaLinked.pop());
		pilhaLinked.push("TESTE 6");
		pilhaLinked.push("TESTE 7");
		pilhaLinked.toArray();
		pilhaLinked.libera();
		pilhaLinked.toArray();
		
		System.out.println("=================");
		PilhaArray<String> pilhaArray = new PilhaArray<String>(5);
		pilhaArray.push("TESTE 1");
		pilhaArray.push("TESTE 2");
		pilhaArray.push("TESTE 3");
		System.out.println(pilhaArray.pop());
		pilhaArray.push("TESTE 4");
		pilhaArray.push("TESTE 5");
		pilhaArray.toArray();
		System.out.println(pilhaArray.pop());
		System.out.println(pilhaArray.pop());
		System.out.println(pilhaArray.pop());
		System.out.println(pilhaArray.pop());
		pilhaArray.push("TESTE 6");
		pilhaArray.push("TESTE 7");
		pilhaArray.toArray();
		pilhaArray.libera();
		pilhaArray.toArray();
		
	}
}
