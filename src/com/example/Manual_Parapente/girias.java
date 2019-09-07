package com.example.Manual_Parapente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Lucas on 2/10/2015.
 */
public class girias extends Activity {
    private ListView listView;
    private String[] menu = {
            "ABP","ASL","Ascendente","Afundar","Airbag","Arborizar","Atirar","Azular","Bacalhau","Base","Bicuda","Biruta","Bombando",
            "Canhão","Célula","Caudal","CB","Chupadora","Descendente",
            "Enroscar","Entubar","Espiral","Estampar","Estrada de nuvens","Falhada","Farofa","Fechada","Gatilho","Gravata","Lastro",
            "Lift","Margarida","Marlboro","Merreca","Morrote","Negativa","Nuvem do bem","Nuvem do mal","Orelhas","Paraca","Parachutagem",
            "Pelotão","Pilão","Poroso","Preá","Prego","Rampa","Resgate","Rotor","Térmica","Teto","Tufão",
            "Turbulência","Urubu","Varal","Ventaca","Zerinho"
    };

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.girias);
        objeto.CodigoPath="Cod_girias";
        objeto.DescricaoPath="Desc_girias";
        objeto.ImagePath="Img_girias";
        objeto.TablePath="Girias";

        listView = (ListView) findViewById(R.id.idGiriaslistView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(girias.this,android.R.layout.simple_expandable_list_item_1,menu);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                escolha(position);
            }
        });
    }
    private void escolha(int posicao){


        for(int i=0;i<57;i++){
            if(posicao==i){
                objeto.Codigo = i+1;
                Intent screen = new Intent(girias.this, componenteClass.class);
                startActivity(screen);
            }

        }
    }
}
