package br.senai;

public class Main {
    public static void main(String[] args) {
        Integer vetor[] = new Integer[10];
        vetor[0] = 10;
        vetor[1] = 52;
        vetor[2] = 66;
        vetor[3] = 74;
        vetor[4] = 7654;
        vetor[5] = 321;
        vetor[6] = 741;
        vetor[7] = 234;
        vetor[8] = 777;
        vetor[9] = 10;
        MergeSort.ordena(vetor);
        System.out.println(vetor);

    }
}
