package com.senac.precojustomvc.model;

public class Produto {
    private String nome;
    private Double valor;
    private Integer qtdParcelas;
    private Double juros;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setValor(String valor) {
        try {
            this.valor = Double.parseDouble(valor);
        } catch(Exception e){
            this.valor = null;
        }
    }

    public Integer getQtdParcelas() {
        return qtdParcelas;
    }

    public void setqtdParcelas(Integer qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public void setQtdParcelas(String qtdParcelas) {
        try {
            this.qtdParcelas = Integer.parseInt(qtdParcelas);
        } catch(Exception e){
            this.qtdParcelas = null;
        }
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    public void setJuros(String juros) {
        try {
            this.juros = Double.parseDouble(juros);
        } catch(Exception e){
            this.juros = null;
        }
    }

    public Produto(String nome, Double valor, Integer qtdParcelas, Double juros) {
        this.nome = nome;
        this.valor = valor;
        this.qtdParcelas = qtdParcelas;
        this.juros = juros;
    }

    public Produto() {
    }

}
