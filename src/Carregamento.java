import model.Cartao;
import model.Estatistica;
import model.Gol;
import model.Partida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Carregamento {

    public void carregarCartoes() {

        Path path = Paths.get("campeonato-brasileiro-cartoes.csv");

        try (Stream<String> cartoes = Files.lines(path)) {

            List<String> linhas = cartoes.collect(Collectors.toList());
            List<Cartao> listaCartoes = new ArrayList<>();

            for (String linha : linhas) {
                String[] dados = linha.split(",");

                Integer id = Integer.parseInt(dados[0]);
                Integer rodada = Integer.parseInt(dados[1]);
                String clube = dados[2];
                String cor = dados[3];
                String atleta = dados[4];
                String numCamisa = dados[5];
                String posicao = dados[6];
                Integer minuto = Integer.parseInt(dados[7]);

                Cartao cartao = new Cartao(id, rodada, clube, cor, atleta, numCamisa, posicao, minuto);
                listaCartoes.add(cartao);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void carregarGols() {

        Path path = Paths.get("campeonato-brasileiro-gols.csv");

        try (Stream<String> gols = Files.lines(path)) {

            List<String> linhas = gols.collect(Collectors.toList());
            List<Gol> listaGols = new ArrayList<>();

            for (String linha : linhas) {
                String[] dados = linha.split(",");

                Integer id = Integer.parseInt(dados[0]);
                Integer rodada = Integer.parseInt(dados[1]);
                String clube = dados[2];
                String atleta = dados[3];
                Integer minuto = Integer.parseInt(dados[4]);
                String tipo = dados[5];


                Gol gol = new Gol(id, rodada, clube, atleta, minuto, tipo);
                listaGols.add(gol);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void carregarPartidas() {

        Path path = Paths.get("campeonato-brasileiro-full.csv");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d/M/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
        try (Stream<String> partidas = Files.lines(path)) {

            List<String> linhas = partidas.collect(Collectors.toList());
            List<Partida> listaPartidas = new ArrayList<>();

            for (String linha : linhas) {
                String[] dados = linha.split(",");

                Integer id = Integer.parseInt(dados[0]);
                Integer rodada = Integer.parseInt(dados[1]);
                LocalDate data = LocalDate.parse(dados[2], formatter1);
                LocalTime hora = LocalTime.parse(dados[3], formatter2);
                String mandante = dados[4];
                String visitante = dados[5];
                String vencedor = dados[10];
                String arena = dados[11];
                Integer placarMandante = Integer.parseInt(dados[12]);
                Integer placarVisitante = Integer.parseInt(dados[13]);
                String estadoMandante = dados[14];
                String estadoVisitante = dados[15];


                Partida partida = new Partida(id, rodada, data, hora, mandante, visitante, vencedor, arena,
                        placarMandante, placarVisitante, estadoMandante, estadoVisitante);
                listaPartidas.add(partida);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void carregarEstatisticas() {

        Path path = Paths.get("campeonato-brasileiro-estatisticas-full.csv");

        try (Stream<String> estatisticas = Files.lines(path)) {

            List<String> linhas = estatisticas.collect(Collectors.toList());
            List<Estatistica> listaEstatisticas = new ArrayList<>();

            for (String linha : linhas) {
                String[] dados = linha.split(",");

                Integer id = Integer.parseInt(dados[0]);
                Integer rodada = Integer.parseInt(dados[1]);
                String clube = dados[2];
                Integer chutes = Integer.parseInt(dados[3]);
                Integer chutesCertos = Integer.parseInt(dados[4]);
                Integer posse = Integer.parseInt(dados[5]);
                Integer passes = Integer.parseInt(dados[6]);
                Integer precisaoPasses = Integer.parseInt(dados[7]);
                Integer faltas = Integer.parseInt(dados[8]);
                Integer amarelos = Integer.parseInt(dados[9]);
                Integer vermelhos = Integer.parseInt(dados[10]);
                Integer impedimentos = Integer.parseInt(dados[11]);
                Integer escanteios = Integer.parseInt(dados[12]);



                Estatistica estatistica = new Estatistica(id, rodada, clube, chutes, chutesCertos, posse, passes, precisaoPasses, faltas,
                        amarelos, vermelhos, impedimentos, escanteios);
                listaEstatisticas.add(estatistica);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
