package Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.IntegerRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.delawar.app_intents.R;
import com.delawar.app_intents.full_screen_Activity;

import java.util.ArrayList;

import Modal.Modal;

public class myAdapter_2 extends RecyclerView.Adapter<myviewholder> {
    ArrayList<Modal> data;
    Context context;


    public myAdapter_2(ArrayList<Modal> data , Context context) {
        this.data = data;
        this.context = context;

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_row2,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

         final Modal temp_data = data.get(position);

        holder.t1.setText(data.get(position).getHeader());
        holder.t2.setText(data.get(position).getDesc());
        holder.img.setImageResource(data.get(position).getImgname());

        holder.t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"you have cliked on" + position + "header text",Toast.LENGTH_LONG).show();
            }
        });

        holder.t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,full_screen_Activity.class);
                intent.putExtra("header_text",temp_data.getHeader());
                intent.putExtra("dtext",temp_data.getDesc());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);
            }
        });






       /* holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"you clicked on " + position + " image",Toast.LENGTH_SHORT).show();
            }
        });
        holder.t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, full_screen_Activity.class);
             ..   intent.putExtra("header_text",temp_data.getHeader());

                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);


            }
        });*/

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
