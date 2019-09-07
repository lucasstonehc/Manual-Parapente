package com.example.Manual_Parapente;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Lucas on 2/8/2015.
 */
public class componenteClass extends Activity {
    private ImageView imageView;
    private TextView textView;
    private database db;
    private String texto;
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.componentelayout);
        imageView = (ImageView)findViewById(R.id.imageView);
        textView = (TextView)findViewById(R.id.textView);
        db = new database(this);
        try {
            db.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // abrindo banco de dados
        db.openDataBase();
        // fazendo selecao e  colocando no texto .
        texto=db.selectObjeto(objeto.CodigoPath,objeto.DescricaoPath,objeto.ImagePath,objeto.TablePath,objeto.Codigo);

        AssetManager manager = getAssets();
        // Read a Bitmap from Assets
        try {
            InputStream open = manager.open(db.selectImage(objeto.CodigoPath,objeto.DescricaoPath,objeto.ImagePath,objeto.TablePath,objeto.Codigo));
            Bitmap bitmap = BitmapFactory.decodeStream(open);
            if(bitmap==null){
                imageView.setImageBitmap(null);
            }
            imageView.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        textView.setText(texto);
    }
}
