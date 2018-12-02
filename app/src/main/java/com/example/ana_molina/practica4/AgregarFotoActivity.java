package com.example.ana_molina.practica4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgregarFotoActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    public static int AGREGAR_FOTO_ACTIVITY = 1;

    private Foto datos_foto;

    private Intent intent;

    private EditText nombreArchivo, nombreDescriptivo,lugar,
            fecha,descripcion,personas_animales_cosas;

    private ImageView imagen;
    private String tipo_vista;
    private ImageButton camara;
    private Button agregar;
    private Date date;
    private Bitmap imageBitmap;
    private byte[] byteArray;
    private List<Foto> listaFotos = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_foto);

        //List<Foto> listaFotos;

        Bundle showViewActivity = getIntent().getExtras();
        listaFotos = (List<Foto>) showViewActivity.getSerializable("lista");
        tipo_vista = showViewActivity.getString("tipo_vista");
        //listaFotos = (List<Foto>) getIntent().getExtras().getSerializable("lista");
        camara = (ImageButton) findViewById(R.id.imageButtonTomarFoto);


        imagen = (ImageView) findViewById(R.id.imageViewImagen);
        nombreArchivo = (EditText) findViewById(R.id.editTextNombreArchivo);
        nombreDescriptivo = (EditText) findViewById(R.id.editTextNombreDescriptivo);
        lugar = (EditText) findViewById(R.id.editTextLugar);
        fecha = (EditText) findViewById(R.id.editTextFecha);
        descripcion = (EditText) findViewById(R.id.editTextDescripcion);
        personas_animales_cosas = (EditText) findViewById(R.id.editTextPersonasAnimalesCosas);


        agregar = (Button) findViewById(R.id.buttonAgregarFoto);


        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }

            }
        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nombreArchivo.getText().toString().equalsIgnoreCase("")|| nombreDescriptivo.getText().toString().equalsIgnoreCase("")||
                        lugar.getText().toString().equalsIgnoreCase("")|| fecha.getText().toString().equalsIgnoreCase("")|| descripcion.getText().toString().equalsIgnoreCase("")||
                        personas_animales_cosas.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(getApplicationContext(), "Por favor, llene todos los datos antes de guardar la informacion", Toast.LENGTH_SHORT).show();

                } else {
                    datos_foto = new Foto(nombreArchivo.getText().toString(),nombreDescriptivo.getText().toString(),
                            lugar.getText().toString(),date,descripcion.getText().toString(),personas_animales_cosas.getText().toString(),byteArray);
                    //listaFotos.add(datos_foto);
                    intent = new Intent(AgregarFotoActivity.this,ShowViewsActivity.class);
                    intent.putExtra("datos_foto",datos_foto);
                    intent.putExtra("tipo_vista",tipo_vista);
                    intent.putExtra("lista",(Serializable)listaFotos);
                    //setResult(RESULT_OK,intent);
                    startActivity(intent);
                    //finish();
                }


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            imagen.setImageBitmap(imageBitmap);
            ByteArrayOutputStream bStream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bStream);
            byteArray = bStream.toByteArray();
            date = new Date();
            fecha.setText(date.toString());
            nombreArchivo.setText(extras.get("data").toString());

        }
    }
}
