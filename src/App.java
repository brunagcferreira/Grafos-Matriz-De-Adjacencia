
public class App {
    public static void main(String[] args) {
    String caminho = "/home/bruna/Documentos/AED 2/AED-2-Codes/GRAFOS/src/arquivo.txt";
    Grafo grafo = new Grafo(caminho);
    grafo.inicializarMatriz();
    grafo.exibirMatriz();
    }
}
