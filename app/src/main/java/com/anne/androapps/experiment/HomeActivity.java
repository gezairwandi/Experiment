package com.anne.androapps.experiment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

public class HomeActivity extends AppCompatActivity {

    Fragment fragment = null;
    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        /*findViewById(R.id.pink_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Clicked pink Floating Action Button", Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.setter);
        button.setSize(FloatingActionButton.SIZE_MINI);
        button.setColorNormalResId(R.color.pink);
        button.setColorPressedResId(R.color.pink_pressed);
        button.setIcon(R.drawable.ic_fab_star);
        button.setStrokeVisible(false);*/

        final FloatingActionButton actionB = (FloatingActionButton)findViewById(R.id.action_b);
        final FloatingActionButton actionD = (FloatingActionButton)findViewById(R.id.action_d);
        final FloatingActionButton actionE = (FloatingActionButton)findViewById(R.id.action_e);
        final FloatingActionButton actionC = new FloatingActionButton(getBaseContext());
        actionB.setVisibility(View.GONE);
        actionD.setVisibility(View.GONE);
        actionE.setVisibility(View.GONE);
        actionC.setTitle("Hide/Show Chart Menu");
        actionC.setColorNormal(R.color.white);
        actionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionB.setVisibility(actionB.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
                actionD.setVisibility(actionD.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
                actionE.setVisibility(actionE.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });

        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        menuMultipleActions.addButton(actionC);

       /* final FloatingActionButton removeAction = (FloatingActionButton) findViewById(R.id.button_remove);
        removeAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FloatingActionsMenu) findViewById(R.id.multiple_actions_down)).removeButton(removeAction);
            }
        });*/

        /*ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
        drawable.getPaint().setColor(getResources().getColor(R.color.white));
        ((FloatingActionButton) findViewById(R.id.setter_drawable)).setIconDrawable(drawable);*/

        final FloatingActionButton actionA = (FloatingActionButton) findViewById(R.id.action_a);
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionA.setTitle("Choose Image Loader");
                showFragment(new ImageLoaderPicasso());
            }
        });

        final FloatingActionButton actionF = (FloatingActionButton) findViewById(R.id.action_f);
        actionF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionA.setTitle("Choose Image Gallery");
                showFragment(new ImageGallery());
            }
        });

        actionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionB.setTitle("Choose Pie Chart");
                /*fragment = new ChartTwo();
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.fragment_replace, fragment);
                ft.commit();*/
                showFragment(new ChartTwo());
            }
        });

        actionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionC.setTitle("Choose Bar Chart");
                showFragment(new ChartThree());
            }
        });

        actionE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionE.setTitle("Choose Line Chart");
                showFragment(new ChartFragment());
            }
        });



        // Test that FAMs containing FABs with visibility GONE do not cause crashes
        /*findViewById(R.id.button_gone).setVisibility(View.GONE);

        final FloatingActionButton actionEnable = (FloatingActionButton) findViewById(R.id.action_enable);
        actionEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuMultipleActions.setEnabled(!menuMultipleActions.isEnabled());
            }
        });*/

        /*FloatingActionsMenu rightLabels = (FloatingActionsMenu) findViewById(R.id.right_labels);
        FloatingActionButton addedOnce = new FloatingActionButton(this);
        addedOnce.setTitle("Added once");
        rightLabels.addButton(addedOnce);

        FloatingActionButton addedTwice = new FloatingActionButton(this);
        addedTwice.setTitle("Added twice");
        rightLabels.addButton(addedTwice);
        rightLabels.removeButton(addedTwice);
        rightLabels.addButton(addedTwice);*/
    }

    private void showFragment(Fragment classFrag){
        fragment = classFrag;
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.fragment_replace, fragment);
        ft.commit();
    }
}
