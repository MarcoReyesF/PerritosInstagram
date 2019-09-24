package com.example.mascotasfavoritas2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mascotasfavoritas2.R;
import com.example.mascotasfavoritas2.adapter.PerritusAdaptador;
import com.example.mascotasfavoritas2.pojo.Perritu;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecycleView extends Fragment {

    private ArrayList<Perritu> listaPerritusFavoritos;
    private  RecyclerView rvPerritus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragment_recycle_view, container, false);

        View v = inflater.inflate(R.layout.fragment_fragment_recycle_view,container,false);

        rvPerritus = (RecyclerView) v.findViewById(R.id.resicleViewMascotasFavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPerritus.setLayoutManager(llm);
        inicializarListaDePerritus ();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        PerritusAdaptador adaptador = new PerritusAdaptador(listaPerritusFavoritos, getActivity());
        rvPerritus.setAdapter(adaptador);
    }

    public void  inicializarListaDePerritus (){
        listaPerritusFavoritos = new ArrayList<>();
        listaPerritusFavoritos.add(new Perritu(R.drawable.rex,250,"Rex"));
        listaPerritusFavoritos.add(new Perritu(R.drawable.kim,100,"Kim"));
        listaPerritusFavoritos.add(new Perritu(R.drawable.guardian,20,"Guardian"));
        listaPerritusFavoritos.add(new Perritu(R.drawable.lana,20,"Lana"));
    }

}
