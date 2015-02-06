package com.chfmr.listview.listview;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    List<LinhaDeOnibus> linhasDeOnibus;
    LinhaDeOnibusAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list);

        linhasDeOnibus = new ArrayList<LinhaDeOnibus>();
        linhasDeOnibus.add(new LinhaDeOnibus("Penha", 107, "Penha", "Centro"));
        linhasDeOnibus.add(new LinhaDeOnibus("Vila", 108, "Vila", "Centro"));
        linhasDeOnibus.add(new LinhaDeOnibus("Lavapés", 109, "Lavapés", "Centro"));
        linhasDeOnibus.add(new LinhaDeOnibus("Matadouro", 110, "Matadouro", "Centro"));
        linhasDeOnibus.add(new LinhaDeOnibus("Jardim Recreio", 111, "Jardim Recreio", "Centro"));

        adapter = new LinhaDeOnibusAdapter(this, linhasDeOnibus);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                LinhaDeOnibus linhasDeOnibus = (LinhaDeOnibus)adapterView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, linhasDeOnibus.nome, Toast.LENGTH_SHORT).show();
            }
        });

        final int PADDING = 8;
        TextView txtHeader = new TextView(this);
        txtHeader.setBackgroundColor(Color.GRAY);
        txtHeader.setTextColor(Color.WHITE);
        txtHeader.setText(R.string.texto_cabecalho);
        txtHeader.setPadding(PADDING, PADDING, 0, PADDING);
        listView.addHeaderView(txtHeader);

        TextView txtFooter = new TextView(this);
        txtFooter.setText(getResources().getQuantityString(
                R.plurals.texto_rodape,
                adapter.getCount(),
                adapter.getCount()));
        txtFooter.setBackgroundColor(Color.LTGRAY);
        txtFooter.setGravity(Gravity.RIGHT);
        txtFooter.setPadding(0, PADDING, PADDING, PADDING);
        listView.addFooterView(txtFooter);

        // EmptyView só funciona com ListActivity...
        listView.setEmptyView(findViewById(android.R.id.empty));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
