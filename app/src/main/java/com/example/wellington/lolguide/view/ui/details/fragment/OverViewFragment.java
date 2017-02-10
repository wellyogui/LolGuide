package com.example.wellington.lolguide.view.ui.details.fragment;

import android.content.Context;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.champion.Champion;
import com.example.wellington.lolguide.model.champion.ChampionDto;
import com.example.wellington.lolguide.model.champion.Info;
import com.example.wellington.lolguide.model.champion.Stats;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class OverViewFragment extends Fragment {

    public static final String INFO = "info";
    public static final String STATS = "stats";
    public static final String TAG = "tags";

    //region [Bind Info]
    @Bind(R.id.tvAtaque)
    TextView tvAtaque;
    @Bind(R.id.tvDefesa)
    TextView tvDefesa;
    @Bind(R.id.tvMagica)
    TextView tvMagica;
    @Bind(R.id.tvDificu)
    TextView tvDificuldade;
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
    //endregion


    private View view;

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
            Info info = (Info) bundle.getSerializable(INFO);
            getInfo(info);

            Stats stats = (Stats) bundle.getSerializable(STATS);
            getStats(stats);

        }

        return view;
    }

    public void getInfo(Info info) {

        tvAtaque.setText(String.valueOf(info.attack));
        tvDefesa.setText(String.valueOf(info.defense));
        tvMagica.setText(String.valueOf(info.magic));
        tvDificuldade.setText(String.valueOf(info.difficulty));

        progressBarAt.setMax(10);
        progressBarAt.setProgress(info.attack);
        progressBarDe.setMax(10);
        progressBarDe.setProgress(info.defense);
        progressBarMa.setMax(10);
        progressBarMa.setProgress(info.magic);
        progressBarDi.setMax(10);
        progressBarDi.setProgress(info.difficulty);


    }

    public void getStats(Stats stats) {

        tvHp.setText(String.valueOf(stats.hp));
        tvHpPerLevel.setText("(+ " + String.valueOf(stats.hpperlevel) + " por level)");

        tvHpRegen.setText(String.valueOf(stats.hpregen));
        tvHpRegenPerLevel.setText("(+ " + String.valueOf(stats.hpregenperlevel) + " por level)");

        tvArmadura.setText(String.valueOf(stats.armor));
        tvArmaduraPerLevel.setText("(+ " + String.valueOf(stats.armorperlevel) + " por level)");

        tvDanoAtaque.setText(String.valueOf(stats.attackdamage));
        tvDanoAtaquePerLevel.setText("(+ " + String.valueOf(stats.attackdamageperlevel) + " por level)");

        tvVelocidadeAtaque.setText(String.valueOf(stats.attackspeedoffset));
        tvVelocidadeAtaquePerLevel.setText("(+ " + String.valueOf(stats.attackspeedperlevel) + " por level)");

        tvAlcance.setText(String.valueOf(stats.attackrange));

        tvAtaqueCritico.setText(String.valueOf(stats.crit));
        tvAtaqueCriticoPerLevel.setText("(+ " + String.valueOf(stats.critperlevel) + " por level)");

        tvMovemetntacao.setText(String.valueOf(stats.movespeed));

        tvMp.setText(String.valueOf(stats.mp));
        tvMpPerLevel.setText("(+ " + String.valueOf(stats.mpperlevel) + " por level)");

        tvMpRegen.setText(String.valueOf(stats.mpregen));
        tvMpRegenPerLevel.setText("(+ " + String.valueOf(stats.mpregenperlevel) + " por level)");

        tvSpelllBlock.setText(String.valueOf(stats.spellblock));
        tvSpellBlockPerLevel.setText("(+ " + String.valueOf(stats.spellblockperlevel) + " por level)");

    }


}


