package com.example.ana_molina.practica4;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Date;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    public static final int SHOW_VIEWS_ACTIVITY = 1;

    RadioButton radioButtonCardView, radioButtonRecyclerView;

    CheckBox checkBoxNombreArchivoFisico, checkBoxNombreDescriptivoFoto,
                checkBoxLugar, checkBoxFecha, checkBoxDescripcion,
                checkBoxPersonasAnimalesCosas;
    int[ ] atributos = {0,0,0,0,0,0,0};
    String vista;
    Button buttonGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButtonCardView = (RadioButton) findViewById(R.id.radioButtonCardView);
        radioButtonRecyclerView = (RadioButton) findViewById(R.id.radioButtonRecyclerView);

        checkBoxNombreArchivoFisico = (CheckBox) findViewById(R.id.checkBoxNombreArchivoFisico);
        checkBoxNombreDescriptivoFoto = (CheckBox) findViewById(R.id.checkBoxNombreDescriptivo);
        checkBoxLugar = (CheckBox) findViewById (R.id.checkBoxLugar);
        checkBoxFecha = (CheckBox) findViewById (R.id.checkBoxFecha);
        checkBoxDescripcion = (CheckBox) findViewById (R.id.checkBoxDescripcion);
        checkBoxPersonasAnimalesCosas = (CheckBox) findViewById (R.id.checkBoxPersonasAnimalesCosas);
        buttonGuardar = (Button) findViewById(R.id.buttonGuardar);

        radioButtonCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBoxNombreArchivoFisico.setChecked(false);
                checkBoxNombreArchivoFisico.setEnabled(false);
                checkBoxNombreDescriptivoFoto.setEnabled(true);
                checkBoxLugar.setChecked(false);
                checkBoxLugar.setEnabled(false);
                checkBoxFecha.setEnabled(true);
                checkBoxDescripcion.setEnabled(true);
                checkBoxPersonasAnimalesCosas.setChecked(false);
                checkBoxPersonasAnimalesCosas.setEnabled(false);
            }
        });

        radioButtonRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBoxNombreArchivoFisico.setEnabled(true);
                checkBoxNombreDescriptivoFoto.setEnabled(true);
                checkBoxLugar.setEnabled(true);
                checkBoxFecha.setEnabled(true);
                checkBoxDescripcion.setEnabled(true);
                checkBoxPersonasAnimalesCosas.setEnabled(true);
            }
        });

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShowViewsActivity.class);

                if(!radioButtonCardView.isChecked() && !radioButtonRecyclerView.isChecked()){
                    Toast.makeText(getApplicationContext(),"Selecciona un tipo de vista",Toast.LENGTH_LONG).show();
                }else {

                    if(radioButtonCardView.isChecked()){
                    vista = "card_view";
                    }

                    if(radioButtonRecyclerView.isChecked()){
                    vista ="recycler_view";
                    }

                    if(checkBoxNombreArchivoFisico.isChecked()){
                        atributos[0]=1;
                    }if(checkBoxNombreDescriptivoFoto.isChecked()){
                        atributos[1]=1;
                    }if(checkBoxLugar.isChecked()){
                        atributos[2]=1;
                    }if(checkBoxFecha.isChecked()){
                        atributos[3]=1;
                    }if(checkBoxDescripcion.isChecked()){
                        atributos[4]=1;
                    }if(checkBoxPersonasAnimalesCosas.isChecked()){
                        atributos[5]=1;
                    }
                    intent.putExtra("atributos",atributos);
                    intent.putExtra("tipo_vista",vista);
                    startActivity(intent);
                }
            }
        });

    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_photo:
                Intent intent = new Intent(getApplicationContext(), AgregarFotoActivity.class);
                startActivity(intent);
                return true;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */
}
