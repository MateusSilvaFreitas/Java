public class ListaComEncadeamento {
    NoLista inicio;
    NoLista fim;
    private int counter = 0;

    public ListaComEncadeamento() {
        counter = 0;
        inicio = null;
        fim = null;
    }
    public ListaComEncadeamento merge(ListaComEncadeamento listaMerge){
        NoLista noListaMergear = listaMerge.getInicio();
        if(inicio == null){
            return listaMerge;
        } else if(noListaMergear == null){
            return this;
        }
        ListaComEncadeamento listaAuxiliar = new ListaComEncadeamento();

        NoLista noListaBase = inicio;
        do{
            if(noListaBase == null){
                noListaBase = noListaMergear;
                continue;
            } else if (noListaMergear == null){
                break;
            }
            NoLista noAux;
            if(noListaBase.getInformacao() <= noListaMergear.getInformacao()){
                noAux = noListaBase.getNext();
                noListaBase.setNext(noListaMergear);
                noListaBase.getNext().setNext(noAux);
            } else{
                noAux = noListaBase;
                noListaBase = noListaMergear;
                noListaBase.setNext(noAux);
            }
            noListaBase = noListaBase.getNext();
            noListaMergear = noListaMergear.getNext();

        } while(noListaBase.getNext() != null && noListaMergear.getNext() != null);

        return this;
    }
    public void add(Integer informacao) {
        NoLista noAdicionar = new NoLista(informacao, null);
        if(inicio == null) {
            fim = noAdicionar;
        } else {
            fim.setNext(noAdicionar);
        }
        fim = noAdicionar;
        counter++;
    }
    public NoLista getInicio(){
        return inicio;
    }
}
