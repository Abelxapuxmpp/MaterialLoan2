package com.example.quiroz.materialloan;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.widget.ExpandableListView;
import com.example.quiroz.materialloan.R;

public class Acercade extends Activity {

    SparseArray<GrupoDeItems> grupos = new SparseArray<GrupoDeItems>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acercade);
        crearDatos();
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.listViewexp);
        adaptador adapter = new adaptador(this, grupos);
        listView.setAdapter(adapter);
    }

    public void crearDatos() {

        GrupoDeItems grupo0 = new GrupoDeItems("Alberto");
        grupo0.children.add("Desarrollador");
        grupo0.children.add("Nombre: Alberto Quiroz Albarran");
        grupo0.children.add("Telefono: 7671016465");
        grupo0.children.add("Facebook: AlbertoQA");
        grupos.append(0, grupo0);

        GrupoDeItems grupo1 = new GrupoDeItems("Abel");
        grupo1.children.add("Desarrollador");
        grupo1.children.add("Nombre: Abel Pioquinto Ubias");
        grupo1.children.add("Telefono: 7671073774");
        grupo1.children.add("Facebook: abelpioquinto.maybelking");
        grupos.append(1, grupo1);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_acercade, menu);
        return true;
    }

}
