import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo{
    //Atributos
    private int qntdVertices;
    private int qntdArestas;
    private Map<Character, Integer> mapaVertices;
    private int[][] matriz;
    private String caminho;

    //Construtor
    public Grafo(String caminho){
        this.caminho = caminho;
        mapaVertices = new HashMap<>();
    }

    //Métodos
    public void inicializarMatriz(){
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            
            String linha = br.readLine(); //lê a primeira linha (V, A)
            String[] verticeAresta = linha.split(" "); //separa no formato ["V", "A"]
            setQntdVertices(Integer.parseInt(verticeAresta[0])); //converte de String para Integer e atribui a this.Vertice
            setQntdArestas(Integer.parseInt(verticeAresta[1])); //converte de String para Integer e atribui a this.Arestas

            this.matriz = new int[qntdVertices][qntdVertices];

            //armazena os vertices no formato HashMap("vertice" -> idx) e inicializa a matriz identidade
            for(int i = 0; i < qntdVertices; i++){
                linha = br.readLine();
                mapaVertices.put(linha.charAt(0), i);

                matriz[i][i] = 1;
            }
            
            //faz as conexões entre vertices (matriz de adjacência)
            for(int i = 0; i < qntdArestas; i++){
                linha = br.readLine();
                char origem = linha.charAt(0);
                char destinho = linha.charAt(1);

                int idxOrigem = mapaVertices.get(origem);
                int idxDestino = mapaVertices.get(destinho);

                matriz[idxDestino][idxOrigem] = 1;
                matriz[idxOrigem][idxDestino] = 1;
            }


        } catch (IOException e) {
            System.out.println("erro ao ler arquivo: " + e.getMessage());
        }
    }

    public void exibirMatriz() {
        // Obter a lista de vértices a partir do mapa
        List<Character> listaVertices = new ArrayList<>(mapaVertices.keySet());
        Collections.sort(listaVertices, Comparator.comparingInt(mapaVertices::get)); // Ordena na ordem correta

        
        System.out.print("   "); 
        for (char v : listaVertices) {
            System.out.print(v + "  ");
        }
        System.out.println();

        
        for (char v : listaVertices) {
            System.out.print(v + "  "); 
            for (char u : listaVertices) {
                System.out.print(matriz[mapaVertices.get(v)][mapaVertices.get(u)] + "  "); 
            }
            System.out.println();
        }
    }


    //Getters e Setters 
    public int getQntdVertices() {
        return qntdVertices;
    }

    public void setQntdVertices(int vertices) {
        this.qntdVertices = vertices;
    }

    public int getQntdArestas() {
        return qntdArestas;
    }

    public void setQntdArestas(int arestas) {
        this.qntdArestas = arestas;
    }

    public Map<Character, Integer> getMapaVertices() {
        return mapaVertices;
    }

    public void setMapaVertices(Map<Character, Integer> mapaVertices) {
        this.mapaVertices = mapaVertices;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    
}