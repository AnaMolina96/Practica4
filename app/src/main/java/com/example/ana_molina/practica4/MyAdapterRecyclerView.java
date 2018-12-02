package com.example.ana_molina.practica4;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class MyAdapterRecyclerView extends RecyclerView.Adapter<MyAdapterRecyclerView.MyViewHolder> implements View.OnClickListener {

        private List<Foto> mDataset;
        private View.OnClickListener listener;


        @NonNull
        @Override
        public MyAdapterRecyclerView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view, parent, false);

            MyAdapterRecyclerView.MyViewHolder tvh = new MyAdapterRecyclerView.MyViewHolder(itemView);
            itemView.setOnClickListener(this);
            return tvh;

        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.mTextViewNombreArchivo.setText(mDataset.get(position).getNombre_foto());
            holder.mTextViewNombreDescriptivo.setText(mDataset.get(position).getNombre_descriptivo());
            holder.mTextViewLugar.setText(mDataset.get(position).getLugar());
            holder.mTextViewFecha.setText(mDataset.get(position).getFecha().toString());
            holder.mTextViewDescripcion.setText(mDataset.get(position).getDescripcion());
            holder.mTextViewPersonasAnimalesEtc.setText(mDataset.get(position).getPersonas_animales_etc());
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }

        public MyAdapterRecyclerView(List<Foto> mDataset) {
            this.mDataset=mDataset;
        }

        @Override
        public void onClick(View view) {
            if(listener != null)
                listener.onClick(view);
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTextViewNombreArchivo;
            public TextView mTextViewNombreDescriptivo;
            public TextView mTextViewLugar;
            public TextView mTextViewFecha;
            public TextView mTextViewDescripcion;
            public TextView mTextViewPersonasAnimalesEtc;

            /*public MyViewHolder(TextView v_nombre_archivo, TextView v_nombre_descriptivo,TextView v_lugar, TextView v_fecha, TextView v_descripcion, TextView v_personas_animales_etc) {

                super(v_nombre_archivo);
                mTextViewNombreArchivo = v_nombre_archivo;
                mTextViewNombreDescriptivo = v_nombre_descriptivo;
                mTextViewLugar = v_lugar;
                mTextViewFecha = v_fecha;
                mTextViewDescripcion = v_descripcion;
                mTextViewPersonasAnimalesEtc = v_personas_animales_etc;
            }
            */

            public MyViewHolder(View v) {
                super(v);
                mTextViewNombreArchivo = v.findViewById(R.id.textViewNombreArchivoFisico);
                mTextViewNombreDescriptivo = v.findViewById(R.id.textViewNombreDescriptivo);
                mTextViewLugar = v.findViewById(R.id.textViewLugar);
                mTextViewFecha = v.findViewById(R.id.textViewFecha);
                mTextViewDescripcion = v.findViewById(R.id.textViewDescripcion);
                mTextViewPersonasAnimalesEtc = v.findViewById(R.id.textViewPersonasAnimalesEtc);

            }
        }

    }
