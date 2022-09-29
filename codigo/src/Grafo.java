/** 
 * MIT License
 *
 * Copyright(c) 2021 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
 * Classe básica para um Grafo simples
 */
public class Grafo {
    public final String nome;
    private ABB<Vertice> vertices;
    private int qtdArestas;

    /**
     * Construtor. Cria um grafo vazio com capacidade para MAX_VERTICES
     */
    public Grafo(String nome) {
        this.nome = nome;
        this.vertices = new ABB<>();
        this.qtdArestas = 0;
    }

    public void carregar(String nomeArquivo) {

    }

    public void salvar(String nomeArquivo) {

    }

    /**
     * Adiciona, se possível, um vértice ao grafo. O vértice é auto-nomeado com o
     * próximo id disponível.
     */
    public boolean addVertice(int id) {
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo.
     * Não verifica se os vértices pertencem ao grafo.
     * 
     * @param origem  Vértice de origem
     * @param destino Vértice de destino
     */
    public boolean addAresta(int origem, int destino, int peso) {
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if (saida != null && chegada != null) {
            saida.addAresta(destino, peso);
            chegada.addAresta(origem, peso);
            adicionou = true;
            qtdArestas++;

        }

        return adicionou;

    }

    public Vertice existeVertice(int idVertice) {
        if (idVertice >= 0 && idVertice < this.ordem())
            return this.vertices.find(idVertice);

        return null;
    }

    public Aresta existeAresta(int verticeA, int verticeB) {
        boolean verticesExistem = (existeVertice(verticeA) != null && existeVertice(verticeB) != null);

        if (verticesExistem) {
            Vertice aux = vertices.find(verticeA);
            if (aux.existeAresta(verticeB) != null)
                return aux.existeAresta(verticeB);
            else
                return null;
        }

        return null;

    }

    public boolean existeCaminho(int verticeA, int verticeB) {

        Vertice aux = vertices.find(verticeA);
        Vertice aux2;
        int tamanho = 0;

        if (vertices.find(verticeA).existeAresta(verticeB) != null)
            return true;

        if (tamanho == vertices.size())
            return false;

        return false;
    }

    public Lista<Vertice> gerarCaminho(Vertice inicio, Vertice fim){
        Lista<Vertice> caminho = new Lista<Vertice>(); 
        caminho.add(inicio);

        
    }

    /**
     * Verifica se este é um grafo completo.
     * 
     * @return TRUE para grafo completo, FALSE caso contrário
     */
    public boolean completo() {
        int qtdVertices = this.ordem();
        int qtdArestas = this.tamanho();

        return qtdVertices*(qtdVertices-1)/2 == qtdArestas;
    }

    public Grafo subGrafo(Lista<Vertice> vertices) {
        Grafo subgrafo = new Grafo("Subgrafo de " + this.nome);

        if (vertices.tamanho() < 1)
            return null;

        for (int i = 0; i < vertices.tamanho(); i++)
            subgrafo.vertices.add(vertices.get(i).id(), vertices.get(i));

        return subgrafo;
    }

    public int tamanho() {
        return vertices.size() + this.qtdArestas;
    }

    public int ordem() {
        return this.vertices.size();
    }

}
