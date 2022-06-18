package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import Modal.Records;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mydb1.db";
    public static final String TABLe_NAME = "sstd_record";
   /* public static final String ID = "mydb.db";
    public static final String NAME = "mydb.db";
    public static final String ADDRESS = "mydb.db";
    public static final String CONTACT_NO = "mydb.db";*/

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+ TABLe_NAME +" (_id INTEGER PRIMARY KEY,name TEXT,course TEXT,mobile TEXT,total_fee INTEGER,fee_paid INTEGER)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS sstd_record");
        onCreate(db);

    }

    public long addRecord(Records records) {

        SQLiteDatabase database = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("name",records.getName());
        cv.put("course",records.getCourse());
        cv.put("mobile",records.getMobile());
        cv.put("total_fee",records.getTotalfee());
        cv.put("fee_paid",records.getFee_paid());
        /*cv.put("name",username);
        cv.put("course",course);
        cv.put("mobile",mobile);
        cv.put("total_fee",total);
        cv.put("fee_paid",feepaid);*/


        long result =database.insert("sstd_record",null,cv);

        return  result;

    }
    public ArrayList<Records> getAllRecords(){
        ArrayList<Records>  records = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor =  database.rawQuery("SELECT * FROM sstd_record",null);
        if(cursor.moveToFirst()){
            do {
                int id  = cursor.getInt(0);
                String name  = cursor.getString(1);
                String course  = cursor.getString(2);
                String mobile = cursor.getString(3);
                int tf = cursor.getInt(4);
                int fp = cursor.getInt(5);
                Records r =  new Records(id, name,course, mobile,tf,fp);
                records.add(r);
            }
            while (cursor.moveToNext());
        }


        return  records;
    }

    public int updateStudents(Records r) {

        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name",r.getName());
        cv.put("course",r.getCourse());
        cv.put("mobile",r.getMobile());
        cv.put("total_fee",r.getTotalfee());
        cv.put("fee_paid",r.getFee_paid());
       return database.update("sstd_record", cv, "_id=?",new String[]{String.valueOf(r.getId())});


    }

    public int deleteRecords(int id) {
        SQLiteDatabase database = getWritableDatabase();
        return database.delete("sstd_record","_id=?",new String[]{String.valueOf(id)});

    }
}
