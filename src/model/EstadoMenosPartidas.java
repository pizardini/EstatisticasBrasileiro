package model;

import data.PartidaDAO;

import java.util.*;
import java.util.stream.Collectors;

public class EstadoMenosPartidas {
    public EstadoMenosPartidas(){
        List<Partida> listaPartidas = PartidaDAO.getInstance().getlistaDePartidas().stream()
                .filter(n -> n.getData().getYear() >=2003 && n.getData().getYear() <= 2022).toList();

        Map<String, Long> mapEstados = listaPartidas.stream()
                .collect(Collectors.groupingBy(Partida::getEstadoMandante, Collectors.counting()));

        Map<String, Long> mapEstadoMenorNumeroPartidas = mapEstados.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        Optional<Map.Entry<String, Long>> minEntry = mapEstadoMenorNumeroPartidas.entrySet().stream().min(
                Comparator.comparing(Map.Entry::getValue)
        );

        List<Map.Entry<String, Long>> listaMap = mapEstadoMenorNumeroPartidas.entrySet()
                .stream().filter(n -> n.getValue() == minEntry.get().getValue()).toList();


        String entradasFormatadas = "";
        for (int j = 0; j < listaMap.size(); j++) {
            if (j!=listaMap.size()-1){
                entradasFormatadas += listaMap.get(j) + ", ";
            }
            else entradasFormatadas += listaMap.get(j);
        }
        System.out.println("O(s) estado(s) com menos partidas é(são): " +entradasFormatadas);
    }
}
