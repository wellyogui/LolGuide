package com.example.wellington.lolguide.view.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.view.ui.fragment.ChampionFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class NoConnection extends AppCompatActivity {

    @Bind(R.id.tvWarning)
    TextView tvWarning;
    @Bind(R.id.btnTryAgain)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_connection);
        ButterKnife.bind(this);

        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/FrizQuadrata.ttf");
        tvWarning.setTypeface(type);

        btn.setTypeface(type);

    }

    public void getConnection() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        if (ni == null) {
            Toast.makeText(getApplicationContext(), "Sem Conexão", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivityForResult(intent, RESULT_OK);
            finish();
        }

    }


    @OnClick(R.id.btnTryAgain)
    public void onRetryClick() {

        getConnection();


    }

}
