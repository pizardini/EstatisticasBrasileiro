package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import data.PartidaDAO;

public class MaiorPlacar {
    
    public MaiorPlacar() {
        List<Integer> listaDeGols = new ArrayList<>();
        for (Partida partida : PartidaDAO.getInstance().getlistaDePartidas()) {
            listaDeGols.add(partida.getPlacarMandante() + partida.getPlacarVisitante());
        }
        int max = listaDeGols.indexOf(Collections.max(listaDeGols));
        System.out.println(PartidaDAO.getInstance().getlistaDePartidas().get(max));
    }
}
