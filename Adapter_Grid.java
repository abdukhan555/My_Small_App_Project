package com.delawar.app_intents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter_Grid extends BaseAdapter {
    Context context;
    int images[] = {
            R.drawable.pic_1,R.drawable.pic_2,R.drawable.pic_3,R.drawable.pic_4,
            R.drawable.pic_5,R.drawable.pic_6,R.drawable.pic_7,R.drawable.pic_8
    };
    String names[] = {"first", "second", "third", "fourth", "fifth","six","sevevn","eight"};
    String description[] = {"pic one desxcription","pic one desxcription","pic one desxcription",
            "pic one desxcription","pic one desxcription","pic one desxcription","pic one desxcription","pic one desxcription"};

    public Adapter_Grid(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.singleview,null);
        ImageView imageView = (ImageView)view.findViewById(R.id.image_view);
        TextView textView = (TextView)view.findViewById(R.id.text_data);
        imageView.setImageResource(images[position]);
        textView.setText(names[position]);


        return view;
    }
}
