package com.example.seconddatabasereveiw;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends ArrayAdapter {
    private Context context;
    private List<Product>products;
    public ProductAdapter(Context context,List<Product>products){
        super(context,R.layout.product_add_layout,products);
        this.context=context;
        this.products=products;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Activity activity=(Activity)context;
        convertView=activity.getLayoutInflater()
                .inflate(R.layout.product_list_layout,null);
        Product product=products.get(position);
        ((TextView)convertView.findViewById(R.id.lblName)).setText(product.getName());
        ((TextView)convertView.findViewById(R.id.lblColor)).setText(product.getColor());
        return convertView;
    }
}
