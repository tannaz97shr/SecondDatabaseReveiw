package com.example.seconddatabasereveiw;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private final int PRODUCT_PRODUCTID=0;
    private final int PRODUCT_NAME=1;
    private final int PRODUCT_COLOR=2;

    private final String PRODUCT_CREATE="CREATE TABLE IF NOT EXISTS Product(ProductID INTEGER PRIMARY KEY AUTOINCREMENT , Name TEXT , Color TEXT)";
    private final String PRODUCT_INSERT="INSERT INTO Product(Name,Color) VALUES(?,?)";
    private final String PRODUCT_SELECT="SELECT * FROM Product";

    public List<Product> getProducts(){
        ArrayList<Product>products=new ArrayList<>();
        Cursor cursor=
                getReadableDatabase().rawQuery(PRODUCT_SELECT,null);
        if(cursor.moveToFirst()){
            do{
                Product product=new Product();
                product.setProductID(
                        cursor.getInt(PRODUCT_PRODUCTID)
                );
                product.setName(cursor.getString(PRODUCT_NAME));
                product.setColor(cursor.getString(PRODUCT_COLOR));
                products.add(product);
            }while (cursor.moveToNext());
        }
        return products;
    }


    public void addProduct(String name , String color){
        getWritableDatabase().execSQL(PRODUCT_INSERT,new Object[]{name , color});
        //getWritableDatabase().execSQL(PRODUCT_INSERT,Object[]{name,color});
    }

    public DatabaseHelper(Context context){
        super(context,"database",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(PRODUCT_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
