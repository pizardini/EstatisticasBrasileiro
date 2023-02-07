import model.Gol;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Gol> listaGols = new ArrayList<>();
        Carregamento carregamento = new Carregamento();
        carregamento.carregarGols();
    }

}