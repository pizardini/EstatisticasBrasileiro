package data;

import java.util.ArrayList;
import java.util.List;

import model.Cartao;

public class CartaoDAO {
    private static CartaoDAO instance;
    private List<Cartao> listaDeCartoes;

    private CartaoDAO(){
        listaDeCartoes = new ArrayList<>();
    }

    public static CartaoDAO getInstance() {
        if ( instance == null){
            instance = new CartaoDAO();
        }
        return instance;
    }

    public List<Cartao> getlistaDeCartoes() {
        return listaDeCartoes;
    }
}
