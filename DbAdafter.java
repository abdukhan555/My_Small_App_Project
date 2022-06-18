package Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.delawar.app_intents.R;
import com.delawar.app_intents.Sqlite_update_data;

import java.util.ArrayList;

import Database.DataBaseHelper;
import Modal.Records;

public class DbAdafter extends RecyclerView.Adapter<DbAdafter.viewholder> {

    ArrayList<Records> records;
    Context context;

    public DbAdafter(ArrayList<Records> records, Context context) {
        this.records = records;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_item,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Records r = records.get(position);

        holder.tvName.setText(r.getName());
        holder.tvCourse.setText(r.getCourse());
        holder.tvMobile.setText(r.getMobile());
        holder.tvtotal.setText(String.valueOf(r.getTotalfee()));
        holder.tvFeepaid.setText(String.valueOf(r.getFee_paid()));

        holder.btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "this is clicke"+ position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Sqlite_update_data.class);
                intent.putExtra("RECORD",r);
                context.startActivity(intent);
            }
        });
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder  = new AlertDialog.Builder(context);
                builder.setTitle("Confirmation!!!11");
                builder.setMessage("Are you sure to delete"+ r.getName()+ "?");
                builder.setIcon(android.R.drawable.ic_menu_delete);
                builder.setCancelable(false);
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);

                        int result = dataBaseHelper.deleteRecords(r.getId());
                        if(result > 0){
                            Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show();
                            records.remove(r);
                            notifyDataSetChanged();
                        }
                        else {
                            Toast.makeText(context, "fialed to delete", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("NO",null);
                builder.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return records.size();
    }


    class viewholder extends RecyclerView.ViewHolder{

        TextView tvName, tvCourse, tvMobile, tvtotal,tvFeepaid;
        Button btn_update, btn_delete;


        public viewholder(@NonNull View v) {
            super(v);

            tvName =   v.findViewById(R.id.view_name);
            tvCourse = v.findViewById(R.id.view_course_name);
            tvMobile = v.findViewById(R.id.view_mobile);
            tvtotal =  v.findViewById(R.id.view_totalfee);
            tvFeepaid = v.findViewById(R.id.view_feepaid);

            btn_update =v.findViewById(R.id.btn_update);
            btn_delete = v.findViewById(R.id.btn_delete);


        }
    }

}
