package com.example.Manual_Parapente;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

/*
public class main extends Activity {
    /**
     * Called when the activity is first created.

    private Button regras;
    private Button voos;
    private Button meteorologia;
    private Button equipamentos;
    private Button girias;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        regras = (Button) findViewById(R.id.buttonRegras);
        voos = (Button) findViewById(R.id.buttonVoos);
        meteorologia = (Button)findViewById(R.id.buttonMeteorologia);
        equipamentos = (Button) findViewById(R.id.buttonEquipamentos);
        girias = (Button) findViewById(R.id.buttonGirias);
        regras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent screen = new Intent(main.this,regras.class);
                 startActivity(screen);
            }
        });
        voos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent screen = new Intent(main.this,voos.class);
                 startActivity(screen);
            }
        });
        meteorologia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent screen = new Intent(main.this,meteorologia.class);
                startActivity(screen);
            }
        });
        equipamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent screen = new Intent(main.this,equipamentos.class);
                startActivity(screen);
            }
        });
        girias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent screen = new Intent(main.this,girias.class);
                startActivity(screen);
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu){

        return true;
    }

}

*/
public class main extends Activity {
    /**
     * Called when the activity is first created.
     */
    private ListView ObjlistView;
    private adapter Objadapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Objadapter = new adapter(this);
        ObjlistView = (ListView) findViewById(R.id.listView_main);
        ObjlistView.setAdapter(Objadapter);

        ObjlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent screen;
                switch (position){
                    case 0:
                        screen = new Intent(main.this,equipamentos.class);
                        startActivity(screen);
                        break;
                    case 1:
                        screen = new Intent(main.this,girias.class);
                        startActivity(screen);
                        break;
                    case 2:
                        screen = new Intent(main.this,meteorologia.class);
                        startActivity(screen);
                        break;
                    case 3:
                        screen = new Intent(main.this,regras.class);
                        startActivity(screen);
                        break;
                    case 4:
                        screen = new Intent(main.this,voos.class);
                        startActivity(screen);
                        break;
                }
            }
        });
    }
}
