package model;

import data.CartaoDAO;

import java.util.*;

public class CartaoVermelho {

    public CartaoVermelho() {
        List<Cartao> listaCartoes = CartaoDAO.getInstance().getlistaDeCartoes();
        Map<String, Integer> cartoesAmarelo = new HashMap<>();

        for(Cartao cartao : listaCartoes) {
            if(cartao.getCor().equals("\"Vermelho\"")) {
                cartoesAmarelo.put(cartao.getAtleta(), (cartoesAmarelo.get(cartao.getAtleta()) != null) ? cartoesAmarelo.get(cartao.getAtleta()) + 1 : 1);
            }
        }

        Optional<Map.Entry<String, Integer>> maxEntry = cartoesAmarelo.entrySet().stream().max(
                Comparator.comparing(Map.Entry::getValue)
        );

        System.out.println("Jogador com maior número de cartões vermelhos: " + maxEntry.get());    }

}
