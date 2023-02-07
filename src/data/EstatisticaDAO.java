package data;

import java.util.ArrayList;
import java.util.List;

import model.Estatistica;

public class EstatisticaDAO {
    private static EstatisticaDAO instance;
    private List<Estatistica> listaDeEstatisticas;

    private EstatisticaDAO(){
        listaDeEstatisticas = new ArrayList<>();
    }

    public static EstatisticaDAO getInstance() {
        if ( instance == null){
            instance = new EstatisticaDAO();
        }
        return instance;
    }

    public List<Estatistica> getlistaDeEstatisticas() {
        return listaDeEstatisticas;
    }
}
