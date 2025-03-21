import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GrafoLista {
    private String caminho;
    private int qntdArestas;
    private int qntdVertices;
    private Map<Character, LinkedList<Character>> listaVertices;

    public GrafoLista(String caminho){
        this.caminho = caminho;
        listaVertices = new HashMap<>();
    }

    public void inicializarListaDeVertices(){
        try (BufferedReader br = new BufferedReader(new FileReader (caminho))){
            String linha = br.readLine();
            String[] verticeAresta = linha.split(" ");
            setQntdVertices(Integer.parseInt(verticeAresta[0]));
            setQntdArestas(Integer.parseInt(verticeAresta[1]));

            for(int i = 0; i < qntdVertices; i++){
                linha = br.readLine();
                listaVertices.put(linha.charAt(0), new LinkedList<>());
            }

            for(int i = 0; i < qntdArestas; i++){
                linha = br.readLine();
                char origem = linha.charAt(0);
                char destino = linha.charAt(1);
                if(!listaVertices.get(origem).contains(destino)){
                    listaVertices.get(origem).add(destino);
                }

                if(!listaVertices.get(destino).contains(origem)){
                    listaVertices.get(destino).add(origem);
                }
            }
            
        } catch (IOException e) {
            System.out.println("Erro na leitura do arquivo" + e.getMessage());
        }
    }

    public void exibirLista(){
        for(Character i : listaVertices.keySet()){
            System.out.println(i + ": " + listaVertices.get(i));
        }
    }


    public int getQntdArestas() {
        return qntdArestas;
    }
    public void setQntdArestas(int qntdArestas) {
        this.qntdArestas = qntdArestas;
    }
    public int getQntdVertices() {
        return qntdVertices;
    }
    public void setQntdVertices(int qntdVertices) {
        this.qntdVertices = qntdVertices;
    }
    public Map<Character, LinkedList<Character>> getListaVertices() {
        return listaVertices;
    }
    public void setListaVertices(Map<Character, LinkedList<Character>> listaVertices) {
        this.listaVertices = listaVertices;
    }
    public String getCaminho() {
        return caminho;
    }
    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

}
