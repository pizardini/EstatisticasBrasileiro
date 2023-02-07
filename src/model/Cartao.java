package model;

public class Cartao {
    private final Integer id;
    private final Integer rodada;
    private final String clube;
    private final String cor;
    private final String atleta;
    private final String numCamisa;
    private final String posicao;

    // private final Integer minuto;

    public Cartao(Integer id, Integer rodada, String clube, String cor, String atleta, String numCamisa, String posicao) {
        this.id = id;
        this.rodada = rodada;
        this.clube = clube;
        this.cor = cor;
        this.atleta = atleta;
        this.numCamisa = numCamisa;
        this.posicao = posicao;
        // this.minuto = minuto;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRodada() {
        return rodada;
    }

    public String getClube() {
        return clube;
    }

    public String getCor() {
        return cor;
    }

    public String getAtleta() {
        return atleta;
    }

    public String getNumCamisa() {
        return numCamisa;
    }

    public String getPosicao() {
        return posicao;
    }

    // public Integer getMinuto() {
    //     return minuto;
    // }

    @Override
    public String toString() {
        return "Cartoes{" +
                "id=" + id +
                ", rodada=" + rodada +
                ", clube='" + clube + '\'' +
                ", cor='" + cor + '\'' +
                ", atleta='" + atleta + '\'' +
                ", numCamisa='" + numCamisa + '\'' +
                ", posicao='" + posicao + '\'' +
                // ", minuto=" + minuto +
                '}';
    }
}
