package com.example.Manual_Parapente;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas on 2/8/2015.
 */
public class database extends SQLiteOpenHelper {

    private static String DB_PATH = "/data/data/com.example.Manual_Parapente/databases/";
    // Name of the database file
    private static String DB_NAME = "databaseparapente";

    // Internal variables
    private SQLiteDatabase dbHandle;
    private final Context dbContext;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public database(Context context) {
        super(context, DB_NAME, null, 1);
        this.dbContext = context;
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException {

        // Verifies if the database already exist
        boolean dbExist = checkDataBase();

        if (!dbExist) {

            // By calling this method and empty database will be created into the default system path
            // of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {
                this.copyDataBase();
            } catch (IOException e) {
                throw new Error("Erro ao copiar banco de dados");
            }
        }
    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            // database does't exist yet.
        }

        if (checkDB != null) {
            checkDB.close();
        }

        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException{

        // Openn local db as the input stream
        InputStream myInput = dbContext.getAssets().open(DB_NAME);

        // Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;

        // Opens the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // Transfers bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        // Closes the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {
        // Open the database
        String myPath = DB_PATH + DB_NAME;
        dbHandle = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    public String selectObjeto(String CodigoPath,String DescricaoPath, String ImagePath,String Tabela,int Codigo){
        Cursor c=dbHandle.rawQuery("SELECT "+DescricaoPath+" FROM "+Tabela+" WHERE "+CodigoPath+"="+Codigo, null);
        String result="";
        if(c.moveToFirst())
        {
           result=c.getString(0);
        }
        return result;
    }
    public String selectImage(String CodigoPath,String DescricaoPath, String ImagePath,String Tabela,int Codigo){
        Cursor c=dbHandle.rawQuery("SELECT "+ImagePath+" FROM "+Tabela+" WHERE "+CodigoPath+"="+Codigo, null);
        String result="";
        if(c.moveToFirst())
        {
            result=c.getString(0);
        }
        return result;
    }
    public List<String> selecionaTodos(String NomeTabela, String OrdemCampo, String...TipoCampos)
    {
        List<String> list = new ArrayList<String>();
        Cursor cursor = dbHandle.query(NomeTabela, TipoCampos,
                null, null, null, null, OrdemCampo);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0) +" - " + cursor.getString(1) + " - "+ cursor.getString(2));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }

    @Override
    public synchronized void close() {
        if (dbHandle != null)
            dbHandle.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase dbHandle) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase dbHandle, int oldVersion, int newVersion) {

    }

}
