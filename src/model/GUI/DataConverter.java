package model.GUI;

import java.util.List;
import java.util.Vector;
import data.GolDAO;
import model.Gol;

public class DataConverter {
    private List<Gol> golDAO = GolDAO.getInstance().getlistaDeGols();
    private Vector<Vector<Object>> listaGols = new Vector<>();
    private Vector<Object> column = new Vector<>();

    public DataConverter(){
        for (int i = 0; i < golDAO.size(); i++) {
            Vector<Object> row = new Vector<>();
            row.add(golDAO.get(i).getRodada());
            row.add(golDAO.get(i).getClube());
            row.add(golDAO.get(i).getAtleta());
            listaGols.add(row);
        }
        column.add("Rodada");
        column.add("Clube");
        column.add("Atleta");
    }

    public Vector<Vector<Object>> getListaGols() {
        return listaGols;
    }

    public Vector<Object> getColumn() {
        return column;
    }
    
}
