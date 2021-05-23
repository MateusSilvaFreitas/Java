package br.senai.sc.torresdehanoi;

public interface TorreHanoi {
    public void push(int disco) throws Exception;
    public int pop() throws Exception;
    public int tamanho();
    public boolean vazia();
}
