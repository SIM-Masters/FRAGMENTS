package com.example.uidp2591.fragment;

import android.app.Activity;
import android.app.Fragment;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.uidp2591.fragment.R.id.fragment_container;

public class MainActivity extends AppCompatActivity {
    boolean status = false;
    Button bn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bn = (Button)findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();   /*Creamos el objeto del fragment manager */
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();  /*Creamos el fragment transaction */

                if(!status) /*Si es verdad */
                {
                    FragmentOne f1 = new FragmentOne();  /* Creamos el primer fragment */
                    fragmentTransaction.add(R.id.fragment_container, f1); /* Contenedor del fragment y el class object para agregarlo al layout*/
                    fragmentTransaction.addToBackStack(null); /* Si no agregamos esta línea al presionar el botón de atrás se cerrará la aplicación */
                    fragmentTransaction.commit(); /* Mostramos en sí el fragment */
                      bn.setText("LOAD SECOND FRAGMENT"); /* Cambiamos el texto del botón una vez que mostramos el primer fragment */
                      status = true; /* Cambiamos el valor de la variable status para poder mostrar el segundo fragment */
                }
                else
                {
                    FragmentTwo f2 = new FragmentTwo();
                    fragmentTransaction.add(R.id.fragment_container,f2);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    bn.setText("LOAD FIRST FRAGMENT");
                    status = false;


                }

            }
        });
    }
}
