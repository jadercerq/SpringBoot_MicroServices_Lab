
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//imports omitidos  
public class StreamClass {
    
//    public static void main(String[] args) {
//        List<Integer> lista = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
//        List<Integer> lista2 = new  ArrayList<>();
//        lista.stream().forEach(x -> lista2.add(x + 1));
//        lista2.stream().forEach(x -> System.out.println(x));
//    }

    public boolean verificarArquivoExiste(Path caminho) {

        boolean ret = false;

        try {

            Stream<Path> stream = Files.list(caminho);
            Optional<Path> arq = stream.filter(p -> p.toString().endsWith("jogadores.txt")).findAny();

            ret = arq.isPresent(); //informa se o arquivo está presente

        } catch (IOException ex) {

            ex.printStackTrace();

        }
        return ret;
    }

    public List<Jogador> getListaDeJogadores(Path caminho) throws IOException {

        Stream<String> linhas = Files.lines(caminho, StandardCharsets.ISO_8859_1);

        List<String> listaDeLinhas = linhas.collect(Collectors.toList());
        
        List<Jogador> listaDeJogadores = new ArrayList<>();

        Jogador jogador;
        
        Iterator it = listaDeLinhas.listIterator();

        String str = null;

        while (it.hasNext()) {

            str = (String) it.next();
            String info[]
                    = str.split(",");

            jogador = new Jogador();
            jogador.setNome(info[0]);
            jogador.setPosicao(info[1]);
            jogador.setIdade(Integer.parseInt(info[2]));
            jogador.setTimeAtual(info[3]);
            jogador.setGolsMarcados(Integer.parseInt(info[4]));
            listaDeJogadores.add(jogador);
        }
        return listaDeJogadores;
    }

    public void imprimirJogadores(List<Jogador> jogadores) {
        jogadores.stream().forEach(System.out::println);
    }

    public void imprimirJogadoresTime(List<Jogador> jogadores, String time) {
        jogadores.stream().filter(jogador -> jogador.getTimeAtual().equals(time)).
                forEach(System.out::println);

    }

    public void imprimirJogadoresTimeGols(List<Jogador> jogadores, String time) {
        jogadores.stream().
                filter(jogador -> jogador.getTimeAtual().equals(time) && jogador.getGolsMarcados() > 10).
                forEach(System.out::println);

    }

    public void agruparJogadoresPorTime(List<Jogador> jogadores) {
        jogadores.stream().
                sorted(Comparator.comparing(Jogador::getTimeAtual)).forEach(System.out::println);

    }

    public double calcularMediaIdade(List<Jogador> jogadores) {
        return jogadores.stream().mapToInt(Jogador::getIdade).average().getAsDouble();

    }

    public void imprimirJogadorMaisVelho(List<Jogador> jogadores) {
        Jogador jogador = jogadores.stream().max(Comparator.comparingInt(Jogador::getIdade)).get();
        System.out.println("Jogador mais velho: " + jogador.getNome());
    }

    public void imprimirJogadorMaisNovo(List<Jogador> jogadores) {
        Jogador jogador = jogadores.stream().min(Comparator.comparingInt(Jogador::getIdade)).get();
        System.out.println("Jogador mais novo: " + jogador.getNome());
    }

    public void imprimirJogadorArtilheiro(List<Jogador> jogadores) {
        Jogador jogador = jogadores.stream().max(Comparator.comparingInt(Jogador::getGolsMarcados)).get();
        System.out.println("Jogador Artilheiro: " + jogador.getNome());
    }

    public int imprimirSomatorioGols(List<Jogador> jogadores) {
        return jogadores.stream().mapToInt(jogador -> jogador.getGolsMarcados()).sum();
    }

    public void agruparJogadoresPeloTime(List<Jogador> jogadores) {
        Map<String, List<Jogador>> groupByTime = jogadores.stream().
                collect(Collectors.groupingBy(Jogador::getTimeAtual));
        System.out.println(groupByTime);
    }

    public void ordenarJogadoresGols(List<Jogador> jogadores) {
        jogadores.stream().
                sorted(Comparator.comparingInt(Jogador::getGolsMarcados).
                reversed()).forEach(System.out::println);
    }
}

class Jogador {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTimeAtual() {
        return timeAtual;
    }

    public void setTimeAtual(String timeAtual) {
        this.timeAtual = timeAtual;
    }

    public int getGolsMarcados() {
        return golsMarcados;
    }

    public void setGolsMarcados(int golsMarcados) {
        this.golsMarcados = golsMarcados;
    }
    private String posicao;
    private int idade;
    private String timeAtual;
    private int golsMarcados;

    @Override
    public String toString() {
        return this.nome + " " + this.posicao + " " + this.getTimeAtual();
    }
}
