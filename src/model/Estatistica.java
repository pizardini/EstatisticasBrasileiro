package model;

public class Estatistica {
    private Integer id;
    private Integer rodada;
    private String clube;
    private Integer chutes;
    private Integer chutesCertos;
    private Integer posse;
    private Integer passes;
    private Integer precisaoPasses;
    private Integer faltas;
    private Integer amarelos;
    private Integer vermelhos;
    private Integer impedimentos;
    private Integer escanteios;

    public Estatistica(Integer id, Integer rodada, String clube, Integer chutes, Integer chutesCertos, Integer posse, Integer passes, Integer precisaoPasses, Integer faltas, Integer amarelos, Integer vermelhos, Integer impedimentos, Integer escanteios) {
        this.id = id;
        this.rodada = rodada;
        this.clube = clube;
        this.chutes = chutes;
        this.chutesCertos = chutesCertos;
        this.posse = posse;
        this.passes = passes;
        this.precisaoPasses = precisaoPasses;
        this.faltas = faltas;
        this.amarelos = amarelos;
        this.vermelhos = vermelhos;
        this.impedimentos = impedimentos;
        this.escanteios = escanteios;
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

    public Integer getChutes() {
        return chutes;
    }

    public Integer getChutesCertos() {
        return chutesCertos;
    }

    public Integer getPosse() {
        return posse;
    }

    public Integer getPasses() {
        return passes;
    }

    public Integer getPrecisaoPasses() {
        return precisaoPasses;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public Integer getAmarelos() {
        return amarelos;
    }

    public Integer getVermelhos() {
        return vermelhos;
    }

    public Integer getImpedimentos() {
        return impedimentos;
    }

    public Integer getEscanteios() {
        return escanteios;
    }

    @Override
    public String toString() {
        return "model.Estatistica{" +
                "id=" + id +
                ", rodada=" + rodada +
                ", clube='" + clube + '\'' +
                ", chutes=" + chutes +
                ", chutesCertos=" + chutesCertos +
                ", posse=" + posse +
                ", passes=" + passes +
                ", precisaoPasses=" + precisaoPasses +
                ", faltas=" + faltas +
                ", cartaoAmarelo=" + amarelos +
                ", cartaoVermelho=" + vermelhos +
                ", impedimentos=" + impedimentos +
                ", escanteios=" + escanteios +
                '}';
    }
}
