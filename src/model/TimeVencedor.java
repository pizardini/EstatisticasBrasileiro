package model;

import data.PartidaDAO;

import java.util.*;
import java.util.stream.Collectors;

public class TimeVencedor {

    public TimeVencedor() {
        List<Partida> listaPartidas= PartidaDAO.getInstance().getlistaDePartidas();
        Map<String, Long> vencedores2008 = listaPartidas.stream().filter(e -> e.getData().getYear()==2008).collect(Collectors.groupingBy(Partida::getVencedor, Collectors.counting()));

        Map<String, Long> mapaVencedores = vencedores2008.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("O time com mais vitórias no ano 2008 foi " + mapaVencedores.keySet().stream().filter(e -> !e.equals("\"-\"")).iterator().next()+ " com um total de " + mapaVencedores.get(mapaVencedores.keySet().stream().filter(e -> !e.equals("\"-\"")).iterator().next()) + " partidas vencidas");

}
}
