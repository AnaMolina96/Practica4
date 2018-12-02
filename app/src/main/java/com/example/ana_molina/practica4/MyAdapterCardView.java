package com.example.ana_molina.practica4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class MyAdapterCardView extends RecyclerView.Adapter<MyAdapterCardView.MyViewHolder> implements View.OnClickListener{

    private LinkedList<Foto> mDataset;
    private View.OnClickListener listener;


    @NonNull
    @Override
    public MyAdapterCardView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        MyAdapterCardView.MyViewHolder tvh = new MyAdapterCardView.MyViewHolder(itemView);
        itemView.setOnClickListener(this);
        return tvh;

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterCardView.MyViewHolder holder, int position) {
        holder.mImage.setImageResource(R.drawable.ic_launcher_background);
        holder.mTextViewNombreDescriptivo.setText(mDataset.get(position).getNombre_descriptivo());
        holder.mTextViewFecha.setText(mDataset.get(position).getFecha().toString());
        holder.mTextViewDescripcion.setText(mDataset.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public MyAdapterCardView(LinkedList<Foto> mDataset) {
        this.mDataset=mDataset;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView mImage;
        public TextView mTextViewNombreDescriptivo;
        public TextView mTextViewFecha;
        public TextView mTextViewDescripcion;

        public MyViewHolder(ImageView v_image, TextView v_nombre_descriptivo, TextView v_fecha, TextView v_descripcion) {

            super(v_nombre_descriptivo);
            mTextViewNombreDescriptivo = v_nombre_descriptivo;
            mTextViewFecha = v_fecha;
            mTextViewDescripcion = v_descripcion;
            mImage = v_image;
        }

        public MyViewHolder(View v) {
            super(v);
            mTextViewNombreDescriptivo = v.findViewById(R.id.textViewNombreDescriptivo);
            mTextViewFecha = v.findViewById(R.id.textViewFecha);
            mTextViewDescripcion = v.findViewById(R.id.textViewDescripcion);
            mImage = v.findViewById(R.id.imageViewFoto);

        }
    }

}
