package com.senac.precojustomvc.model;


public class ProdutoBO {
    public static boolean validarNome(String nome){
        return nome!=null && !nome.equals("");
    }

    public static boolean validarValor(Double valor){
        return valor!=null && valor>=0.00;
    }

    public static boolean validarQtdParcelas(Integer qtdParcelas){
        return qtdParcelas!=null && qtdParcelas>=0;
    }
    public static boolean validarJuros(Double juros){
        return juros!=null && juros>=0;
    }

    public static Double calcularJuros(Double valorInicial, Double juros){
        return (valorInicial * (juros/100));
    }

    public static Double calcularValorParcelas(Double valorTotal, Integer qtdParcelas){
        return valorTotal / qtdParcelas;
    }

    public static Double calcularValorTotal(Double valorInicial, Double valorJuros){
        return valorInicial + valorJuros;
    }

}
