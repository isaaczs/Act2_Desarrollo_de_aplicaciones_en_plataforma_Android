package com.zermeno.isaac.act2_desarrollodeaplicacionesenplataformaandroid;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.DialogFragment;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;


public class PantallaPrincipal extends AppCompatActivity {

    private int año;
    private int mes;
    private int dia;
    private EditText inputFecha;
    private Button bFecha;




    private static final int ID_DIALOGO = 0;
    private static DatePickerDialog.OnDateSetListener recibeFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //se obtiene una instancia de los controles GUI dentro del Layout
        inputFecha = (EditText) findViewById(R.id.inputFecha);
        bFecha = (Button) findViewById(R.id.bFecha);

        Calendar calendario = Calendar.getInstance();
        año = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH)+1;
        dia = calendario.get(Calendar.DAY_OF_MONTH);

        mostrarFecha();

        recibeFecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                año = year;
                mes = month;
                dia = dayOfMonth;

                mostrarFecha();
            }
        };
    }

    @Override
    protected Dialog onCreateDialog(int id){
        switch (id){
            case 0:
                return new DatePickerDialog(this, recibeFecha, año, mes+1, dia);
        }
        return null;
    }

    public void mostrarCalendario (View control){
        showDialog(ID_DIALOGO);
    }

    public void mostrarFecha(){
        inputFecha.setText(dia+"/"+mes+"/"+año);
    }
}
