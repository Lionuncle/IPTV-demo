package com.example.iptv_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] names = {"SWAMI NARAYAN","GARV PUNJAB","GARV GURBANI","GARV INTERNATIONAL","COMMING SOON","COMMING SOON","COMMING SOON","COMMING SOON","COMMING SOON"};
    int[] images = {R.drawable.swami,R.drawable.punjab,R.drawable.gurbani,R.drawable.international,R.drawable.soon,R.drawable.soon,R.drawable.soon,R.drawable.soon,R.drawable.soon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.dataList);
        listView.setAdapter(new CustomLIstView(getApplicationContext(),this.names,images));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(names[position] == "COMMING SOON"){
                    Toast.makeText(MainActivity.this, "This channel will be available soon!", Toast.LENGTH_SHORT).show();
                }
                else{
                    try{
                        //String msg = "null";
                        Intent i = new Intent(getApplicationContext(),VideoActivity.class);

                        String channel = names[position];

                        if(channel == "SWAMI NARAYAN"){
                            String msg= "http://cdn.iptvgalaxy.com:25461/live/A/B/622.m3u8";
                            i.putExtra("key",msg);
                            startActivity(i);
                        }
                        if(channel == "GARV PUNJAB"){
                            String msg= "http://cdn.iptvgalaxy.com:25461/live/A/B/621.m3u8";
                            i.putExtra("key",msg);
                            startActivity(i);
                        }
                        if(channel == "GARV GURBANI"){
                            String msg = "http://cdn.iptvgalaxy.com:25461/live/A/B/620.m3u8";
                            i.putExtra("key",msg);
                            startActivity(i);
                        }
                        if(channel == "GARV INTERNATIONAL"){
                            String msg ="http://cdn.iptvgalaxy.com:25461/live/A/B/619.m3u8";
                            i.putExtra("key",msg);
                            startActivity(i);
                        }

                    }
                    catch (Exception e){
                        Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}
