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

import data.CartaoDAO;
import data.EstatisticaDAO;
import data.GolDAO;
import data.PartidaDAO;

public class Carregamento {

    public Carregamento() {

        // public void carregarCartoes() {
        CartaoDAO cartaoDAO = CartaoDAO.getInstance();
        Path pathCartao = Paths.get("src/data/CSV/campeonato-brasileiro-cartoes.csv");

        try (Stream<String> cartoes = Files.lines(pathCartao)) {

            List<String> linhas = cartoes.collect(Collectors.toList());
            linhas.remove(0);// remover cabeçalho

            for (String linha : linhas) {
                String[] dados = linha.split(",");

                Integer id = Integer.parseInt(retirarAspas(dados[0]));
                Integer rodada = Integer.parseInt(retirarAspas(dados[1]));
                String clube = dados[2];
                String cor = dados[3];
                String atleta = dados[4];
                String numCamisa = dados[5];
                String posicao = dados[6];
                // Integer minuto = Integer.parseInt(dados[7]);

                Cartao cartao = new Cartao(id, rodada, clube, cor, atleta, numCamisa, posicao);
                cartaoDAO.getlistaDeCartoes().add(cartao);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // }
        // public void carregarGols() {
        GolDAO golDAO = GolDAO.getInstance();
        Path pathGol = Paths.get("src/data/CSV/campeonato-brasileiro-gols.csv");

        try (Stream<String> gols = Files.lines(pathGol)) {

            List<String> linhas = gols.collect(Collectors.toList());
            linhas.remove(0);// remover cabeçalho

            for (String linha : linhas) {
                String[] dados = linha.split(",");

                Integer id = Integer.parseInt(retirarAspas(dados[0]));
                Integer rodada = Integer.parseInt(retirarAspas(dados[1]));
                String clube = dados[2];
                String atleta = dados[3];
                // Integer minuto = Integer.parseInt(dados[4].replaceAll("\"", ""));
                // Integer.parseInt(dados[4].matches("-?\\d+") ? dados[4] : "0");
                String tipo = dados[5];

                Gol gol = new Gol(id, rodada, clube, atleta, tipo);
                golDAO.getlistaDeGols().add(gol);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // }
        // public void carregarPartidas() {
        PartidaDAO partidaDAO = PartidaDAO.getInstance();
        Path pathPartida = Paths.get("src/data/CSV/campeonato-brasileiro-full.csv");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d/M/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
        try (Stream<String> partidas = Files.lines(pathPartida)) {

            List<String> linhas = partidas.collect(Collectors.toList());
            linhas.remove(0);// remover cabeçalho

            for (String linha : linhas) {
                String[] dados = linha.split(",");

                Integer id = Integer.parseInt(retirarAspas(dados[0]));
                Integer rodada = Integer.parseInt(retirarAspas(dados[1]));
                // LocalDate data = LocalDate.parse(dados[2], formatter1);
                // LocalTime hora = LocalTime.parse(dados[3], formatter2);
                String mandante = dados[4];
                String visitante = dados[5];
                String vencedor = dados[10];
                String arena = dados[11];
                Integer placarMandante = Integer.parseInt(retirarAspas(dados[12]));
                Integer placarVisitante = Integer.parseInt(retirarAspas(dados[13]));
                String estadoMandante = dados[14];
                String estadoVisitante = dados[15];

                Partida partida = new Partida(id, rodada, mandante, visitante,
                vencedor, arena,
                placarMandante, placarVisitante, estadoMandante, estadoVisitante);
                partidaDAO.getlistaDePartidas().add(partida);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // }
        // public void carregarEstatisticas() {
        EstatisticaDAO estatisticaDAO = EstatisticaDAO.getInstance();
        Path pathEstatistica = Paths.get("src/data/CSV/campeonato-brasileiro-estatisticas-full.csv");

        try (Stream<String> estatisticas = Files.lines(pathEstatistica)) {

            List<String> linhas = estatisticas.collect(Collectors.toList());
            linhas.remove(0);// remover cabeçalho

            for (String linha : linhas) {
                String[] dados = linha.split(",");

                Integer id = Integer.parseInt(retirarAspas(dados[0]));
                Integer rodada = Integer.parseInt(retirarAspas(dados[1]));
                String clube = dados[2];
                Integer chutes = Integer.parseInt(retirarAspas(dados[3]));
                Integer chutesCertos = Integer.parseInt(retirarAspas(dados[4]));
                // Integer posse = Integer.parseInt(retirarAspas(dados[5]));
                Integer passes = Integer.parseInt(retirarAspas(dados[6]));
                // Integer precisaoPasses = Integer.parseInt(retirarAspas(dados[7]));
                Integer faltas = Integer.parseInt(retirarAspas(dados[8]));
                Integer amarelos = Integer.parseInt(retirarAspas(dados[9]));
                Integer vermelhos = Integer.parseInt(retirarAspas(dados[10]));
                Integer impedimentos = Integer.parseInt(retirarAspas(dados[11]));
                Integer escanteios = Integer.parseInt(retirarAspas(dados[12]));

                Estatistica estatistica = new Estatistica(id, rodada, clube, chutes, chutesCertos, passes,
                        faltas, amarelos, vermelhos, impedimentos, escanteios);
                estatisticaDAO.getlistaDeEstatisticas().add(estatistica);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // }
    }

    public static String retirarAspas(String dado) {
        return dado.replaceAll("\"", "");
    }
}
