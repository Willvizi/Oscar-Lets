package br.com.willian.java;

public class Celebridades {
    private String Nome;
    private Integer AnoFilme;
    private Integer Idade;
    private String Filme;

    public Celebridades(String nome, Integer anoFilme, Integer idade, String filme) {
        this.Nome = nome;
        this.AnoFilme = anoFilme;
        this.Idade = idade;
        this.Filme = filme;
    }

    public static Celebridades of(String line) {
        String[] split = line.split("; ");
        return new Celebridades(
                split[3],
                Integer.parseInt(split[1]),
                Integer.parseInt(split[2]),
                split[4]
        );
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Integer getAnoFilme() {
        return AnoFilme;
    }

    public void setAnoFilme(Integer anoFilme) {
        AnoFilme = anoFilme;
    }

    public Integer getIdade() {
        return Idade;
    }

    public void setIdade(Integer idade) {
        Idade = idade;
    }

    public String getFilme() {
        return Filme;
    }

    public void setFilme(String filme) {
        Filme = filme;
    }

    @Override
    public String toString() {
        return "Celebridades{" +
                "Nome='" + Nome + '\'' +
                ", AnoFilme=" + AnoFilme +
                ", Idade=" + Idade +
                ", Filme='" + Filme + '\'' +
                '}';
    }
}
