package com.example.userlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.PostViewHolder> {


    private Context context;
    private ArrayList<Datum> items;

    public UserAdapter(Context context,ArrayList<Datum>items){
            this.context=context;
            this.items=items;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.userlist_layout, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        Datum datum=items.get(position);
        holder.id.setText(String.valueOf(datum.getId()));
        holder.email.setText(datum.getEmail());
        holder.firstname.setText(datum.getFirstName());
        holder.lastname.setText(datum.getLastName());
        String img=datum.getAvatar();
        Picasso.get().load(img).into(holder.image);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        TextView id,firstname,lastname,email;
        ImageView image;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.user_id);
            firstname=itemView.findViewById(R.id.first_name_id);
            lastname=itemView.findViewById(R.id.last_name_id);
            email=itemView.findViewById(R.id.email_id);
            image=itemView.findViewById(R.id.image_id);
        }
    }
}
