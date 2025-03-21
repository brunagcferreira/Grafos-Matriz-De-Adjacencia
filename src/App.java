
public class App {
    public static void main(String[] args) {
    String caminho = "/home/bruna/Documentos/AED 2/AED-2-Codes/GRAFOS/src/arquivo.txt";
    String caminho2 = "/home/bruna/Documentos/AED 2/AED-2-Codes/GRAFOS/src/teste.txt";
    Grafo grafoMatriz = new Grafo(caminho);
    GrafoLista grafoLista = new GrafoLista(caminho2);

    grafoLista.inicializarListaDeVertices();
    grafoLista.exibirLista();

    grafoMatriz.inicializarMatriz();
    grafoMatriz.exibirMatriz();
    }
}
