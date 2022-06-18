package com.delawar.app_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class GridActivity extends AppCompatActivity {
    GridView grid ;
    ImageView back_button;
    /*int images[] = {
            R.drawable.pic_1,R.drawable.pic_2,R.drawable.pic_3,R.drawable.pic_4,
            R.drawable.pic_5,R.drawable.pic_6,R.drawable.pic_7,R.drawable.pic_8
    };
    String names[] = {"first", "second", "third", "fourth", "fifth","six","sevevn","eight"};*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        grid = findViewById(R.id.grid_view_data);
        back_button    = findViewById(R.id.btn_back);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back_btn = new Intent(GridActivity.this,MainActivity.class);
                startActivity(back_btn);
            }
        });


      /* gridAdapter object = new gridAdapter(names,images,this);
       grid.setAdapter(object);

       grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(GridActivity.this,"clicked on"+names[position],Toast.LENGTH_LONG).show();
               Intent intent = new Intent(getApplicationContext(),MainActivity3.class);
               intent.putExtra("id",position);
               startActivity(intent);
           }
       });*/

      Adapter_Grid object  = new Adapter_Grid(GridActivity.this);
      grid.setAdapter(object);
      grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Intent intent = new Intent(GridActivity.this,MainActivity3.class);
              intent.putExtra("id",position);
              startActivity(intent);

          }
      });



    }
}