package model.Carregamento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import data.CartaoDAO;
import model.Cartao;

public class CarregarCartoes {

    public CarregarCartoes(){

        CartaoDAO cartaoDAO = CartaoDAO.getInstance();
        Path pathCartao = Paths.get("src/data/CSV/campeonato-brasileiro-cartoes.csv");

        try (Stream<String> cartoes = Files.lines(pathCartao)) {

            List<String> linhas = cartoes.collect(Collectors.toList());
            linhas.remove(0);// remover cabeçalho
            
            for (String linha : linhas) {
                String[] dados = linha.split(",");
                
                Integer id = Integer.parseInt(Carregamento.retirarAspas(dados[0]));
                Integer rodada = Integer.parseInt(Carregamento.retirarAspas(dados[1]));
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
    }
}
