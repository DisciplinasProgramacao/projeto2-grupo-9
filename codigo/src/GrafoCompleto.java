public class GrafoCompleto extends Grafo {
    private int ordem;
    private ABB<Vertice> vertices;

    public GrafoCompleto(String nome, int ordem) {
        super(nome);
        this.ordem = ordem;

        for (int i = 0; i < ordem; i++) {
            Vertice novoVertice = new Vertice(i);
            this.vertices.add(i, novoVertice);
        }

        for (int j = 0; j < ordem; j++) {
            for (int k = j + 1; k < ordem; k++) {
                Vertice saida = this.vertices.find(j);
                Vertice chegada = this.vertices.find(k);

                saida.addAresta(k, 0);
                chegada.addAresta(j, 0);
            }
        }
    }

    @Override
    public boolean completo() {
        return true;
    }

    @Override
    public Aresta existeAresta(int verticeA, int verticeB) {
        boolean verticesExistem = (existeVertice(verticeA) != null && existeVertice(verticeB) != null);

        if (verticesExistem) {
            Vertice origem = this.vertices.find(verticeA);
            return origem.existeAresta(verticeB);
        }

        return null;
    }

}