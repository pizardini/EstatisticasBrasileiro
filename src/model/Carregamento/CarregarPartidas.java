package model.Carregamento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import data.PartidaDAO;
import model.Partida;

public class CarregarPartidas {

    public CarregarPartidas(){

        PartidaDAO partidaDAO = PartidaDAO.getInstance();
        Path pathPartida = Paths.get("src/data/CSV/campeonato-brasileiro-full.csv");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d/M/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
        
        try (Stream<String> partidas = Files.lines(pathPartida)) {
            
            List<String> linhas = partidas.collect(Collectors.toList());
            linhas.remove(0);// remover cabeçalho
            
            for (String linha : linhas) {
                String[] dados = linha.split(",");
                
                Integer id = Integer.parseInt(Carregamento.retirarAspas(dados[0]));
                Integer rodada = Integer.parseInt(Carregamento.retirarAspas(dados[1]));
                LocalDate data = LocalDate.parse(Carregamento.retirarAspas(dados[2]), formatter1);
                // LocalTime hora = LocalTime.parse(dados[3], formatter2);
                String mandante = dados[4];
                String visitante = dados[5];
                String vencedor = dados[10];
                String arena = dados[11];
                Integer placarMandante = Integer.parseInt(Carregamento.retirarAspas(dados[12]));
                Integer placarVisitante = Integer.parseInt(Carregamento.retirarAspas(dados[13]));
                String estadoMandante = dados[14];
                String estadoVisitante = dados[15];

                Partida partida = new Partida(id, rodada, data, mandante, visitante,
                vencedor, arena,
                placarMandante, placarVisitante, estadoMandante, estadoVisitante);
                partidaDAO.getlistaDePartidas().add(partida);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    