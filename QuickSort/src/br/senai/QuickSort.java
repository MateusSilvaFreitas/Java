package br.senai;

public class QuickSort {
    private static int posInicio;
    private static int posFim;

    public static Integer[] orderna(Integer array[]){
        posInicio = 0;
        posFim = array.length - 1;
        encontraPivo(array, posInicio, posFim);
        return array;
    }
    private static void encontraPivo(Integer array[], int posInicio, int posFim){
        if(posInicio >= posFim){
            return;
        }
        int posPercorrendo = posInicio + 1;
        int posPivo = posInicio;
        do{
            if(posPivo < posFim && array[posPivo] > array[posPercorrendo]){
                int pivoAux = array[posPivo];
                array[posPivo] = array[posPercorrendo];
                for (int i = posPercorrendo; i > posPivo; i--){
                    array[i] = array[i-1];
                }
                posPivo++;
                array[posPivo] = pivoAux;
            }
            posPercorrendo++;

        }while(posPercorrendo <= posFim);
        encontraPivo(array, posPivo + 1, posFim);
        encontraPivo(array, 0, posPivo - 1);
    }
}
