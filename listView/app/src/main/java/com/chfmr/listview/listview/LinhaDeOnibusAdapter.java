package com.chfmr.listview.listview;

import android.graphics.drawable.Drawable;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.LayoutInflater;

import java.util.List;

/**
 * Created by julianolustosa on 04/02/15.
 */
public class LinhaDeOnibusAdapter extends BaseAdapter {

    Context contexto;
    List<LinhaDeOnibus> linhasDeOnibus;

    public LinhaDeOnibusAdapter(Context contexto, List<LinhaDeOnibus> linhasDeOnibus){
        this.contexto = contexto;
        this.linhasDeOnibus = linhasDeOnibus;
    }

    @Override
    public int getCount(){
        return linhasDeOnibus.size();
    }

    @Override
    public Object getItem(int position){
        return linhasDeOnibus.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LinhaDeOnibus linha = linhasDeOnibus.get(position);

        ViewHolder holder = null;
        if(convertView == null){
            Log.d("NGVL", "View Nova => position: " + position);
            convertView = LayoutInflater.from(contexto)
                    .inflate(R.layout.item_linha, null);

        holder = new ViewHolder();
        holder.imgLogo = (ImageView) convertView.findViewById(R.id.imgLogo);
        holder.txtNome = (TextView) convertView.findViewById(R.id.txtNome);
        holder.txtNumero = (TextView) convertView.findViewById(R.id.txtNumero);
        holder.txtSentidoIda = (TextView) convertView.findViewById(R.id.txtSentidoIda);
        holder.txtSentidoVolta = (TextView) convertView.findViewById(R.id.txtSentidoVolta);
        convertView.setTag(holder);
        } else {
            Log.d("NGVL", "View existente => position: "+ position);
            holder = (ViewHolder)convertView.getTag();
        }

        // 3
        Resources res = contexto.getResources();
        Drawable draw = res.getDrawable(R.drawable.ic_launcher);

        holder.imgLogo.setImageDrawable(draw);
        holder.txtNome.setText(linha.nome);
        holder.txtNumero.setText(linha.nome);
        holder.txtSentidoIda.setText(linha.sentido_id);
        holder.txtSentidoVolta.setText(linha.sentido_volda);

        //4
        return convertView;
    }

    static class ViewHolder {
        ImageView imgLogo;
        TextView txtNome;
        TextView txtNumero;
        TextView txtSentidoIda;
        TextView txtSentidoVolta;
    }
}
