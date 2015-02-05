package com.chfmr.listview.listview;

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

        LinhasDeOnibus linhas = linhasDeOnibus.get(position);

        ViewHolder holder = null;
        if(convertView == null){
            Log.d("NGVL", "View Nova => position: " + position);
            convertView = LayoutInflater.from(contexto)
                    .inflate(R.layout.item_linha)
        }

    }

    static class ViewHolder {
        ImageView imgLogo;
        TextView txtNome;
        TextView txtNumero;
        TextView txtSentidoIda;
        TextView txtSentidoVolta;
    }
}
