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

import com.example.seminarmobileprojectexam.CinemaData.CinemaObj;

import java.util.ArrayList;

public class CinemaAdapter extends RecyclerView.Adapter<CinemaAdapter.CinemaViewHolder> {
    private LayoutInflater layoutInflater;
    private ArrayList<CinemaObj> items;

    public CinemaAdapter(Context context, ArrayList<CinemaObj> places){
        layoutInflater = LayoutInflater.from(context);
        items = places;
    }


    @NonNull
    @Override
    public CinemaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.place_item, parent, false);
        return new CinemaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CinemaViewHolder holder, int position) {
        CinemaObj currentPlace = items.get(position);
        setDataForTextView(holder, currentPlace);

        setImageForImageView(holder, currentPlace.getImage());


    }

    private void setImageForImageView(CinemaViewHolder holder, String image) {
        int resId = holder.itemView.getContext().getResources().getIdentifier(image, "drawable", holder.itemView.getContext().getPackageName());
        holder.imageView.setImageResource(resId);
    }

    private void setDataForTextView(CinemaViewHolder holder, CinemaObj currentPlace) {
        holder.Name.setText(currentPlace.getPlaceName());
        holder.Contact.setText(currentPlace.getPhone());
        holder.Address.setText(currentPlace.getAddress());
        holder.Time.setText(currentPlace.getStartTime().toString() + " - " +currentPlace.getEndTime().toString());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CinemaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView Name, Address, Time, Contact;
        private ImageView imageView;
        private Context context;
        public CinemaViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
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
            CinemaObj cinemaObj = items.get(pos);
            Intent intent = new Intent(context, Cine_detail.class);
            intent.putExtra("ID", cinemaObj.getId());
            context.startActivity(intent);
        }
    }
}
