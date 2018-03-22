package com.malikbouras.tropbelleapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.malikbouras.tropbelleapp.Bean;
import com.malikbouras.tropbelleapp.R;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    public interface Click{
        void click(ImageView image, TextView textView);
    }

    private Click click;

    private List<Bean> items;
    private int itemLayout;

    public MyRecyclerAdapter(List<Bean> items, int itemLayout, Click click) {
        this.items = items;
        this.itemLayout = itemLayout;
        this.click = click;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Bean item = items.get(position);
        holder.text.setText(item.getTitle());
        //holder.image.setImageBitmap(null);
        // Picasso.with(holder.image.getContext()).cancelRequest(holder.image);
        // Picasso.with(holder.image.getContext()).load(item.getImage()).into(holder.image);
        holder.itemView.setTag(item);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.click(holder.image, holder.text);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.title);
        }
    }
}