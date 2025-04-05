package models;

public class Cliente {

    private String nome;
    private int tempoAtendimento; // em segundos

    public Cliente(String nome, int tempoAtendimento) {
        this.nome = nome;
        this.tempoAtendimento = tempoAtendimento;
    }

    public String getNome() {
        return nome;
    }

    public int getTempoAtendimento() {
        return tempoAtendimento;
    }
}
