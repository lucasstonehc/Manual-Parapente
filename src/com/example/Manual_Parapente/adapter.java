package com.example.Manual_Parapente;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Juninho on 5/13/2015.
 */
public class adapter extends BaseAdapter {
    private Context context;
    private ArrayList<row> listRow;
    private String[] titles = {"Equipamentos","Girias","Meteorologia","Regras","Voos"};
    private int images[] = {R.drawable.equipment,R.drawable.slang,R.drawable.meteorology,R.drawable.rules,R.drawable.flights};
    private LayoutInflater inflater;
    public adapter(Context context){
        this.context = context;
        listRow = new ArrayList<row>();
        for(int i=0;i<5;i++){
            row row = new row(titles[i],images[i]); //preenche o objeto row e adiciona ele na list de objetos row.
            listRow.add(row);
        }

    }
    @Override
    public int getCount() {
        return listRow.size();
    }

    @Override
    public Object getItem(int position) {
        return listRow.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.row,parent,false);
        TextView title = (TextView) row.findViewById(R.id.textView_row);
        ImageView image = (ImageView) row.findViewById(R.id.imageView_row);

        row Objrow = listRow.get(position);

        title.setText(Objrow.getTitle());
        image.setImageResource(Objrow.getImage());

        return row;
    }
}
