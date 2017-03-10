package com.example.wellington.lolguide.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.champion.Skin;
import com.example.wellington.lolguide.utils.AppConfigs;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by wellington on 09/03/17.
 */

public class SkinAdapter extends RecyclerView.Adapter<SkinAdapter.SkinAdapterViewHolder> {

    public List<Skin> mSkin;
    private String mChampname;
    private final SkinAdapter.OnObjectClickListener listener;
    private Context mContext;


    public interface OnObjectClickListener {
        void OnObjectClickListener(Skin skin);

    }


    public SkinAdapter(Context context, List<Skin> skin, String champName,SkinAdapter.OnObjectClickListener listener) {
        this.mSkin = skin;
        this.mChampname = champName;
        this.listener = listener;
        this.mContext = context;
    }

    @Override
    public SkinAdapter.SkinAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skin_adapter, parent, false);

        return new SkinAdapter.SkinAdapterViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(SkinAdapter.SkinAdapterViewHolder holder, int position) {
        Skin skin = mSkin.get(position);

        String skinName;
        if(skin.name.toLowerCase().equals("default")){
            skinName = mChampname;
        }else {
            skinName = skin.name;
        }
        holder.tvNameSkin.setText(skinName);
        holder.bind(skin, listener);


        String stringSkin = String.format(AppConfigs.skinsImage, mChampname, skin.num);
        Picasso.with(mContext).load(stringSkin).placeholder(R.drawable.bg_detail).into(holder.ivSkin);


    }

    @Override
    public int getItemCount() {
        return this.mSkin.size();
    }

    public static class SkinAdapterViewHolder extends RecyclerView.ViewHolder {

        public TextView tvNameSkin;
        public ImageView ivSkin;


        public SkinAdapterViewHolder(View itemView) {
            super(itemView);

            this.tvNameSkin = (TextView) itemView.findViewById(R.id.tvNameSkin);
            this.ivSkin = (ImageView) itemView.findViewById(R.id.ivSkin);
        }

        public void bind(final Skin skinListItem, final SkinAdapter.OnObjectClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnObjectClickListener(skinListItem);
                }
            });
        }
    }

}
