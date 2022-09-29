public class GrafoPonderado extends Grafo{
    public GrafoPonderado(String nome) {
		super(nome);
	}

    public boolean addAresta(int origem, int destino, int peso) {
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if (saida != null && chegada != null) {
            saida.addAresta(destino, peso);
            chegada.addAresta(origem, peso);
            adicionou = true;
            super.qtdArestas++;

        }

        return adicionou;

    }

}
