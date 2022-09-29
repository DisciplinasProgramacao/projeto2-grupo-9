public class App {

      
    public static void main(String[] args) throws Exception {
       Grafo grafo = new Grafo("grafo 1");
       
       grafo.addVertice(1);
       grafo.addVertice(2);
       grafo.addVertice(3);
       
       grafo.addAresta(1, 2, 0);
       grafo.addAresta(2, 3, 0);
       
       System.out.println(grafo.existeCaminho(1, 3));
       
    }
}
