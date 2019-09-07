package com.example.Manual_Parapente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;

/**
 * Created by Lucas on 2/8/2015.
 */
public class regras extends Activity {
    // declaracao de variaveis.
    private ListView listView;
    private String[] menu = {"Regra 1","Regra 2","Regra 3","Regra 4","Regra 5","Regra 6","Regra 7","Regra 8"};

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle); // chamando construtor pai
        setContentView(R.layout.regras); // setando qual layout essa classe irar mostrar quando instanciada
        // aqui temos o preenchimento de uma classe com determinadas variaveis staticas .
        // atribuindo valores a estas variaveis.
        // variaveis que farao a selecao no banco de dados.
        objeto.CodigoPath="Cod_regra";
        objeto.DescricaoPath="Desc_regra";
        objeto.ImagePath="Img_regra";
        objeto.TablePath="Regras";

        // variavel listView recebe a identificação do objeto criado no layout.
        // Obs : repare no cast.
        listView = (ListView) findViewById(R.id.idRegrasview);

        // declarando um arryAdapter para o colocar nosso menu.
        // repare que o primeiro parametro é nosso classe, 2 parametro tipo , 3 parametro setar seu menu.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(regras.this,android.R.layout.simple_expandable_list_item_1,menu);
        // listView setar o arrayAdapter
        listView.setAdapter(adapter);
        // adicionano evento ao nosso listView.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // usuaremos o parametro position para saber qual item foi clicada.
                escolha(position);
            }
        });
    }
    // metodo escolha
    private void escolha(int posicao){
        for(int i=0;i<8;i++){
            // aqui mede o tamanho do menu
            if(posicao==i){
                objeto.Codigo=i+1; // soma-se +1 porque no banco de dados comeca sempre no 1 e não no zero
                // passa dessa class activity para nossa classe de renderizar tudo na tela.
                Intent screen = new Intent(regras.this,componenteClass.class);
                // inicia a tela.
                startActivity(screen);
            }
        }
    }
}
