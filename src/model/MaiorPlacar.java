package model;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import data.PartidaDAO;

public class MaiorPlacar {
    
    public MaiorPlacar() {
        List<Partida> listaDePartidas = PartidaDAO.getInstance().getlistaDePartidas();
        List<Integer> listaDeGols = listaDePartidas.stream().map(e->e.getPlacarMandante()+e.getPlacarVisitante()).toList();
        int index = listaDeGols.indexOf(Collections.max(listaDeGols));
        DateTimeFormatter brDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        System.out.println("O placar com o maior número de gols foi "+ listaDePartidas.get(index).getPlacarMandante()+" X "+ listaDePartidas.get(index).getPlacarVisitante());
        System.out.println("No jogo "+listaDePartidas.get(index).getMandante()+" X "+listaDePartidas.get(index).getVisitante());
        System.out.println("Na rodada"+ listaDePartidas.get(index).getRodada()+" no estádio da "+listaDePartidas.get(index).getArena()+" no dia "+listaDePartidas.get(index).getData().format(brDateFormat));
    }
}
