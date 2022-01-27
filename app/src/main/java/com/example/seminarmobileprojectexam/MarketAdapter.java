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

import com.example.seminarmobileprojectexam.SupermarketData.MarketObj;

import java.io.IOException;
import java.util.ArrayList;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.MarketViewHolder> {
    private LayoutInflater layoutInflater;
    private ArrayList<MarketObj> items;

    public MarketAdapter(Context context, ArrayList<MarketObj> places){
        layoutInflater = LayoutInflater.from(context);
        items = places;
    }

    @NonNull
    @Override
    public MarketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.place_item, parent, false);
        return new MarketViewHolder(itemView, this);
    }


    @Override
    public void onBindViewHolder(@NonNull MarketViewHolder holder, int position) {
        MarketObj currentPlace = items.get(position);
        setDataForTextView(holder, currentPlace);

        try {
            setImageForImageView(holder, currentPlace.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void setImageForImageView(MarketViewHolder holder, String nameImage) throws IOException {
        //int resId= this.getResources().getIdentifier("supermarket", "mipmap", this.getPackageName());
        int resId = holder.itemView.getContext().getResources().getIdentifier(nameImage, "drawable", holder.itemView.getContext().getPackageName());
        //URL url = new URL(nameImage);
        //Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());

        holder.imageView.setImageResource(resId);
    }

    private void setDataForTextView(MarketViewHolder holder, MarketObj currentPlace) {
        holder.Name.setText(currentPlace.getPlaceName());
        holder.Contact.setText(currentPlace.getPhone());
        holder.Address.setText(currentPlace.getAddress());
        holder.Time.setText(currentPlace.getStartTime().toString() + " - " +currentPlace.getEndTime().toString());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MarketViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView Name, Address, Time, Contact;
        private ImageView imageView;
        private MarketAdapter adapterRecycle;
        private Context context;
        public MarketViewHolder(@NonNull View itemView, MarketAdapter Adapter) {
            super(itemView);
            context = itemView.getContext();
            adapterRecycle = Adapter;
            Name = itemView.findViewById(R.id.namePlaceItem);
            Address = itemView.findViewById(R.id.addrPlaceItem);
            Time = itemView.findViewById(R.id.timePlaceItem);
            Contact = itemView.findViewById(R.id.contactPlaceItem);
            imageView = itemView.findViewById(R.id.imageViewPlaceItem);
            itemView.setOnClickListener(this);


        }


        @Override
        public void onClick(View view) {
            int pos = getLayoutPosition();
            MarketObj supermarket = items.get(pos);
            Intent intent = new Intent(context, Market_Detail.class );
            intent.putExtra("ID", supermarket.getId());
            context.startActivity(intent);
        }
    }
}
