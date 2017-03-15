package com.example.wellington.lolguide.view.ui.details.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.champion.ChampionDto;
import com.example.wellington.lolguide.model.champion.Skin;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SkinSaver extends AppCompatActivity {

    public static final String SAVESKIN = "saveSkin";
    public static final int PERMISSION_WRITE_EXTERNAL_STORAGE = 0;

    @Bind(R.id.toolbarSkin)
    Toolbar toolbarSkin;
    @Bind(R.id.ivSkinSaver)
    ImageView ivSkinSaver;

    private Context mContext;
    private Skin skin;
    private String mChampname;
    private ChampionDto champion;
    private String stringSkin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin_saver);
        ButterKnife.bind(this);


        setSupportActionBar(toolbarSkin);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");

            Drawable drawable = toolbarSkin.getNavigationIcon();
            drawable.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        }

        Bundle bundle = getIntent().getExtras();
        stringSkin = bundle.getString(SAVESKIN);


        getSkin();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            super.onBackPressed();
        } else if (id == R.id.bt_share){
            shareSkin(this, stringSkin);
        } else if(id == R.id.bt_save){
            checkPermissions();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_skin, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public static void shareSkin(Context context, String url) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, context.getString(R.string.my_skin));
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, url);
        context.startActivity(Intent.createChooser(sharingIntent, context.getResources().getString(R.string.share_using)));
    }


    private void getSkin() {

        Picasso.with(mContext).load(stringSkin).placeholder(R.drawable.bg_detail).into(ivSkinSaver);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case PERMISSION_WRITE_EXTERNAL_STORAGE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    saveSkin();
                    // Permission Granted
                } else {
                    Toast.makeText(SkinSaver.this, "Sem Permissão", Toast.LENGTH_SHORT).show();
                }
                break;
        }


    }

    public void checkPermissions() {
        if (ContextCompat.checkSelfPermission(SkinSaver.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            saveSkin();
        } else {
            ActivityCompat.requestPermissions(SkinSaver.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_WRITE_EXTERNAL_STORAGE);
        }
    }

    public void saveSkin() {
        ivSkinSaver.buildDrawingCache();
        Bitmap bm = ivSkinSaver.getDrawingCache();

        OutputStream fOut = null;
        Uri outputFileUri;
        try {
            File mediaFile;
            File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
                    + "/Android/data/"
                    + getApplicationContext().getPackageName()
                    + "/Files");
            String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date());
            String mImageName = "MI_" + timeStamp + ".jpg";
            mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);
            fOut = new FileOutputStream(mediaFile);
        } catch (Exception e) {
            Toast.makeText(this, "Error occured. Please try again later.",
                    Toast.LENGTH_SHORT).show();
        }

        try {
            bm.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
        }
    }
}