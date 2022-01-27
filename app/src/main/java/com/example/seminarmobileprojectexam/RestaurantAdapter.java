package com.example.seminarmobileprojectexam;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seminarmobileprojectexam.RestaurantData.RestaurantObj;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ResViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<RestaurantObj> items;

    public RestaurantAdapter(Context context, ArrayList<RestaurantObj> places){
        layoutInflater = LayoutInflater.from(context);
        items = places;
    }

    @NonNull
    @Override
    public ResViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.place_item, parent, false);
        return new ResViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResViewHolder holder, int position) {
        RestaurantObj currentPlace = items.get(position);
        setDataForTextView(holder, currentPlace);
        setImageForImageView(holder, currentPlace.getImage());

    }

    private void setImageForImageView(ResViewHolder holder, String image) {
        int resId = holder.itemView.getContext().getResources().getIdentifier(image, "drawable", holder.itemView.getContext().getPackageName());
        holder.imageView.setImageResource(resId);
    }

    private void setDataForTextView(ResViewHolder holder, RestaurantObj currentPlace) {
        holder.Name.setText(currentPlace.getPlaceName());
        holder.Contact.setText(currentPlace.getPhone());
        holder.Address.setText(currentPlace.getAddress());
        holder.Time.setText(currentPlace.getStartTime().toString() + " - " +currentPlace.getEndTime().toString());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ResViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView Name, Address, Time, Contact;
        private ImageView imageView;
        private MarketAdapter adapterRecycle;
        private Context context;
        public ResViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            Name = itemView.findViewById(R.id.namePlaceItem);
            Address = itemView.findViewById(R.id.addrPlaceItem);
            Time = itemView.findViewById(R.id.timePlaceItem);
            Contact = itemView.findViewById(R.id.contactPlaceItem);
            imageView = itemView.findViewById(R.id.imageViewPlaceItem);
            itemView.setOnClickListener( this);
        }

        @Override
        public void onClick(View view) {
            int pos = getLayoutPosition();
            RestaurantObj restaurantObj = items.get(pos);
            Intent intent = new Intent(context, Res_detail.class);
            intent.putExtra("ID", restaurantObj.getId());
            context.startActivity(intent);
        }
    }
}
