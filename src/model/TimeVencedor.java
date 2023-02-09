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

        Long maxWin = mapaVencedores.get(mapaVencedores.keySet().stream().filter(e -> !e.equals("\"-\"")).iterator().next());
        List<String> vencedores = new ArrayList<>();

        for (int i = 0; i < mapaVencedores.size(); i++) {
            if(mapaVencedores.values().toArray()[i]==maxWin){
                vencedores.add((String) (mapaVencedores.keySet().toArray())[i]);
            }
        }
        String vencedoresFormatado = "";
        for (int j = 0; j < vencedores.size(); j++) {
            if (j!=vencedores.size()-1){
                vencedoresFormatado += vencedores.get(j) + ", ";
            }
            else vencedoresFormatado += vencedores.get(j);
        }
        
        System.out.println("O(s) time(s) com mais vitórias no ano 2008 foi(foram): \n" + vencedoresFormatado +
                " com um total de " + maxWin + " partidas vencidas");

}
}
