package com.example.Manual_Parapente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Lucas on 2/8/2015.
 */
public class voos extends Activity {

    private ListView listView;
    private String[] menu = {"Voo lift","Voo cross","Voo acrobático","Voo prego"};

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.voos);
        objeto.CodigoPath="Cod_voo";
        objeto.DescricaoPath="Desc_voo";
        objeto.ImagePath="Img_voo";
        objeto.TablePath="Voos";

        listView = (ListView) findViewById(R.id.idVooslistView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(voos.this,android.R.layout.simple_expandable_list_item_1,menu);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                escolha(position);
            }
        });
    }
    private void escolha(int posicao){
        for(int i=0;i<4;i++){
            if(posicao==i){
                objeto.Codigo=i+1;
                Intent screen = new Intent(voos.this,componenteClass.class);
                startActivity(screen);
            }
        }
    }

}
