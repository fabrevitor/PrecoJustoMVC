package com.senac.precojustomvc.control;

import android.widget.TextView;
import android.widget.Toast;

import com.senac.precojustomvc.R;
import com.senac.precojustomvc.model.Produto;
import com.senac.precojustomvc.model.ProdutoBO;
import com.senac.precojustomvc.view.MainActivity;

public class MainControl {
    private MainActivity activity;

    public MainControl(MainActivity activity){
        this.activity = activity;
    }

    public void calcularAction(){
        Produto produto = new Produto();
        produto.setNome(activity.getEditNome().getText().toString());
        produto.setValor(activity.getEditValor().getText().toString());
        produto.setQtdParcelas(activity.getEditQtdParcelas().getText().toString());
        produto.setJuros(activity.getEditJuros().getText().toString());

        if(validarDadosForm(produto)){

            Double valorJuros = ProdutoBO.calcularJuros(produto.getValor(), produto.getJuros());
            Double valorTotal = ProdutoBO.calcularValorTotal(produto.getValor(), valorJuros);
            Double valorParcelas = ProdutoBO.calcularValorParcelas(valorTotal, produto.getQtdParcelas());

            String txtResultadoFinal = "";

            txtResultadoFinal += activity.getString(R.string.nome_produto) + ": " + produto.getNome() + "\n";
            txtResultadoFinal += activity.getString(R.string.valorInicial) + ": " + produto.getValor() + "\n";
            txtResultadoFinal += activity.getString(R.string.valorParcelas) + ": " + valorParcelas + "\n";
            txtResultadoFinal += activity.getString(R.string.valorTotal) + ": " + valorTotal + "\n";
            txtResultadoFinal += activity.getString(R.string.valorJuros) + ": " + valorJuros + "\n";

            TextView tvResDinamico = new TextView(activity);
            tvResDinamico.setText(txtResultadoFinal);
            activity.getLayoutResultado().removeAllViews(); // para retirar as outras views ja adicionadas
            activity.getLayoutResultado().addView((tvResDinamico));

            //Limpa o formulario digitado
            limparForm();
        } else{
            Toast.makeText(activity, "Form incompleto", Toast.LENGTH_SHORT).show();
        }
    }



    private boolean validarDadosForm(Produto a){
        if(!ProdutoBO.validarNome(a.getNome())){
            activity.getEditNome().setError(activity.getString(R.string.erro_nome));
            activity.getEditNome().requestFocus();
            return false;
        }

        if(!ProdutoBO.validarValor(a.getValor())){
            activity.getEditValor().setError(activity.getString(R.string.erro_valor));
            activity.getEditValor().requestFocus();
            return false;
        }
        if(!ProdutoBO.validarQtdParcelas(a.getQtdParcelas())){
            activity.getEditQtdParcelas().setError(activity.getString(R.string.erro_qtdParcelas));
            activity.getEditQtdParcelas().requestFocus();
            return false;
        }
        if(!ProdutoBO.validarJuros(a.getJuros())){
            activity.getEditJuros().setError(activity.getString(R.string.erro_juros));
            activity.getEditJuros().requestFocus();
            return false;
        }
        return true;
    }

    public void limparDadosAction(){
        limparForm();
        activity.getLayoutResultado().removeAllViews();
    }

    private void limparForm(){
        activity.getEditNome().setText("");
        activity.getEditValor().setText("");
        activity.getEditQtdParcelas().setText("");
        activity.getEditJuros().setText("");
        activity.getEditNome().requestFocus();
    }
}
