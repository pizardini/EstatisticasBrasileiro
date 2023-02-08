package model;

import data.CartaoDAO;

import java.util.*;
import java.util.stream.Collectors;

public class CartaoVermelho {

    public CartaoVermelho() {
        List<Cartao> listaCartoes = CartaoDAO.getInstance().getlistaDeCartoes();
        Map<String, Long> cartoesAmarelo = listaCartoes.stream().filter(e -> e.getCor().contains("Vermelho"))
                .collect(Collectors.groupingBy(Cartao::getAtleta, Collectors.counting()));

        Optional<Map.Entry<String, Long>> maxEntry = cartoesAmarelo.entrySet().stream().max(
                Comparator.comparing(Map.Entry::getValue)
        );

        System.out.println("Jogador com maior número de cartões vermelhos: " + maxEntry.get().getKey() + " " + maxEntry.get().getValue() + " cartões vermelhos");
    }
}
