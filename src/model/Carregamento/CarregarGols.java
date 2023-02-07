package model.Carregamento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import data.GolDAO;
import model.Gol;

public class CarregarGols {

    public CarregarGols(){

        GolDAO golDAO = GolDAO.getInstance();
        Path pathGol = Paths.get("src/data/CSV/campeonato-brasileiro-gols.csv");
        
        try (Stream<String> gols = Files.lines(pathGol)) {
            
            List<String> linhas = gols.collect(Collectors.toList());
            linhas.remove(0);// remover cabeçalho
            
            for (String linha : linhas) {
                String[] dados = linha.split(",");
                
                Integer id = Integer.parseInt(Carregamento.retirarAspas(dados[0]));
                Integer rodada = Integer.parseInt(Carregamento.retirarAspas(dados[1]));
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
    }
}
    