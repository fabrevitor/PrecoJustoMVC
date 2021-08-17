package com.senac.precojustomvc.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.senac.precojustomvc.R;
import com.senac.precojustomvc.control.MainControl;

public class MainActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editValor;
    private EditText editQtdParcelas;
    private EditText editJuros;
    private LinearLayout layoutResultado;
    private Button btnCalcular;
    private Button btnLimparDados;

    private MainControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        control = new MainControl(this);
    }

    private void initialize(){
        editNome = findViewById(R.id.editNome);
        editValor = findViewById(R.id.editValor);
        editQtdParcelas = findViewById(R.id.editQtdParcelas);
        editJuros = findViewById(R.id.editJuros);
        layoutResultado = findViewById(R.id.layoutResultado);

        //onClick
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                control.calcularAction();
            }
        });

        //onClick
        btnLimparDados = findViewById(R.id.btnLimparDados);
        btnLimparDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.limparDadosAction();
            }
        });
    }

    public EditText getEditNome() {
        return editNome;
    }

    public EditText getEditValor() {
        return editValor;
    }

    public EditText getEditQtdParcelas() {
        return editQtdParcelas;
    }

    public EditText getEditJuros() {
        return editJuros;
    }

    public LinearLayout getLayoutResultado() {
        return layoutResultado;
    }

    public Button getBtnCalcular() {
        return btnCalcular;
    }

    public Button getBtnLimparDados() {
        return btnLimparDados;
    }
}
