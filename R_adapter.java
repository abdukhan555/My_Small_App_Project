package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.delawar.app_intents.R;

import java.util.ArrayList;

import Modal.Modal_recycle;

public class R_adapter extends RecyclerView.Adapter<R_adapter.viewHolder>{
    ArrayList<Modal_recycle> list;
    Context context;

    public R_adapter(ArrayList<Modal_recycle> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.simple_recycler_view,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Modal_recycle modal_recycle = list.get(position);
        holder.imageView.setImageResource(modal_recycle.getPic());
        holder.textView.setText(modal_recycle.getText());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class viewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.r_img_view);
            textView = itemView.findViewById(R.id.r_txt_view);
        }
    }
}
