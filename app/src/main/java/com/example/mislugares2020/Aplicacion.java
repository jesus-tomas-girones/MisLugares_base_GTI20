package com.example.mislugares2020;

import android.app.Application;

import com.example.mislugares2020.datos.LugaresLista;
import com.example.mislugares2020.datos.RepositorioLugares;
import com.example.mislugares2020.modelo.GeoPunto;
import com.example.mislugares2020.presentacion.AdaptadorLugares;

public class Aplicacion extends Application {

   public RepositorioLugares lugares = new LugaresLista();
   public AdaptadorLugares adaptador = new AdaptadorLugares(lugares);

   @Override public void onCreate() {
      super.onCreate();
   }
}
