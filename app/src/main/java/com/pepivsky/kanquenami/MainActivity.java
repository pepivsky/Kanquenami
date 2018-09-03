package com.pepivsky.kanquenami;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    //Hombre
    static final double n1 = 66.4730;
    static final double n2 = 13.7516;
    static final double n3 = 5.0033;
    static final double n4 = 6.7550;

    //Mujer
    static final double m1 = 655.0955;
    static final double m2 = 9.5634;
    static final double m3 = 1.8449;
    static final double m4 = 4.6756;

    //EditText edtEdad = (EditText)R.id.


    @BindView(R.id.radio_hombre)
    RadioButton radioHombre;
    @BindView(R.id.radioMujer)
    RadioButton radioMujer;
    @BindView(R.id.edtEdad)
    EditText edtEdad;
    @BindView(R.id.edtPeso)
    EditText edtPeso;
    @BindView(R.id.edtAltura)
    EditText edtAltura;
    @BindView(R.id.tvResultado)
    TextView tvResultado;
    @BindView(R.id.btncalorias)
    Button btncalorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);





    }

    private void calcularGastoenergeticoM() {
        double peso = Double.parseDouble(edtPeso.getText().toString());
        double altura = Double.parseDouble(edtAltura.getText().toString());
        double edad = Double.parseDouble(edtEdad.getText().toString());

        double resultado;

        resultado = m1 + m2 * peso + m3 * altura - m4 * edad;
        tvResultado.setText(resultado + "");

    }

    private void calcularGastoenergeticoH(View view) {
        //Obtener peso, altura, edad
        double peso = Double.parseDouble(edtPeso.getText().toString());
        double altura = Double.parseDouble(edtAltura.getText().toString());
        double edad = Double.parseDouble(edtEdad.getText().toString());

        double resultado;

        resultado = n1 + n2 * peso + n3 * altura - n4 * edad;
        tvResultado.setText(resultado + "");


    }


    @OnClick(R.id.btncalorias)
    public void onViewClicked() {
        if (radioHombre.isChecked()) {
            calcularGastoenergeticoH(radioHombre);
        } else {
            calcularGastoenergeticoM();
        }
    }
}
