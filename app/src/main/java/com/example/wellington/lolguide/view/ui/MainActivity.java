package com.example.wellington.lolguide.view.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.ObjectAdapter;
import com.example.wellington.lolguide.model.champion.ChampionDto;
import com.example.wellington.lolguide.view.ui.details.ChampionDetail;
import com.example.wellington.lolguide.view.ui.details.MyPageAdapter;
import com.example.wellington.lolguide.view.ui.fragment.ChampionFragment;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Util;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.sliding_tabs_main)
    TabLayout tabLayout;
    @Bind(R.id.viewpager_main)
    ViewPager viewPager;
    @Bind(R.id.bmb)
    BoomMenuButton bmb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("");
        }

        setTabs();





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        return true;
    }

    public void callDetails(String id) {

        Intent intent = new Intent(MainActivity.this, ChampionDetail.class);

        Bundle bundle = new Bundle();
        bundle.putString(ObjectAdapter.ID, id);

        setBoomMenu();

        intent.putExtras(bundle);
        startActivity(intent);

    }


    public void setTabs() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        tabLayout.removeAllTabs();


        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.helmet));
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.spellbook));
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.shield));


        MyPageAdapterMain mpAdapter = new MyPageAdapterMain(fragmentManager);
        viewPager.setAdapter(mpAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(tabLayout.getTabCount());
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private void setBoomMenu() {

        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            TextInsideCircleButton.Builder builder = new TextInsideCircleButton.Builder()
                    .listener(new OnBMClickListener() {
                        @Override
                        public void onBoomButtonClick(int index) {
                            // When the boom-button corresponding this builder is clicked.
                            Toast.makeText(MainActivity.this, "Clicked " + index, Toast.LENGTH_SHORT).show();
                        }
                    })

                    // Whether the image-view should rotate.
                    .rotateImage(false)

                    // Whether the text-view should rotate.
                    .rotateText(false)

                    // Whether the boom-button should have a shadow effect.
                    .shadowEffect(true)

                    // Set the horizontal shadow-offset of the boom-button.
                    .shadowOffsetX(20)

                    // Set the vertical shadow-offset of the boom-button.
                    .shadowOffsetY(0)

                    // Set the radius of shadow of the boom-button.
                    .shadowRadius(Util.dp2px(20))

                    // Set the color of the shadow of boom-button.
                    .shadowColor(Color.parseColor("#ee000000"))

                    // Set the image resource when boom-button is at normal-state.
                    .normalImageRes(R.drawable.search)

                    // Set the image drawable when boom-button is at normal-state.
                    .normalImageDrawable(getResources().getDrawable(R.drawable.search, null))

                    // Set the image resource when boom-button is at highlighted-state.
                    .highlightedImageRes(R.drawable.helmet)

                    // Set the image drawable when boom-button is at highlighted-state.
                    .highlightedImageDrawable(getResources().getDrawable(R.drawable.helmet, null))

                    // Set the image resource when boom-button is at unable-state.
                    .unableImageRes(R.drawable.shield)

                    // Set the image drawable when boom-button is at unable-state.
                    .unableImageDrawable(getResources().getDrawable(R.drawable.shield, null))

                    // Set the rect of image.
                    // By this method, you can set the position and size of the image-view in boom-button.
                    // For example, builder.imageRect(new Rect(0, 50, 100, 100)) will make the
                    // image-view's size to be 100 * 50 and margin-top to be 50 pixel.
                    .imageRect(new Rect(Util.dp2px(10), Util.dp2px(10), Util.dp2px(70), Util.dp2px(70)))

                    // Set the padding of image.
                    // By this method, you can control the padding in the image-view.
                    // For instance, builder.imagePadding(new Rect(10, 10, 10, 10)) will make the
                    // image-view content 10-pixel padding to itself.
                    .imagePadding(new Rect(0, 0, 0, 0))

                    // Set the text resource when boom-button is at normal-state.
                    .normalTextRes(R.string.text_inside_circle_button_text_normal)

                    // Set the text resource when boom-button is at highlighted-state.
                    .highlightedTextRes(R.string.text_inside_circle_button_text_highlighted)

                    // Set the text resource when boom-button is at unable-state.
                    .unableTextRes(R.string.text_inside_circle_button_text_unable)

                    // Set the text when boom-button is at normal-state.
                    .normalText("Put your normal text here")

                    // Set the text when boom-button is at highlighted-state.
                    .highlightedText("Put your highlighted text here")

                    // Set the text when boom-button is at unable-state.
                    .unableText("Unable!")

                    // Set the color of text when boom-button is at normal-state.
                    .normalTextColor(Color.BLACK)

                    // Set the color of text when boom-button is at highlighted-state.
                    .highlightedTextColor(Color.BLUE)

                    // Set the color of text when boom-button is at unable-state.
                    .unableTextColor(Color.RED)

                    // Set the rect of text.
                    // By this method, you can set the position and size of the text-view in boom-button.
                    // For example, builder.textRect(new Rect(0, 50, 100, 100)) will make the
                    // text-view's size to be 100 * 50 and margin-top to be 50 pixel.
                    .textRect(new Rect(Util.dp2px(15), Util.dp2px(52), Util.dp2px(65), Util.dp2px(72)))

                    // Set the padding of text.
                    // By this method, you can control the padding in the text-view.
                    // For instance, builder.textPadding(new Rect(10, 10, 10, 10)) will make the
                    // text-view content 10-pixel padding to itself.
                    .textPadding(new Rect(0, 0, 0, 0))

                    // Set the typeface of the text.
                    .typeface(Typeface.DEFAULT_BOLD)

                    // Set the maximum of the lines of text-view.
                    .maxLines(2)

                    // Set the gravity of text-view.
                    .textGravity(Gravity.CENTER)

                    // Set the ellipsize of the text-view.
                    .ellipsize(TextUtils.TruncateAt.MIDDLE)

                    // Set the text size of the text-view.
                    .textSize(10)

                    // Whether the boom-button should have a ripple effect.
                    .rippleEffect(true)

                    // The color of boom-button when it is at normal-state.
                    .normalColor(Color.RED)

                    // The resource of color of boom-button when it is at normal-state.
                    .normalColorRes(R.color.red)

                    // The color of boom-button when it is at highlighted-state.
                    .highlightedColor(Color.BLUE)

                    // The resource of color of boom-button when it is at highlighted-state.
                    .highlightedColorRes(R.color.blue)

                    // The color of boom-button when it is at unable-state.
                    .unableColor(Color.BLACK)

                    // The resource of color of boom-button when it is at unable-state.
                    .unableColorRes(R.color.black)

                    // The color of boom-button when it is just a piece.
                    .pieceColor(Color.WHITE)

                    // The resource of color of boom-button when it is just a piece.
                    .pieceColorRes(R.color.white)

                    // Whether the boom-button is unable, default value is false.
                    .unable(true)

                    // The radius of boom-button, in pixel.
                    .buttonRadius(Util.dp2px(40));
            bmb.addBuilder(builder);
        }
    }

}
