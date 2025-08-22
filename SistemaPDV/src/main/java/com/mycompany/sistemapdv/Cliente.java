package com.mycompany.sistemapdv;

public class Cliente {
    //atributos
    private int cod;
    private String nome;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente(int cod, String nome) {
        this.cod = cod;
        this.nome = nome;
    }
    
}
