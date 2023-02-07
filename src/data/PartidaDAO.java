package data;

import java.util.ArrayList;
import java.util.List;

import model.Partida;

public class PartidaDAO {
    private static PartidaDAO instance;
    private List<Partida> listaDePartidas;

    private PartidaDAO(){
        listaDePartidas = new ArrayList<>();
    }

    public static PartidaDAO getInstance() {
        if ( instance == null){
            instance = new PartidaDAO();
        }
        return instance;
    }

    public List<Partida> getlistaDePartidas() {
        return listaDePartidas;
    }
}
