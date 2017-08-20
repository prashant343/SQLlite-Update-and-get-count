package pk.samplesqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        
      //  db.addphoneModel(new phoneModel("1","Iphone", "100000000"));

//        List<String> rows = new ArrayList<String>();

       // rows = db.getphonelrecords();
     //   Log.d("last row last value",rows.toArray()[3].toString());
        //rows.get(0) also works good




        //Now we will delete all rows and then try to retrive the rows again to see that if the rows are deleted or not
      //  db.deleterecords();

        //checking again for the deleted rows
       // List<String> rows1 = new ArrayList<String>();
        //rows1 = db.getphonelrecords();
        //Log.d("last row last value",rows1.toArray()[3].toString());

// update record logic and code
        db.updaterecords();

//retrive of the data to show that data is updated.

        List<String> rows = new ArrayList<String>();

         rows = db.getphonelrecords();
         Log.d("last row last value",rows.toArray()[3].toString());




    }









}
