package senai;

import java.util.Scanner;
public class MainJogo {

    
    public static void main(String[] args) throws Exception {
    	boolean contigua;
    	boolean sobre;
    	boolean dinamica;
    	try{
	        contigua = "contigua".equalsIgnoreCase(args[0]);
	        sobre = "sobre".equalsIgnoreCase(args[0]);
	        dinamica = "dinamica".equalsIgnoreCase(args[0]);
	    }catch(Exception e) {
	    	throw new Exception("Não foi passado argumento");
	    }
    	if (sobre) {
            System.out.println("Alunos: Luiz Kischel");
            System.out.println("        Lucas Machado");
            
        } else if (contigua || dinamica) {
            Scanner scanner = new Scanner(System.in);
            String rMov = "";
            RegraJogoTorresHanoi torre = new RegraTorreVetor();
            if (contigua) {
                torre = new RegraTorreVetor();
            }else if(dinamica) {
                torre = new RegraTorreLincada();
            }
            torre = new RegraTorreLincada();
            torre.IniciaJogo(retornaValor(scanner, "Quantidade de discos: "));
            while (!torre.fimDeJogo() && !"CANCEL".equals(rMov)) {
            	int torreDeOrigem;
            	int torreDeDestino;
            	torreDeOrigem = retornaValor(scanner, "Torre de origem: ");
            	torreDeDestino = retornaValor(scanner, "Digite torre de destino: ");
            	for(int i = 0; i < 50; i++) {
            		System.out.println();
            	}
                rMov = torre.moveDisco(torreDeOrigem, torreDeDestino);
                System.out.println(rMov != null ? rMov : "");
            }
        } else if(!sobre){
        	throw new Exception("Não foi passado argumento");
        }        
    }

    private static int retornaValor(Scanner ent, String s) {
        boolean valorValido;
        int valor = 0;
        do {
            try {
                System.out.print(s);
                valor = Integer.parseInt(ent.nextLine());
                if(s.contains("torre") && valor > 3) {
                	throw new Exception();
                }
                valorValido = true;
            } catch (Exception e) {
                System.out.println("Valor inválido.");
                valorValido = false;
            }
        } while (!valorValido);
        return valor;
    }

}
