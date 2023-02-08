package model;

import data.GolDAO;

import java.util.*;
import java.util.stream.Collectors;

public class GolsPenalti {
    public GolsPenalti() {
        List<Gol> listaGols = GolDAO.getInstance().getlistaDeGols();
        Map<String, Long> listaPenalti = listaGols.stream().filter(e -> e.getTipo().contains("Penalty"))
                .collect(Collectors.groupingBy(Gol::getAtleta, Collectors.counting()));

        Map<String, Long> mapaPenalti = listaPenalti.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("Jogador com mais gols de pênalti " + mapaPenalti.keySet().iterator().next() + ": " + mapaPenalti.get(mapaPenalti.keySet().iterator().next()) + " gols");
    }
}
