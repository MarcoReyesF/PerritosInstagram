package com.example.mascotasfavoritas2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.mascotasfavoritas2.adapter.PerritusAdaptador;
import com.example.mascotasfavoritas2.pojo.Perritu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Perritu> listaPerritus;
    private RecyclerView listaRecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.mi_action_bar);
        setSupportActionBar(miActionBar);
        miActionBar.setTitle("Petagram");

        listaRecycle = (RecyclerView) findViewById(R.id.resicleViewMainActivity);

       // LinearLayoutManager  llm = new LinearLayoutManager(this);
        GridLayoutManager glm = new GridLayoutManager(this,1);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //listaRecycle.setLayoutManager(llm);
        listaRecycle.setLayoutManager(glm);
        inicializarListaDePerritus();
        inicializarAdaptador();

       // ArrayList<String> nombresPerritus = new ArrayList<>();
        //for (Perritu perritus : listaPerritus){
        //    nombresPerritus.add(perritus.getNombre());
        //}

    }

    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflador = getMenuInflater();
        inflador.inflate(R.menu.ihw_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        Intent myintent;
        switch (id) {
            case R.id.mnSiguiente:
                myintent = new Intent(this, MascotasFavoritas.class);
                startActivity(myintent);
                return false;

            case R.id.AcercaDe:
                myintent = new Intent(this, AcercaDe.class);
                startActivity(myintent);
                return false;

            case R.id.Contacto:
                myintent = new Intent(this, Contacto.class);
                startActivity(myintent);
                return false;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void inicializarAdaptador(){
        PerritusAdaptador adaptador = new PerritusAdaptador(listaPerritus,this);
        listaRecycle.setAdapter(adaptador);
    }

    public void  inicializarListaDePerritus (){
        listaPerritus = new ArrayList<Perritu>();
        listaPerritus.add(new Perritu(R.drawable.rex,250,"Rex"));
        listaPerritus.add(new Perritu(R.drawable.kim,100,"Kim"));
        listaPerritus.add(new Perritu(R.drawable.guardian,20,"Guardian"));
        listaPerritus.add(new Perritu(R.drawable.lana,20,"Lana"));
        listaPerritus.add(new Perritu(R.drawable.chispito,15,"Chispito"));
        listaPerritus.add(new Perritu(R.drawable.lanudo,15,"Lanudo"));
        listaPerritus.add(new Perritu(R.drawable.owen,15,"Owen"));
        listaPerritus.add(new Perritu(R.drawable.hunter,15,"Hunter"));

    }

}
