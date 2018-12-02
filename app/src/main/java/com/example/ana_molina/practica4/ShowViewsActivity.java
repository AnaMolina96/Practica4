package com.example.ana_molina.practica4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ShowViewsActivity extends AppCompatActivity {


    public final int AGREGAR_FOTO_ACTIVITY = 1;
    List<Foto> listaFotos = new ArrayList<>();
    List<Foto> getlistaFotos = new ArrayList<>();
    int[ ] atributos = {0,0,0,0,0,0,0};
    private String tipo_vista;
    private Foto foto;
    private RecyclerView recyclerView;
    private MyAdapterRecyclerView myAdapterRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    boolean bandera= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_views_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        Bundle informacion = this.getIntent().getExtras();
        atributos = informacion.getIntArray("atributos");
        tipo_vista = informacion.getString("tipo_vista");
        foto = (Foto) informacion.getSerializable("datos_foto");
        listaFotos = new ArrayList<>();

        if(getlistaFotos!=null){
            listaFotos = (List<Foto>) getIntent().getExtras().getSerializable("getLista");
        }

/*
            recyclerView = findViewById(R.id.recycler);
            recyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(mLayoutManager);
            DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
            recyclerView.addItemDecoration(mDividerItemDecoration);
            myAdapterRecyclerView = new MyAdapterRecyclerView(listaFotos);
            recyclerView.setAdapter(myAdapterRecyclerView);



        if (foto != null) {
            listaFotos = (List<Foto>) getIntent().getExtras().getSerializable("lista");
            foto = (Foto) informacion.getSerializable("datos_foto");
//            Toast.makeText(getApplicationContext(),""+ listaFotos.get(0).getNombre_foto()+"",Toast.LENGTH_LONG).show();
            Log.i("ENTROFOTONULL","" +foto.getNombre_foto());
            listaFotos.add(foto);
        }
        Log.i("ENTROOOOSEGUNDA","jahsdkhskjadhjkas");




        listaFotos.add(new Foto("Anita", "Es una hermosa","Mexicali, BC",date,"Una hermosa humana",
                "ajkshdksa",getResources().getDrawable(R.drawable.ic_launcher_background)));
        listaFotos.add(new Foto("Anita", "Es una hermosa","Mexicali, BC",date,"Una hermosa humana",
                "ajkshdksa",getResources().getDrawable(R.drawable.ic_launcher_background)));
        listaFotos.add(new Foto("Anita1", "Es una hermosa","Mexicali, BC",date,"Una hermosa humana",
                "ajkshdksa",getResources().getDrawable(R.drawable.ic_launcher_background)));

            if(tipo_vista.equals("card_view")){
                Toast.makeText(getApplicationContext(),"Seria Card View",Toast.LENGTH_LONG).show();

            }
            if(tipo_vista.equals("recycler_view")){

                recyclerView.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(mLayoutManager);
                //DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
                recyclerView.addItemDecoration(mDividerItemDecoration);
                // specify an adapter (see also next example)
                myAdapterRecyclerView = new MyAdapterRecyclerView(listaFotos);
                recyclerView.setAdapter(myAdapterRecyclerView);

            }*/
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout, menu);
        return true;
    }

   @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       Toast.makeText(ShowViewsActivity.this,"ENTRO AL RESULT",Toast.LENGTH_LONG).show();
        switch (requestCode){
            case AGREGAR_FOTO_ACTIVITY:
            if(resultCode == RESULT_OK){
                listaFotos = new ArrayList<Foto>();
                Bundle showViewActivity = data.getExtras();
                tipo_vista = showViewActivity.getString("tipo_vista");
                foto = (Foto) showViewActivity.getSerializable("datos_foto");
                listaFotos.add(new Foto(foto.getNombre_foto(),foto.getNombre_descriptivo(),foto.getLugar(),foto.getFecha(),foto.getDescripcion(),foto.getPersonas_animales_etc(),foto.getFoto()));
                recyclerView = findViewById(R.id.recycler);
                recyclerView.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(mLayoutManager);
                DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
                recyclerView.addItemDecoration(mDividerItemDecoration);
                myAdapterRecyclerView = new MyAdapterRecyclerView(listaFotos);
                recyclerView.setAdapter(myAdapterRecyclerView);

            }
            break;
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_photo:
                Intent intent = new Intent(ShowViewsActivity.this, AgregarFotoActivity.class);
                intent.putExtra("getLista",(Serializable) getlistaFotos);
                startActivityForResult(intent,1);
                return true;
            case android.R.id.home:
                onBackPressed();
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
