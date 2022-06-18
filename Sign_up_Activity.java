package com.delawar.app_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Sign_up_Activity extends AppCompatActivity {
    Spinner sp;
    boolean invalid = false;
    String Colector="";
    TextView txtalertName;
    EditText UserName,UserPassword,UserContact,UserComment;
    Button SubmitSave;
    RadioButton Malebtn,Femalbtn;
    CheckBox html,css,php;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_);
        sp=findViewById(R.id.spCountry);
        UserName=findViewById(R.id.userName);
        UserPassword=findViewById(R.id.userPassword);
        UserContact=findViewById(R.id.userContact);
        UserComment=findViewById(R.id.usercomment);
        txtalertName=findViewById(R.id.userAlert);
        Malebtn =findViewById(R.id.male);
        Femalbtn=findViewById(R.id.female);
        html=findViewById(R.id.html);
        css=findViewById(R.id.css);
        php=findViewById(R.id.php);
        SubmitSave=findViewById(R.id.btnSubmit);

        SubmitSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = UserName.getText().toString();
                String Pascode=UserPassword.getText().toString();
                String contact=UserContact.getText().toString();
                String comment=UserComment.getText().toString();
                if (name.isEmpty()){
                    Toast.makeText(Sign_up_Activity.this,"Pleas fill the password field",Toast.LENGTH_SHORT).show();
                }
                else if (name.equals("Sameh") ||name.equals("UlHaq")){
                    invalid=true;
                    txtalertName.setText("Name Already exist");
                }

                else if(Pascode.isEmpty()){
                    Toast.makeText(Sign_up_Activity.this,"Pleas fill the password field",Toast.LENGTH_SHORT).show();
                }


                else if (contact.isEmpty()){
                    Toast.makeText(Sign_up_Activity.this,"Pleas fill the Contact field",Toast.LENGTH_SHORT).show();
                }

                else if (comment.isEmpty()){
                    Toast.makeText(Sign_up_Activity.this,"Pleas fill the Comment field",Toast.LENGTH_SHORT).show();
                }



                else{

                    Colector+=name+"\n";
                    Colector+=Pascode+"\n";
                    Colector+=contact+"\n";
                    Colector+=comment+"\n";
                    if (html.isChecked()){
                        Colector+="HTML"+"\n";
                        if (css.isChecked()){
                            Colector+="CSS"+"\n";
                        }
                        if (php.isChecked()){
                            Colector+="PHP"+"\n";
                        }
                    }
                    Toast.makeText(Sign_up_Activity.this,"User Info \n:"+Colector,Toast.LENGTH_SHORT).show();
                }

            }
        });

        List<String> categoryCountry=new ArrayList<>();
        categoryCountry.add("Select Country");
        categoryCountry.add("PAKISTAN");
        categoryCountry.add("AFGHANISTAN");
        categoryCountry.add("UAE");
        categoryCountry.add("TURKEY");
        categoryCountry.add("AMERICA");
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,categoryCountry);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(arrayAdapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                if(parent.getItemAtPosition(position).equals("Select Country")){
                    //Do Nothing

                }
                else{
                    String item=parent.getItemAtPosition(position).toString();
                    Colector+=item+"\n";
                    Toast.makeText(Sign_up_Activity.this, "Selected Country: "+item, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}