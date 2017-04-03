package com.example.wellington.lolguide.view.ui.details.fragment;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.champion.Info;
import com.example.wellington.lolguide.model.champion.Stats;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;


public class OverViewFragment extends Fragment {

    public static final String INFO = "info";
    public static final String STATS = "stats";
    public static final String TAG = "tags";

    //region [Bind Info]
//    @Bind(R.id.tvAtaque)
//    TextView tvAtaque;
//    @Bind(R.id.tvDefesa)
//    TextView tvDefesa;
//    @Bind(R.id.tvMagica)
//    TextView tvMagica;
//    @Bind(R.id.tvDificu)
//    TextView tvDificuldade;
    @Bind(R.id.progressBarAt)
    ProgressBar progressBarAt;
    @Bind(R.id.progressBarDe)
    ProgressBar progressBarDe;
    @Bind(R.id.progressBarMa)
    ProgressBar progressBarMa;
    @Bind(R.id.progressBarDi)
    ProgressBar progressBarDi;

    //endregion

    //region [Bind Stats]
    @Bind(R.id.tvVida)
    TextView tvHp;
    @Bind(R.id.tvVidaPerLevel)
    TextView tvHpPerLevel;
    @Bind(R.id.tvVidaRegen)
    TextView tvHpRegen;
    @Bind(R.id.tvVidaRegenPorLevel)
    TextView tvHpRegenPerLevel;
    @Bind(R.id.tvArmadura)
    TextView tvArmadura;
    @Bind(R.id.tvArmaduraPorLevel)
    TextView tvArmaduraPerLevel;
    @Bind(R.id.tvDanoAtaque)
    TextView tvDanoAtaque;
    @Bind(R.id.tvDanoAtaquePorLevel)
    TextView tvDanoAtaquePerLevel;
    @Bind(R.id.tvVelocidadeAtaque)
    TextView tvVelocidadeAtaque;
    @Bind(R.id.tvVelocidadeAtaquePorLevel)
    TextView tvVelocidadeAtaquePerLevel;
    @Bind(R.id.tvAlcance)
    TextView tvAlcance;
    @Bind(R.id.tvAtaqueCritico)
    TextView tvAtaqueCritico;
    @Bind(R.id.tvAtaqueCriticoPorLevel)
    TextView tvAtaqueCriticoPerLevel;
    @Bind(R.id.tvMovimentacao)
    TextView tvMovemetntacao;
    @Bind(R.id.tvMp)
    TextView tvMp;
    @Bind(R.id.tvMPPerLevel)
    TextView tvMpPerLevel;
    @Bind(R.id.tvMpRegen)
    TextView tvMpRegen;
    @Bind(R.id.tvMPRegenPerLevel)
    TextView tvMpRegenPerLevel;
    @Bind(R.id.tvSpellBlock)
    TextView tvSpelllBlock;
    @Bind(R.id.tvSpellBlockPerLevel)
    TextView tvSpellBlockPerLevel;
    @Bind(R.id.sbLevelCustom)
    DiscreteSeekBar seekBarCustom;
    @Bind(R.id.tvLevel)
    TextView tvLevel;
    @BindString(R.string.level)
    String levelString;
    @Bind(R.id.tvInfoTittle)
    TextView tvInfo;
    @Bind(R.id.tvAtk)
    TextView tvAtk;
    @Bind(R.id.tvDef)
    TextView tvDef;
    @Bind(R.id.tvMag)
    TextView tvMag;
    @Bind(R.id.tvDif)
    TextView tvDif;
    @Bind(R.id.tvStatsTittle)
    TextView tvStats;
    //endregion


    private View view;
    private Stats stats;
    private Info info;

    public OverViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_over_view, container, false);
        ButterKnife.bind(this, view);

        Bundle bundle = getArguments();
        if (bundle != null) {
            info = (Info) bundle.getSerializable(INFO);
            getInfo();

            stats = (Stats) bundle.getSerializable(STATS);
            getStats();

            setLevelSeekBar();
        }

        Typeface type = Typeface.createFromAsset(getContext().getAssets(), "fonts/FrizQuadrata.ttf");
        tvMpRegen.setTypeface(type);
        tvMp.setTypeface(type);
        tvAtaqueCritico.setTypeface(type);
        tvVelocidadeAtaque.setTypeface(type);
        tvAlcance.setTypeface(type);
        tvArmadura.setTypeface(type);
        tvArmaduraPerLevel.setTypeface(type);
        tvAtaqueCriticoPerLevel.setTypeface(type);
        tvDanoAtaque.setTypeface(type);
        tvDanoAtaquePerLevel.setTypeface(type);
        tvHp.setTypeface(type);
        tvHpPerLevel.setTypeface(type);
        tvHpRegen.setTypeface(type);
        tvHpRegenPerLevel.setTypeface(type);
        tvLevel.setTypeface(type);
        tvMovemetntacao.setTypeface(type);
        tvMpRegenPerLevel.setTypeface(type);
        tvMpPerLevel.setTypeface(type);
        tvSpellBlockPerLevel.setTypeface(type);
        tvSpelllBlock.setTypeface(type);
        tvAtk.setTypeface(type);
        tvDef.setTypeface(type);
        tvDif.setTypeface(type);
        tvMag.setTypeface(type);
        tvInfo.setTypeface(type);
        tvStats.setTypeface(type);


        return view;
    }

    private void animateProgress(ProgressBar progressBar, int progressValue) {
        progressValue *= 2;
        if (progressValue < 0) {
            progressValue = 0;
        }
        int animTime = 500;
        ObjectAnimator anim = ObjectAnimator.ofInt(progressBar, "progress", progressBar.getProgress(), progressValue);
        anim.setDuration(animTime);
        anim.setInterpolator(new LinearInterpolator());
        anim.start();
    }

    public void getInfo() {

//        tvAtaque.setText(String.valueOf(info.attack));
//        tvDefesa.setText(String.valueOf(info.defense));
//        tvMagica.setText(String.valueOf(info.magic));
//        tvDificuldade.setText(String.valueOf(info.difficulty));

//        progressBarAt.setProgress(info.attack);
        animateProgress(progressBarAt, info.attack);

//        progressBarDe.setProgress(info.defense);
        animateProgress(progressBarDe, info.defense);


//        progressBarMa.setProgress(info.magic);
        animateProgress(progressBarMa, info.magic);


//        progressBarDi.setProgress(info.difficulty);
        animateProgress(progressBarDi, info.difficulty);


    }

    public void getStats() {

        updateLevel(0);

        tvHpPerLevel.setText("(+ " + String.valueOf(stats.hpperlevel) + " por level)");

        tvHpRegenPerLevel.setText("(+ " + String.valueOf(stats.hpregenperlevel) + " por level)");

        tvArmaduraPerLevel.setText("(+ " + String.valueOf(stats.armorperlevel) + " por level)");

        tvDanoAtaquePerLevel.setText("(+ " + String.valueOf(stats.attackdamageperlevel) + " por level)");

        tvVelocidadeAtaquePerLevel.setText("(+ " + String.valueOf(stats.attackspeedperlevel) + " por level)");

        tvAlcance.setText(String.valueOf(stats.attackrange));

        tvAtaqueCriticoPerLevel.setText("(+ " + String.valueOf(stats.critperlevel) + " por level)");

        tvMovemetntacao.setText(String.valueOf(stats.movespeed));

        tvMpPerLevel.setText("(+ " + String.valueOf(stats.mpperlevel) + " por level)");

        tvMpRegenPerLevel.setText("(+ " + String.valueOf(stats.mpregenperlevel) + " por level)");

        tvSpellBlockPerLevel.setText("(+ " + String.valueOf(stats.spellblockperlevel) + " por level)");


    }

    @SuppressLint("DefaultLocale")
    private void updateLevel(int level) {

        tvHp.setText(String.format("%.2f", (stats.hp + stats.hpperlevel * level)));

        tvHpRegen.setText(String.format("%.2f", (stats.hpregen + stats.hpregenperlevel * level)));

        tvArmadura.setText(String.format("%.2f", (stats.armor + stats.armorperlevel * level)));

        tvDanoAtaque.setText(String.format("%.2f", (stats.attackdamage + stats.attackdamageperlevel * level)));

        tvVelocidadeAtaque.setText(String.format("%.2f", (stats.attackspeedoffset + stats.attackspeedperlevel * level)));

        tvAtaqueCritico.setText(String.format("%.2f", (stats.crit + stats.critperlevel * level)));

        tvMp.setText(String.format("%.2f", (stats.mp + stats.mpperlevel * level)));

        tvMpRegen.setText(String.format("%.2f", (stats.mpregen + stats.mpregenperlevel * level)));

        tvSpelllBlock.setText(String.format("%.2f", (stats.spellblock + stats.spellblockperlevel * level)));


    }

    private void setLevelSeekBar() {

        tvLevel.setText(String.format(levelString, 1));


        seekBarCustom.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int progress, boolean fromUser) {
                tvLevel.setText(String.format(levelString, progress));

                updateLevel(progress);
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });

    }

}


