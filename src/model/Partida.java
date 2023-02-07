package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Partida {
    private Integer id;
    private Integer rodada;
    private LocalDate data;
    private LocalTime hora;
    private String mandante;
    private String visitante;
    private String vencedor;
    private String arena;
    private Integer placarMandante;
    private Integer placarVisitante;
    private String estadoMandante;
    private String estadoVisitante;

    public Partida(Integer id, Integer rodada, String mandante, String visitante,
                   String vencedor, String arena, Integer placarMandante, Integer placarVisitante, String estadoMandante,
                   String estadoVisitante) {
        this.id = id;
        this.rodada = rodada;
        // this.data = data;
        // this.hora = hora;
        this.mandante = mandante;
        this.visitante = visitante;
        this.vencedor = vencedor;
        this.arena = arena;
        this.placarMandante = placarMandante;
        this.placarVisitante = placarVisitante;
        this.estadoMandante = estadoMandante;
        this.estadoVisitante = estadoVisitante;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRodada() {
        return rodada;
    }

    // public LocalDate getData() {
    //     return data;
    // }

    // public LocalTime getHora() {
    //     return hora;
    // }

    public String getMandante() {
        return mandante;
    }

    public String getVisitante() {
        return visitante;
    }

    public String getVencedor() {
        return vencedor;
    }

    public String getArena() {
        return arena;
    }

    public Integer getPlacarMandante() {
        return placarMandante;
    }

    public Integer getPlacarVisitante() {
        return placarVisitante;
    }

    public String getEstadoMandante() {
        return estadoMandante;
    }

    public String getEstadoVisitante() {
        return estadoVisitante;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", rodada=" + rodada +
                ", data=" + data +
                ", hora=" + hora +
                ", mandante='" + mandante + '\'' +
                ", visitante='" + visitante + '\'' +
                ", vencedor='" + vencedor + '\'' +
                ", arena='" + arena + '\'' +
                ", placarMandante=" + placarMandante +
                ", placarVisitante=" + placarVisitante +
                ", estadoMandante='" + estadoMandante + '\'' +
                ", estadoVisitante='" + estadoVisitante + '\'' +
                '}';
    }
}
