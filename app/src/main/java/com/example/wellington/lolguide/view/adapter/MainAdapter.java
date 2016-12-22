package com.example.wellington.lolguide.view.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.ObjectAdapter;
import com.example.wellington.lolguide.model.champion.Champion;
import com.example.wellington.lolguide.utils.AppConfigs;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainAdapterViewHolder>  {

    public List<ObjectAdapter> mObjecterList;
    private final OnObjectClickListener listener;
    private Context mContext;


    public interface OnObjectClickListener {
        void OnObjectClickListener(ObjectAdapter objectAdapter);
    }


    public MainAdapter(Context context, List<ObjectAdapter> objectAdapterList, OnObjectClickListener listener) {
        this.mObjecterList = objectAdapterList;
        this.listener = listener;
        this.mContext = context;
    }

    @Override
    public MainAdapter.MainAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_adapter, parent, false);

        return new MainAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapter.MainAdapterViewHolder holder, int position) {
        ObjectAdapter ob = mObjecterList.get(position);

        holder.tvNameText.setText(ob.Name);
        holder.bind(mObjecterList.get(position), listener);

        String url = "";
        switch (ob.Type){

            case CHAMPION: url = String.format(AppConfigs.portraitChampion, ob.Portrait);
                break;
            case SPELL: url = String.format(AppConfigs.portraitSpell, ob.Portrait);
                break;
            case ITEM: url = String.format(AppConfigs.portraitItem, ob.Portrait);
                break;
        }

        Picasso.with(mContext).load(url).into(holder.ivRetrato);

    }

    @Override
    public int getItemCount() {
        return this.mObjecterList.size();
    }

    public static class MainAdapterViewHolder extends RecyclerView.ViewHolder {

        public TextView tvNameText;
        public ImageView ivRetrato;

        public MainAdapterViewHolder(View itemView) {
            super(itemView);

            this.tvNameText = (TextView) itemView.findViewById(R.id.tvNameText);
            this.ivRetrato = (ImageView) itemView.findViewById(R.id.ivImagePortrait);
        }

        public void bind(final ObjectAdapter  objectAdapterListItem, final OnObjectClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnObjectClickListener(objectAdapterListItem);
                }
            });
        }
    }
}
