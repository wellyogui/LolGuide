package com.example.wellington.lolguide.view.ui.details.fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wellington.lolguide.R;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TipsFragment extends Fragment {

    private View view;

    public static final String ALLYTIP = "allytips";
    public static final String ENEMYTIP = "enemytips";


    @Bind(R.id.tvAllyTips)
    TextView tvAllyTips;
    @Bind(R.id.tvEnemyTips)
    TextView tvEnemyTips;
    @Bind(R.id.tvAllyTittle)
    TextView tvAllyTittle;
    @Bind(R.id.tvEnemyTittle)
    TextView tvEnemyTittle;


    public TipsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tips, container, false);
        ButterKnife.bind(this, view);

        Bundle bundle = getArguments();
        if (bundle != null){
            List<String> allyList = (List<String>) bundle.getSerializable(ALLYTIP);
            List<String> enemyList = (List<String>) bundle.getSerializable(ENEMYTIP);

            getTips(allyList, enemyList);
        }

        Typeface type = Typeface.createFromAsset(getContext().getAssets(), "fonts/FrizQuadrata.ttf");
        tvAllyTittle.setTypeface(type);
        tvEnemyTittle.setTypeface(type);

        return view;
    }

    public void getTips(List<String> allyList, List<String> enemyList){
        String allyText = "";
        String enemyText = "";

        for(String ally: allyList){

            allyText += ally + "\n";

        }

        tvAllyTips.setText(Html.fromHtml(allyText));

        for (String enemy : enemyList){

            enemyText += enemy + "\n";
        }

        tvEnemyTips.setText(Html.fromHtml(enemyText));

    }

}
