package com.example.seconddatabasereveiw;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ProductAddDialog extends DialogFragment {
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.product_add_layout,container);
        ((Button)view.findViewById(R.id.btnAdd)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=
                        ((EditText)view.findViewById(R.id.txtName)).getText().toString();
                String color=
                        ((EditText)view.findViewById(R.id.txtColor)).getText().toString();
                DatabaseHelper helper=new DatabaseHelper(context);
                helper.addProduct(name , color);
                ((EditText)view.findViewById(R.id.txtName)).setText("");
                ((EditText)view.findViewById(R.id.txtColor)).setText("");
                ((MainActivity)context).fillList();
            }
        });
        ((Button)view.findViewById(R.id.btnCancel)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return view;
    }
}
