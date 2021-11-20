package com.example.sharedprefsexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sharedprefsexample.Models.MyDB;
import com.example.sharedprefsexample.Models.Record;
import com.google.gson.Gson;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int a1 = MSPv1.getIntSP(this,"Score1",0);
        MSPv1.putIntSP(this,"Score1",150);
        a1 = MSPv1.getIntSP(this,"Score1",0);

        MSPv2 mspv2 = new MSPv2(this);
        int b = mspv2.getIntSP("Score1",0);

        int c = MSPv3.getInstance(this).getIntSP("Score1", 0);


        MyDB myDB = new MyDB();
        for (int i = 0; i < 10; i++) {
            myDB.getRecords().add(
                    new Record()
                            .setName("moshe")
                            .setTime(System.currentTimeMillis() / (1000*60*60*24))
                            .setScore(new Random().nextInt(100))
                            .setLat(new Random().nextDouble()*i)
                            .setLon(new Random().nextDouble()*i)
            );
        }
        String json = new Gson().toJson(myDB);
        MSPv3.getInstance(this).putStringSP("MY_DB", json);

        String fromJSON = MSPv3.getInstance(this).getStringSP("MY_DB","");
        MyDB newDb = new Gson().fromJson(fromJSON,MyDB.class);
    }
}