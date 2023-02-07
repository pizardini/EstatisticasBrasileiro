package data;

import java.util.ArrayList;
import java.util.List;

import model.Gol;

public class GolDAO {
    private static GolDAO instance;
    private List<Gol> listaDeGols;

    private GolDAO(){
        listaDeGols = new ArrayList<>();
    }

    public static GolDAO getInstance() {
        if ( instance == null){
            instance = new GolDAO();
        }
        return instance;
    }

    public List<Gol> getlistaDeGols() {
        return listaDeGols;
    }
}
