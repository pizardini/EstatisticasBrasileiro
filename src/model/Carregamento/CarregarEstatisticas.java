package model.Carregamento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import data.EstatisticaDAO;
import model.Estatistica;

public class CarregarEstatisticas {
    
    public CarregarEstatisticas(){

        EstatisticaDAO estatisticaDAO = EstatisticaDAO.getInstance();
        Path pathEstatistica = Paths.get("src/data/CSV/campeonato-brasileiro-estatisticas-full.csv");
        
        try (Stream<String> estatisticas = Files.lines(pathEstatistica)) {
            
            List<String> linhas = estatisticas.collect(Collectors.toList());
            linhas.remove(0);// remover cabeçalho
            
            for (String linha : linhas) {
                String[] dados = linha.split(",");
                
                Integer id = Integer.parseInt(Carregamento.retirarAspas(dados[0]));
                Integer rodada = Integer.parseInt(Carregamento.retirarAspas(dados[1]));
                String clube = dados[2];
                Integer chutes = Integer.parseInt(Carregamento.retirarAspas(dados[3]));
                Integer chutesCertos = Integer.parseInt(Carregamento.retirarAspas(dados[4]));
                // Integer posse = Integer.parseInt(retirarAspas(dados[5]));
                Integer passes = Integer.parseInt(Carregamento.retirarAspas(dados[6]));
                // Integer precisaoPasses = Integer.parseInt(retirarAspas(dados[7]));
                Integer faltas = Integer.parseInt(Carregamento.retirarAspas(dados[8]));
                Integer amarelos = Integer.parseInt(Carregamento.retirarAspas(dados[9]));
                Integer vermelhos = Integer.parseInt(Carregamento.retirarAspas(dados[10]));
                Integer impedimentos = Integer.parseInt(Carregamento.retirarAspas(dados[11]));
                Integer escanteios = Integer.parseInt(Carregamento.retirarAspas(dados[12]));
                
                Estatistica estatistica = new Estatistica(id, rodada, clube, chutes, chutesCertos, passes,
                faltas, amarelos, vermelhos, impedimentos, escanteios);
                estatisticaDAO.getlistaDeEstatisticas().add(estatistica);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    