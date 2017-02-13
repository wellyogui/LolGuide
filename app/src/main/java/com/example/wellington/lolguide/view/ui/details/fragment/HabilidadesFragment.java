package com.example.wellington.lolguide.view.ui.details.fragment;

import android.content.Context;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.champion.Passive;
import com.example.wellington.lolguide.model.champion.Spell;
import com.example.wellington.lolguide.utils.AppConfigs;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HabilidadesFragment extends Fragment {

    //region [Bind Description]
    @Bind(R.id.tvNomeSkill)
    TextView tvNomeSkill;
    @Bind(R.id.tvDescricaoSkill)
    TextView tvDescricaoSkill;
    @Bind(R.id.tvCostSkill)
    TextView tvCostSkill;
    @Bind(R.id.tvAlcanceSkill)
    TextView tvAlcance;
    @Bind(R.id.tvCoolDownSkill)
    TextView tvCoolDownSkill;
    @Bind(R.id.tvEfeitoSkill)
    TextView tvEfeitoSkill;
    @Bind(R.id.tvTitleAlcanceSkill)
    TextView tvTitleAlcanceSkill;
    @Bind(R.id.tvTitleCoolDownSkill)
    TextView TvTitleCoolDownSkill;
    @Bind(R.id.tvTitleCustoSkill)
    TextView tvTitleCustoSkill;
    @Bind(R.id.tvTitleEfeitoSkill)
    TextView tvTitleEfeitoSkill;


    @Bind(R.id.ibSkill1)
    ImageButton ibSKill1;
    @Bind(R.id.ibSkill2)
    ImageButton ibSKill2;
    @Bind(R.id.ibSkill3)
    ImageButton ibSKill3;
    @Bind(R.id.ibSkill4)
    ImageButton ibSKill4;
    @Bind(R.id.ibSkill5)
    ImageButton ibSKill5;

    @Bind(R.id.ivBorder1)
    ImageView ivBorder1;
    @Bind(R.id.ivBorder2)
    ImageView ivBorder2;
    @Bind(R.id.ivBorder3)
    ImageView ivBorder3;
    @Bind(R.id.ivBorder4)
    ImageView ivBorder4;
    @Bind(R.id.ivBorder5)
    ImageView ivBorder5;
    //endregion


    public static final String SKILL = "skill";
    public static final String PASSIVE = "passive";

    private View view;
    private List<Spell> mSpell;
    private Passive mPassive;

    public HabilidadesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_habilidades, container, false);
        ButterKnife.bind(this, view);


        Bundle bundle = getArguments();
        if (bundle != null) {
            mSpell = (List<Spell>) bundle.getSerializable(SKILL);
            mPassive = (Passive) bundle.getSerializable(PASSIVE);
            setImage();
            setSkill(0);


            ivBorder2.setVisibility(View.GONE);
            ivBorder3.setVisibility(View.GONE);
            ivBorder4.setVisibility(View.GONE);
            ivBorder5.setVisibility(View.GONE);


        }

        return view;


    }

    public void setImage() {
        Picasso.with(getActivity()).load(String.format(AppConfigs.portraitSpell, mSpell.get(0).image.full)).into(ibSKill1);
        Picasso.with(getActivity()).load(String.format(AppConfigs.portraitSpell, mSpell.get(1).image.full)).into(ibSKill2);
        Picasso.with(getActivity()).load(String.format(AppConfigs.portraitSpell, mSpell.get(2).image.full)).into(ibSKill3);
        Picasso.with(getActivity()).load(String.format(AppConfigs.portraitSpell, mSpell.get(3).image.full)).into(ibSKill4);
        Picasso.with(getActivity()).load(String.format(AppConfigs.portraitPassive, mPassive.image.full)).into(ibSKill5);
    }

    @OnClick(R.id.ibSkill1)
    public void ibSkill1OnClick() {
        setSkill(0);

        ivBorder1.setVisibility(View.VISIBLE);
        ivBorder2.setVisibility(View.GONE);
        ivBorder3.setVisibility(View.GONE);
        ivBorder4.setVisibility(View.GONE);
        ivBorder5.setVisibility(View.GONE);
    }

    @OnClick(R.id.ibSkill2)
    public void ibSkill2OnClick() {
        setSkill(1);


        ivBorder1.setVisibility(View.GONE);
        ivBorder2.setVisibility(View.VISIBLE);
        ivBorder3.setVisibility(View.GONE);
        ivBorder4.setVisibility(View.GONE);
        ivBorder5.setVisibility(View.GONE);
    }

    @OnClick(R.id.ibSkill3)
    public void ibSkill3OnClick() {
        setSkill(2);


        ivBorder1.setVisibility(View.GONE);
        ivBorder2.setVisibility(View.GONE);
        ivBorder3.setVisibility(View.VISIBLE);
        ivBorder4.setVisibility(View.GONE);
        ivBorder5.setVisibility(View.GONE);

    }

    @OnClick(R.id.ibSkill4)
    public void ibSkill4OnClick() {
        setSkill(3);


        ivBorder1.setVisibility(View.GONE);
        ivBorder2.setVisibility(View.GONE);
        ivBorder3.setVisibility(View.GONE);
        ivBorder4.setVisibility(View.VISIBLE);
        ivBorder5.setVisibility(View.GONE);
    }

    @OnClick(R.id.ibSkill5)
    public void ibSkill5OnClick() {
        setSkillPassive();


        ivBorder1.setVisibility(View.GONE);
        ivBorder2.setVisibility(View.GONE);
        ivBorder3.setVisibility(View.GONE);
        ivBorder4.setVisibility(View.GONE);
        ivBorder5.setVisibility(View.VISIBLE);
    }


    public void setSkill(int index) {


        tvNomeSkill.setText(mSpell.get(index).name);
        tvDescricaoSkill.setText(Html.fromHtml(mSpell.get(index).description));
        tvCostSkill.setText(mSpell.get(index).costBurn);
        tvAlcance.setText(mSpell.get(index).rangeBurn);
        tvCoolDownSkill.setText(mSpell.get(index).cooldownBurn);
        tvEfeitoSkill.setText(Html.fromHtml(mSpell.get(index).tooltip));

        tvCoolDownSkill.setVisibility(View.VISIBLE);
        tvCostSkill.setVisibility(View.VISIBLE);
        tvAlcance.setVisibility(View.VISIBLE);
        tvEfeitoSkill.setVisibility(View.VISIBLE);
        tvTitleAlcanceSkill.setVisibility(View.VISIBLE);
        tvTitleCustoSkill.setVisibility(View.VISIBLE);
        TvTitleCoolDownSkill.setVisibility(View.VISIBLE);
        tvTitleEfeitoSkill.setVisibility(View.VISIBLE);



    }

    public void setSkillPassive() {

        tvNomeSkill.setText(mPassive.name);
        tvDescricaoSkill.setText(Html.fromHtml(mPassive.description));


        tvCoolDownSkill.setVisibility(View.INVISIBLE);
        tvCostSkill.setVisibility(View.INVISIBLE);
        tvAlcance.setVisibility(View.INVISIBLE);
        tvEfeitoSkill.setVisibility(View.INVISIBLE);
        tvTitleAlcanceSkill.setVisibility(View.INVISIBLE);
        tvTitleCustoSkill.setVisibility(View.INVISIBLE);
        TvTitleCoolDownSkill.setVisibility(View.INVISIBLE);
        tvTitleEfeitoSkill.setVisibility(View.INVISIBLE);


    }

}

