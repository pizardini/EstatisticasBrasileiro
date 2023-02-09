import model.*;
import model.Carregamento.Carregamento;
import util.Drawer;

public class Main {
    public static void main(String[] args) {
        Carregamento carregamento = new Carregamento();
        Drawer.drawHeader("ESTATISTICAS BRASILEIRÃO", 80);
        TimeVencedor timeVencedor = new TimeVencedor();
        Drawer.drawLine(80);
        EstadoMenosPartidas estadoMenosPartidas = new EstadoMenosPartidas();
        Drawer.drawLine(80);
        MaisGols maisGols = new MaisGols();
        Drawer.drawLine(80);
        GolsPenalti golsPenalti = new GolsPenalti();
        Drawer.drawLine(80);
        GolsContra golsContra = new GolsContra();
        Drawer.drawLine(80);
        CartaoAmarelo cartaoAmarelo = new CartaoAmarelo();
        CartaoVermelho cartaoVermelho = new CartaoVermelho();
        Drawer.drawLine(80);
        MaiorPlacar maiorPlacar = new MaiorPlacar();
    }

}