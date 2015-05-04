package com.example.quiroz.materialloan;

import android.bluetooth.le.AdvertiseData;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.example.quiroz.materialloan.adaptadores.adaptadormaterial;
import com.example.quiroz.materialloan.modelos.ConexionSQL;
import com.example.quiroz.materialloan.modelos.modelomaterial;

import java.util.ArrayList;
import java.util.List;


public class listaregistros extends ActionBarActivity  {
    EditText editsearch;

    //



    //
    private RecyclerView recycler;
    //
    private RecyclerView.Adapter adapter;
    //
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaregistros);

        final List<modelomaterial> items = new ArrayList<>();

        ConexionSQL funcion = new ConexionSQL(this, "prestamos", null, 1);
        SQLiteDatabase BD = funcion.getWritableDatabase();

        Cursor fila = BD.rawQuery("select clave_prestamo, fecha, nombre_sol, area_sol, descripcion, recibido, entregado from prestamos", null);

        for (fila.moveToFirst(); !fila.isAfterLast(); fila.moveToNext()) {
            items.add(new modelomaterial(fila.getString(0),fila.getString(1),fila.getString(2),fila.getString(3),fila.getString(4),fila.getString(5),fila.getString(6)));
        }

        editsearch =(EditText) findViewById(R.id.editText1);


        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.lista);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new adaptadormaterial(items);
        recycler.setAdapter(adapter);

        editsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                populateListview(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });


    }

    public void populateListview(String s) {
        final List<modelomaterial> items = new ArrayList<>();
        ConexionSQL funcion = new ConexionSQL(this, "prestamos", null, 1);
        SQLiteDatabase BD = funcion.getWritableDatabase();
        try {
            Cursor fila = BD.rawQuery("select clave_prestamo, fecha, nombre_sol, area_sol, descripcion, recibido, entregado from prestamos where clave_prestamo= '" + s
                    +"' or nombre_sol like '%"+s+"%' or fecha like '%"+s+"%'"  , null);
            if (fila.moveToFirst()) {
                do {
                    items.add(new modelomaterial(fila.getString(0), fila.getString(1), fila.getString(2), fila.getString(3), fila.getString(4), fila.getString(5), fila.getString(6)));
                } while (fila.moveToNext());

            }

        } catch (Exception e) {

        }
        funcion.close();
        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.lista);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new adaptadormaterial(items);
        recycler.setAdapter(adapter);

    }


    public void buscar(View v){


    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listaregistros, menu);
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

