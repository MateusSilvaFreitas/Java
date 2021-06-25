package br.senai;

public class MergeSort {

    public static Integer[] ordena(Integer[] array){
        realizaMergeSort(0, array.length, array);
        return array;
    }
    private static void realizaMergeSort(Integer inicio, Integer fim, Integer[] array) {
        if(inicio < fim - 1) {
            int meio = (inicio + fim) / 2;
            realizaMergeSort(inicio, meio, array);
            realizaMergeSort(meio, fim, array);
            intercala(array, inicio, meio, fim);
        }
    }
    private static void intercala(Integer[] vetor, Integer inicio, Integer meio, Integer fim) {
        Integer[] novoVetor = new Integer[fim - inicio];
        Integer i = inicio;
        Integer m = meio;
        Integer pos = 0;
        while(i < meio && m < fim) {
            if(vetor[i] <= vetor[m]) {
                novoVetor[pos] = vetor[i];
                pos = pos + 1;
                i = i + 1;
            } else {
                novoVetor[pos] = vetor[m];
                pos = pos + 1;
                m = m + 1;
            }
        }
        while(i < meio) {
            novoVetor[pos] = vetor[i];
            pos = pos + 1;
            i = i + 1;
        }
        while(m < fim) {
            novoVetor[pos] = vetor[m];
            pos = pos + 1;
            m = m + 1;
        }
        for(pos = 0, i = inicio; i < fim; i++, pos++) {
            vetor[i] = novoVetor[pos];
        }
    }
}

