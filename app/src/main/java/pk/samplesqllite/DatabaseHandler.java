package pk.samplesqllite;

//import SQLiteOpenHelper;
//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by prashantkaushik on 12/01/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // Database Name
    private static final String DATABASE_NAME = "SimpleDB";
    private static final int DATABASE_VERSION = 3;
    // table name
    private static final String TABLE_NAME = "phonedetail";

    // Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    // Adding new ROW
    public void addphoneModel(phoneModel phmodel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, phmodel.getphonemodel());
        values.put(KEY_PH_NO, phmodel.getmemorysize());

        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }


//retriving the rows from database and printing it to console and a textview and can be printed to edittextviews
    // the return type will be a list of string
    public List<String> getphonelrecords()
    {
        // lets get the database instance
        SQLiteDatabase db = this.getReadableDatabase();

        // rows retrived from database
        List<String> column0 = new ArrayList<String>();
        List<String> column1 = new ArrayList<String>();
        List<String> column2 = new ArrayList<String>();

        // Lets write the query to retrive the rows from database
        String retrivequrey = "SELECT * FROM " + TABLE_NAME ;
        //Raw results holder
        Cursor cursor = db.rawQuery(retrivequrey, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                column0.add(cursor.getString(0));
                column1.add(cursor.getString(1));
                column2.add(cursor.getString(2));

            } while (cursor.moveToNext());
        }
        Log.d("Count of Rows in DB",Integer.toString(cursor.getCount()));
        // closing connection
        cursor.close();
        db.close();

        // returning rows
        return column2;


    }

    public void deleterecords()
    {
        // lets get the database instance
        SQLiteDatabase db = this.getReadableDatabase();

        // Lets write the query to delete the rows from database
        String deletequery = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_ID + " = '1'"   ;
        //query executor
        Cursor cursor = db.rawQuery(deletequery, null);
//checking again for the deleted rows
        Log.d("Count of columns",Integer.toString(cursor.getCount()));

    }


public void updaterecords()
{
    SQLiteDatabase db = this.getWritableDatabase();

    String updatequery = "UPDATE " + TABLE_NAME + " SET " + KEY_NAME + " = Iphone"; //column2 = value2...., columnN = valueN\n" +
           // "WHERE [condition];"
    ContentValues values = new ContentValues();
    values.put(KEY_NAME, "hh");
    values.put(KEY_PH_NO, "ppppppp");


   db.update(TABLE_NAME,values,null,null);

}








}
