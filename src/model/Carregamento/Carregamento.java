package model.Carregamento;

public class Carregamento {

    public Carregamento() {

        CarregarCartoes carregarCartoes = new CarregarCartoes();
        CarregarGols carregarGols = new CarregarGols();
        CarregarPartidas carregarPartidas = new CarregarPartidas();
        CarregarEstatisticas carregarEstatisticas = new CarregarEstatisticas();
    }

    public static String retirarAspas(String dado) {
        return dado.replaceAll("\"", "");
    }
}
