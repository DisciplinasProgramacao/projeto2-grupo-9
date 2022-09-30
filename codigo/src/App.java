public class App {

      
    public static void main(String[] args) throws Exception {
       
            
       final String path = "C:\\Users\\Rafael\\Documents\\GitHub\\projeto2-grupo-9\\codigo\\grafo.txt";
       
       Grafo grafo = new Grafo("1");

       boolean carregamento = grafo.carregar(path);
       
    }
}
