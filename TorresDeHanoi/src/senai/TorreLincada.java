package senai;

public class TorreLincada{
    private final PilhaLincada<Integer> t;
    private int tamanho;
    
    public TorreLincada() {
        t = new PilhaLincada<>();
        tamanho = 0;
    }

    public void push(int disco) throws Exception {
        t.push(disco);
        tamanho++;
    }

    public int pop() throws Exception {
        tamanho--;
        return t.pop();
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean vazia() {
        return t.vazia();
    }
}
