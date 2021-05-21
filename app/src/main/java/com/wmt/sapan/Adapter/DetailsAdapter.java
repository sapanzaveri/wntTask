package com.wmt.sapan.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.wmt.sapan.R;
import com.wmt.sapan.Response.DetailsResponse;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {
    private Context context;
    private List<DetailsResponse> detailsLists;

    public DetailsAdapter(Context context, List<DetailsResponse> detailsLists) {
        this.context = context;
        this.detailsLists = detailsLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.details_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = detailsLists.get(position).getName().getFirst() + " " + detailsLists.get(position).getName().getLast();
        String email =  detailsLists.get(position).getEmail();
        String date =   detailsLists.get(position).getDob().getDate();

        SimpleDateFormat setformat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateObj = null;
        try {
            dateObj = setformat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String SetDate = outputFormat.format(dateObj);
        holder.txt_Name.setText("Name:-" + name);
        holder.txt_Email.setText("Email:-\n" +email);
        holder.txt_Date.setText("DOB:-" + SetDate);

        Glide.with(context)
                .load(detailsLists.get(position).getPicture().getThumbnail())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                }).into(holder.img_Img);
    }

    @Override
    public int getItemCount() {
        return detailsLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    private TextView txt_Name;
    private TextView txt_Email;
    private TextView txt_Date;
    private ImageView img_Img;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_Name =itemView.findViewById(R.id.txt_Name);
        txt_Email = itemView.findViewById(R.id.txt_Email);
        txt_Date = itemView.findViewById(R.id.txt_Date);
        img_Img = itemView.findViewById(R.id.img_Img);
    }
}
}
