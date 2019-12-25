package com.example.seconddatabasereveiw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillList();
    }
    void fillList(){
        DatabaseHelper helper=new DatabaseHelper(this);
        ProductAdapter adapter=new ProductAdapter(this,helper.getProducts());
        ((ListView)findViewById(R.id.lstProduct)).setAdapter(adapter);
    }
    public void btnNew_Clicked(View view){
        ProductAddDialog dialog=new ProductAddDialog();
        dialog.setContext(this);
        dialog.setStyle(DialogFragment.STYLE_NO_TITLE,0);
        dialog.show(getSupportFragmentManager(),"");
    }
}
