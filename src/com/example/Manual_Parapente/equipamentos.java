package com.example.Manual_Parapente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Lucas on 2/9/2015.
 */
public class equipamentos extends Activity {
    private ListView listView;
    private String[] menu ={"Botas de voo","Capacete","GPS","Óculos de Sol","Paraquedas reserva","Variômetro"
    };

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.equipamentos);
        objeto.CodigoPath="Cod_equipamentos";
        objeto.DescricaoPath="Desc_equipamentos";
        objeto.ImagePath="Img_equipamentos";
        objeto.TablePath="Equipamentos";

        listView = (ListView) findViewById(R.id.idEquipamentoslistView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(equipamentos.this,android.R.layout.simple_expandable_list_item_1,menu);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                escolha(position);
            }
        });
    }
    private void escolha(int posicao){


        for(int i=0;i<6;i++){
            if(posicao==i){
                objeto.Codigo = i+1;
                Intent screen = new Intent(equipamentos.this, componenteClass.class);
                startActivity(screen);
            }

        }
    }
}
