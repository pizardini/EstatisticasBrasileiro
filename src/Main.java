import data.PartidaDAO;

public class Main {
    public static void main(String[] args) {
        Carregamento carregamento = new Carregamento();
        System.out.println(PartidaDAO.getInstance().getlistaDePartidas().get(1));
        System.out.println(PartidaDAO.getInstance().getlistaDePartidas().get(1).getPlacarMandante());
        System.out.println(PartidaDAO.getInstance().getlistaDePartidas().get(1).getPlacarVisitante());
    }

}