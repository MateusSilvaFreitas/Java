public class NoArvoreBinaria {
    private Integer informacao;
    private NoArvoreBinaria filhoEsquerda;
    private NoArvoreBinaria filhoDireita;



    public NoArvoreBinaria() {
        this.informacao = null;
        this.filhoEsquerda = null;
        this.filhoDireita = null;
    }
    public NoArvoreBinaria(Integer informacao, NoArvoreBinaria filhoEsquerda, NoArvoreBinaria filhoDireita) {
        this.informacao = informacao;
        this.filhoEsquerda = filhoEsquerda;
        this.filhoDireita = filhoDireita;
    }


    public Integer getInformacao() {
        return informacao;
    }
    public void setInformacao(Integer informacao) {
        this.informacao = informacao;
    }
    public NoArvoreBinaria getFilhoEsquerda() {
        return filhoEsquerda;
    }
    public NoArvoreBinaria getFilhoDireita() { return filhoDireita; }
    public void setFilhoEsquerda(NoArvoreBinaria filhoEsquerda){ this.filhoEsquerda = filhoEsquerda;}
    public void setFilhoDireita(NoArvoreBinaria filhoDireita){ this.filhoDireita = filhoDireita;}


}
