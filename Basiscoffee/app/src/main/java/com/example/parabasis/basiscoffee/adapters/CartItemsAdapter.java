package com.example.parabasis.basiscoffee.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.parabasis.basiscoffee.R;
import com.example.parabasis.basiscoffee.model.CartItem;

import java.util.ArrayList;

import io.realm.RealmResults;

/**
 * Created by Tapiwanashe on 27/10/2016.
 */

public class CartItemsAdapter extends ArrayAdapter<CartItem> {

    public CartItemsAdapter(Context context, RealmResults<CartItem> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Get the data item for this position
        CartItem item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cart_view, parent, false);
        }
        // Lookup view for data population
        TextView cName = (TextView) convertView.findViewById(R.id.cName);
        TextView cPrice = (TextView) convertView.findViewById(R.id.cPrice);
        TextView cQuantity = (TextView) convertView.findViewById(R.id.tView3);
        TextView cFact = (TextView) convertView.findViewById(R.id.cFact);

        // Populate the data into the template view using the data object
        cName.setText(item.getCoffeename());
        cPrice.setText(item.getCoffeeprice());
        cQuantity.setText(String.valueOf(item.getQuantity()));
        cFact.setText(item.getCoffefact());

        // Return the completed view to render on screen
        return convertView;
    }
}
