package model;

public class Gol {
    private Integer id;
    private Integer rodada;
    private String clube;
    private String atleta;
    private Integer minuto;
    private String tipo;

    public Gol(Integer id, Integer rodada, String clube, String atleta, String tipo) {
        this.id = id;
        this.rodada = rodada;
        this.clube = clube;
        this.atleta = atleta;
        // this.minuto = minuto;
        this.tipo = tipo;
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

    public String getAtleta() {
        return atleta;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "model.Gol{" +
                "id=" + id +
                ", rodada=" + rodada +
                ", clube='" + clube + '\'' +
                ", atleta='" + atleta + '\'' +
                ", minuto=" + minuto +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
