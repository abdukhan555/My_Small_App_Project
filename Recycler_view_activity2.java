package com.delawar.app_intents;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

import Adapters.myAdapter_2;
import Modal.Modal;

public class Recycler_view_activity2 extends AppCompatActivity {
    RecyclerView rcv;
    myAdapter_2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_activity2);
        setTitle("Recycler and card view");
        rcv = (RecyclerView) findViewById(R.id.recycle_view2);
       // rcv.setLayoutManager(new LinearLayoutManager(this));

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        rcv.setLayoutManager(linearLayoutManager);
       /*LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcv.setLayoutManager(linearLayoutManager);*/
     GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2 ,GridLayoutManager.VERTICAL,false);
      gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
          @Override
          public int getSpanSize(int position) {
              return (position == 0 ? 2 : 1);
          }
      });
      rcv.setLayoutManager(gridLayoutManager);

       StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL);
       rcv.setLayoutManager(staggeredGridLayoutManager);

        adapter = new myAdapter_2(dataqueue(),getApplicationContext());
        rcv.setAdapter(adapter);

    }
    public ArrayList<Modal> dataqueue()
    {
        ArrayList<Modal> holder = new ArrayList<>();

        Modal ob1=new Modal();
        ob1.setHeader("C Programming");
        ob1.setDesc("Desktop Programming");
        ob1.setImgname(R.drawable.ic_baseline_ac_unit_24);
        holder.add(ob1);

        Modal ob2=new Modal();
        ob2.setHeader("C++ Programming");
        ob2.setDesc("Desktop Progamming Language");
        ob2.setImgname(R.drawable.ic_baseline_account_balance_24);
        holder.add(ob2);

        Modal ob3=new Modal();
        ob3.setHeader("Java Programming");
        ob3.setDesc("Desktop Progamming Language");
        ob3.setImgname(R.drawable.ic_baseline_ac_unit_24);
        holder.add(ob3);

        Modal ob4=new Modal();
        ob4.setHeader("PHP Programming");
        ob4.setDesc("Web Progamming Language");
        ob4.setImgname(R.drawable.pic_1);
        holder.add(ob4);

        Modal ob5=new Modal();
        ob5.setHeader(".NET Programming");
        ob5.setDesc("Desktop/Web Progamming Language");
        ob5.setImgname(R.drawable.ic_baseline_ac_unit_24);
        holder.add(ob5);

        Modal ob6=new Modal();
        ob6.setHeader("Wordpress Framework");
        ob6.setDesc("PHP based Blogging Framework");
        ob6.setImgname(R.drawable.ic_baseline_account_balance_24);
        holder.add(ob6);

        Modal ob7=new Modal();
        ob7.setHeader("Magento Framework");
        ob7.setDesc("PHP Based e-Comm Framework");
        ob7.setImgname(R.drawable.ic_baseline_ac_unit_24);
        holder.add(ob7);

        Modal ob8=new Modal();
        ob8.setHeader("Shopify Framework");
        ob8.setDesc("PHP based e-Comm Framework");
        ob8.setImgname(R.drawable.ic_baseline_account_balance_24);
        holder.add(ob8);

        Modal ob9=new Modal();
        ob9.setHeader("Angular Programming");
        ob9.setDesc("Web Programming");
        ob9.setImgname(R.drawable.ic_baseline_ac_unit_24);
        holder.add(ob9);

        Modal ob10=new Modal();
        ob10.setHeader("Python Programming");
        ob10.setDesc("Desktop/Web based Progamming");
        ob10.setImgname(R.drawable.ic_baseline_account_balance_24);
        holder.add(ob10);

        Modal ob11=new Modal();
        ob11.setHeader("Node JS Programming");
        ob11.setDesc("Web based Programming");
        ob11.setImgname(R.drawable.ic_baseline_ac_unit_24);
        holder.add(ob11);


        return holder;
    }
}