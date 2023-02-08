package model;

import data.GolDAO;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GolsContra {
    public GolsContra() {
        List<Gol> listaGols = GolDAO.getInstance().getlistaDeGols();
        Map<String, Long> listaContra = listaGols.stream().filter(e -> e.getTipo().contains("Gol Contra"))
                .collect(Collectors.groupingBy(Gol::getAtleta, Collectors.counting()));

        Map<String, Long> mapaContra = listaContra.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("Jogador com mais gols contra " + mapaContra.keySet().iterator().next() + ": " + mapaContra.get(mapaContra.keySet().iterator().next()) + " gols");
    }
}

