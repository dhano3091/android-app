package dhamraj.jindal.tourism;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final int Database_Version=1;
    public static final String Database_Name="contacts.db";
    public static final String Table_Name="contacts";
    public static final String Column_Id="id";
    public static final String Column_Name="name";
    public static final String Column_Contact="contact";
    public static final String Column_Email="email";
    public static final String Column_Country="country";
    public static final String  Column_Password="password";
SQLiteDatabase db;

    public static final String  Table_Create="create table contacts (id integer primary key not null,"+"name text not null,contact integer not null,email text not null,country text not null,password text not null);";
    public DatabaseHelper(Context context){
        super(context,Database_Name,null,Database_Version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
   db.execSQL(Table_Create);
   this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                String query="DROP TABLE IF EXISTS "+Table_Name;
                db.execSQL(query);
                this.onCreate(db);
    }
    public void insertContact(Contact c){
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        String query="select * from contacts";
        Cursor cursor=db.rawQuery(query,null);
        int count=cursor.getCount();
        values.put(Column_Id,count);
        values.put(Column_Name,c.getName());
        values.put(Column_Country,c.getCountry());
        values.put(Column_Contact,c.getContact());
        values.put(Column_Email,c.getEmail());
        values.put(Column_Password,c.getPassword());
        db.insert(Table_Name,null,values);
        db.close();
    }
    public String searchpass(String email){
        db =this.getReadableDatabase();
        String a,b,c;
        b="not found";
        String query="select email, password, name from "+Table_Name;
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                 a=cursor.getString(0);
                 if(a.equals(email)){
                     b=cursor.getString(1);
                     c=cursor.getString(2);
                     break;
                 }
            }while (cursor.moveToNext());
        }
         return b;
    }
    public String searchname(String email){
        db =this.getReadableDatabase();
        String a,b,c = null;
        b="not found";
        String query="select email, password, name from "+Table_Name;
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);
                if(a.equals(email)){
                    b=cursor.getString(1);
                    c=cursor.getString(2);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return c;
    }
    public String registeremailcheck(String email){
        db =this.getReadableDatabase();
        String s="not found";
        String query="select email from "+Table_Name;
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {
                s=cursor.getString(0);
                if(s.equals(email)){
                  break;
                }
            }while (cursor.moveToNext());

        }
        return s;
    }
    public boolean update(String newpassword,String email){
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Column_Password,newpassword);
        final int update = db.update(Table_Name, values, "email=?", new String[]{email});
        db.close();
        return true;
    }
}
