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
public class meteorologia extends Activity {

    private ListView listView;
    private String[] menu = {"Stratus ","Stratocumulus","Nimbostratus","Cumulus","Altostratus","Altocumulus","Cirrus","Cirrocumulus","Cirrostratus","Cumulonimbus"};

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.meteorologia);
        objeto.CodigoPath="Cod_meteorologia";
        objeto.DescricaoPath="Desc_meteorologia";
        objeto.ImagePath="Img_meteorologia";
        objeto.TablePath="Meteorologia";

        listView = (ListView) findViewById(R.id.idMeteorologialistView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(meteorologia.this,android.R.layout.simple_expandable_list_item_1,menu);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                escolha(position);
            }
        });
    }
    private void escolha(int posicao){
        for(int i=0;i<10;i++){
            if (posicao==i){
                objeto.Codigo=i+1;
                Intent screen = new Intent(meteorologia.this,componenteClass.class);
                startActivity(screen);
            }
        }
    }
}
