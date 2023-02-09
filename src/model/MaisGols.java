package model;

import data.GolDAO;


import java.util.*;
import java.util.stream.Collectors;

public class MaisGols {
    public MaisGols() {
        List<Gol> listaGols = GolDAO.getInstance().getlistaDeGols();
        Map<String, Long> mapGols = listaGols.stream().collect(Collectors.groupingBy(Gol::getAtleta, Collectors.counting()));

        Map<String, Long> mapaJogador = mapGols.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("O jogador com mais gols " + mapaJogador.keySet().iterator().next() + ": " + mapaJogador.get(mapaJogador.keySet().iterator().next()) + " gols");
    }
}

