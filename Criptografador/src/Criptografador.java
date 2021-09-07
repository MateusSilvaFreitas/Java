
import java.util.*;

public class Criptografador {

    private ArrayList<Integer> gerarChave(ArrayList<Integer> mensagemCripto){
        Random gerador = new Random();
        ArrayList<Integer> maiores = new ArrayList<>(5);
        maiores.add(0);
        maiores.add(0);
        maiores.add(0);
        maiores.add(0);
        maiores.add(0);

        validaPosicoes(0, mensagemCripto.size(), maiores, mensagemCripto);

        ArrayList<Integer> chave = new ArrayList<>(5);
        for (int i = 0; i < 5; i++){
            chave.add((26 - maiores.get(i)) > 0 ? gerador.nextInt(26 - maiores.get(i)) : 0);
        }
        return chave;
    }
    private void validaPosicoes(Integer posicaoIni, Integer posicaoFim, ArrayList<Integer> maiores, ArrayList<Integer> mensagemCripto){
        if(posicaoIni == posicaoFim){
            return;
        }
        for(Integer i = posicaoIni; i < posicaoIni + 5; i++){
            if(mensagemCripto.get(i) > maiores.get(i - posicaoIni)){
                maiores.set(i - posicaoIni, mensagemCripto.get(i));
            }
        }
        validaPosicoes(posicaoIni + 5, posicaoFim, maiores, mensagemCripto);
    }
    public ArrayList<String> criptografarMensagem(String mensagem){
        while(mensagem.length() % 5 != 0){
            mensagem = mensagem.concat(" ");
        }

        ArrayList<Integer> mensagemCripto = converteLetrasNumero(mensagem);
        ArrayList<Integer> chave = gerarChave(mensagemCripto);
        int counterChave = 0;
        Iterator<Integer> iterator = mensagemCripto.iterator();
        ArrayList<Integer> mensagemCriptoAux = new ArrayList<>(mensagemCripto);
        int counterInterno = 0;
        for (Integer umNumero: mensagemCriptoAux) {
            if(counterChave == 5) counterChave = 0;
            mensagemCripto.set(counterInterno, umNumero + chave.get(counterChave));
            counterChave++;
            counterInterno++;
        }
        System.out.print("A chave é: ");
        chave.forEach(umElemento -> System.out.print(umElemento + " "));

        ArrayList<String> mensagemCriptoLetras = conveteNumeroLetras(mensagemCripto);

        return mensagemCriptoLetras;
    }

    private ArrayList<Integer> converteLetrasNumero(String mensagem) {
        ArrayList<Integer> mensagemCripto = new ArrayList<>(mensagem.length());
        for (char letra: mensagem.toCharArray()) {
            converteLetraNumero(mensagemCripto, letra);
        }
        return mensagemCripto;
    }
    private ArrayList<Integer> converteLetrasNumero(ArrayList<String> mensagem) {
        ArrayList<Integer> mensagemCripto = new ArrayList<>(mensagem.size());
        for (String letra: mensagem) {
            converteLetraNumero(mensagemCripto, letra.toCharArray()[0]);
        }
        return mensagemCripto;
    }

    private ArrayList<String> conveteNumeroLetras(ArrayList<Integer> mensagemCripto) {
        ArrayList<String> mensagemCriptoLetras = new ArrayList<>(mensagemCripto.size());
        for (Integer numero: mensagemCripto) {
            converteNumeroLetra(mensagemCriptoLetras, numero);
        }
        return mensagemCriptoLetras;
    }

    public void descriptografarMensagem(ArrayList<String> mensagemCripto, ArrayList<Integer> chave){
        int counterChave = 0;
        ArrayList<Integer> mensagemNumeros = converteLetrasNumero(mensagemCripto);
        Iterator<Integer> iterator = mensagemNumeros.iterator();
        ArrayList<Integer> mensagemCriptoAux = new ArrayList<>(mensagemNumeros);
        int counterInterno = 0;
        for (Integer umNumero: mensagemCriptoAux) {
            if(counterChave == 5) counterChave = 0;
            mensagemNumeros.set(counterInterno, umNumero - chave.get(counterChave));
            counterChave++;
            counterInterno++;
        }
        ArrayList<String> mensagemDescripto = new ArrayList<>(mensagemCripto.size());
        for (Integer numero: mensagemNumeros) {
            converteNumeroLetra(mensagemDescripto, numero);
        }
        mensagemDescripto.forEach(a -> {
            System.out.print(a + " ");
        });
    }
    public static void main(String[] args) {

        System.out.println("========= BEM VINDO AO CRIPTOGRAFADOR2000 =========");
        System.out.println("========= ESCOLHA UMA OPÇÃO =======================");
        System.out.println("========= 1 - CRIPTOGRAFAR UMA MENSAGEM ===========");
        System.out.println("========= 2 - DESCRIPTOGRAFAR UMA MENSAGEM ========");

        Criptografador criptografador = new Criptografador();
        Scanner scanner = new Scanner(System.in);
        boolean opcaoInvalida = false;
        Integer opcaoSelecionada = 0;
        do{
            try{
                opcaoSelecionada = scanner.nextInt();
                if(opcaoSelecionada > 2 || opcaoSelecionada < 1){
                    throw new Exception();
                }
                opcaoInvalida = true;
            }catch (Exception e){
                scanner = new Scanner(System.in);
                System.out.println("========= OPÇÃO INVÁLIDA!! DIGITE NOVAMENTE! ======");
            }

        }while (!opcaoInvalida);

        switch (opcaoSelecionada){
            case 1:
                scanner = new Scanner(System.in);
                System.out.println("========= VOCÊ DESEJA CRIPTOGRAFAR UMA MENSAGEM! ==");
                System.out.println("========= SERÃO CRIPTOGRAFADOS APENAS LETRAS E ESPAÇOS");
                System.out.println("========= INFORME A MENSAGEM ABAIXO ===============");
                String mensagem = scanner.nextLine();
                ArrayList<String> mensagemCript =  criptografador.criptografarMensagem(mensagem.toUpperCase(Locale.ROOT));
                System.out.println();
                System.out.print("Mensagem com separador: ");
                mensagemCript.forEach(um -> {
                    System.out.print(" |" + um + "| ");
                });
                System.out.println();
                System.out.print("Mensagem sem separador: ");
                mensagemCript.forEach(um -> {
                    System.out.print(um);
                });
                break;
            case 2:
                System.out.println("========= VOCÊ DESEJA DESCRIPTOGRAFAR UMA MENSAGEM! ==");
                System.out.println("========= INFORME SEPARADAMENTE A CHAVE APERTANDO ENTER A CADA MENSAGEM ");

                Integer numero;
                ArrayList<Integer> chave  = new ArrayList<>();
                boolean opcaoInvalida2 = false;
                do{

                    try{

                        System.out.println("========= DIGITE O NUMERO ======");
                        numero = scanner.nextInt();
                        if(numero > 26 || numero < 0){
                            throw new Exception();
                        }
                        chave.add(numero);
                        opcaoInvalida2 = true;
                    }catch (Exception e){
                        scanner = new Scanner(System.in);
                        System.out.println("========= NUMERO INVALIDO!! DIGITE NOVAMENTE! ======");
                    }

                }while (!opcaoInvalida2 || chave.size() != 5);
                System.out.println("========= BOA! AGORA DIGITE A MENSAGEM ==");
                System.out.println("========= INFORME - PARA ESPAÇOS EM BRANCO ==");
                ArrayList<String> mensagemCripto  = new ArrayList<>();
                scanner = new Scanner(System.in);
                String msg = scanner.nextLine();
                msg = msg.toUpperCase(Locale.ROOT);
                for (char caracter : msg.toCharArray()) {
                    mensagemCripto.add(String.valueOf(caracter));
                }

                if(mensagemCripto.size() % 5 == 0){
                    System.out.println("=========  MENSAGEM DESCRIPTOGRAFADA  =========");
                    criptografador.descriptografarMensagem(mensagemCripto, chave);
                }
                else{
                    System.out.println("=========  A MENSAGEM DEVE POSSUIR UM NUMERO DE CARACTERES DIVISIVEL POR 5  =========");
                }
                break;
        }
    }

    private static void converteLetraNumero(ArrayList<Integer> mensagemCripto, char letra){
        switch (letra){
            case 'A':
                mensagemCripto.add(1);
                break;
            case 'B':
                mensagemCripto.add(2);
                break;
            case 'C':
                mensagemCripto.add(3);
                break;
            case 'D':
                mensagemCripto.add(4);
                break;
            case 'E':
                mensagemCripto.add(5);
                break;
            case 'F':
                mensagemCripto.add(6);
                break;
            case 'G':
                mensagemCripto.add(7);
                break;
            case 'H':
                mensagemCripto.add(8);
                break;
            case 'I':
                mensagemCripto.add(9);
                break;
            case 'J':
                mensagemCripto.add(10);
                break;
            case 'K':
                mensagemCripto.add(11);
                break;
            case 'L':
                mensagemCripto.add(12);
                break;
            case 'M':
                mensagemCripto.add(13);
                break;
            case 'N':
                mensagemCripto.add(14);
                break;
            case 'O':
                mensagemCripto.add(15);
                break;
            case 'P':
                mensagemCripto.add(16);
                break;
            case 'Q':
                mensagemCripto.add(17);
                break;
            case 'R':
                mensagemCripto.add(18);
                break;
            case 'S':
                mensagemCripto.add(19);
                break;
            case 'T':
                mensagemCripto.add(20);
                break;
            case 'U':
                mensagemCripto.add(21);
                break;
            case 'V':
                mensagemCripto.add(22);
                break;
            case 'W':
                mensagemCripto.add(23);
                break;
            case 'X':
                mensagemCripto.add(24);
                break;
            case 'Y':
                mensagemCripto.add(25);
                break;
            case 'Z':
                mensagemCripto.add(26);
                break;
            case '-':
            case ' ':
                mensagemCripto.add(00);
                break;
        }
    }

    private static void converteNumeroLetra(ArrayList<String> mensagemDescripto, Integer numero){
        switch (numero){
            case 1:
                mensagemDescripto.add("A");
                break;
            case 2:
                mensagemDescripto.add("B");
                break;
            case 3:
                mensagemDescripto.add("C");
                break;
            case 4:
                mensagemDescripto.add("D");
                break;
            case 5:
                mensagemDescripto.add("E");
                break;
            case 6:
                mensagemDescripto.add("F");
                break;
            case 7:
                mensagemDescripto.add("G");
                break;
            case 8:
                mensagemDescripto.add("H");
                break;
            case 9:
                mensagemDescripto.add("I");
                break;
            case 10:
                mensagemDescripto.add("J");
                break;
            case 11:
                mensagemDescripto.add("K");
                break;
            case 12:
                mensagemDescripto.add("L");
                break;
            case 13:
                mensagemDescripto.add("M");
                break;
            case 14:
                mensagemDescripto.add("N");
                break;
            case 15:
                mensagemDescripto.add("O");
                break;
            case 16:
                mensagemDescripto.add("P");
                break;
            case 17:
                mensagemDescripto.add("Q");
                break;
            case 18:
                mensagemDescripto.add("R");
                break;
            case 19:
                mensagemDescripto.add("S");
                break;
            case 20:
                mensagemDescripto.add("T");
                break;
            case 21:
                mensagemDescripto.add("U");
                break;
            case 22:
                mensagemDescripto.add("V");
                break;
            case 23:
                mensagemDescripto.add("W");
                break;
            case 24:
                mensagemDescripto.add("X");
                break;
            case 25:
                mensagemDescripto.add("Y");
                break;
            case 26:
                mensagemDescripto.add("Z");
                break;
            case 0:
                mensagemDescripto.add(" ");
                break;
        }
    }
}

