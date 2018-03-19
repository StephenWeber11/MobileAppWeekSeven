package com.uncc.mobileappdev.mobileappweekseven;

import android.app.Fragment;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AFragment.FragmentTextChange, AFragment.FragmentChange, SecondFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Demo", "MainActivity: onCreate before inflation");
        setContentView(R.layout.activity_main);
        Log.d("Demo", "MainActivity: onCreate after inflation");

        getFragmentManager().beginTransaction()
                .add(R.id.fragmentLinearLayout, new AFragment(), "first_fragment")
                .commit();

//        getFragmentManager().beginTransaction()
//                .add(R.id.fragmentLinearLayoutTwo, new AFragment(), "fragment_tag_second")
//                .commit();

        RadioGroup rg = findViewById(R.id.colorRadioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                AFragment fragment = (AFragment) getFragmentManager().findFragmentByTag("fragment_tag");
//                AFragment fragmentTwo = (AFragment) getFragmentManager().findFragmentByTag("fragment_tag_second");

                if(checkedId == R.id.radioButtonRed){
                    fragment.changeColor(Color.RED);
//                    fragmentTwo.changeColor(Color.RED);
                } else if(checkedId == R.id.radioButtonBlue){
                    fragment.changeColor(Color.BLUE);
//                    fragmentTwo.changeColor(Color.BLUE);
                } else if(checkedId == R.id.radioButtonGreen){
                    fragment.changeColor(Color.GREEN);
//                    fragmentTwo.changeColor(Color.GREEN);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Demo", "MainActivity: onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Demo", "MainActivity: onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Demo", "MainActivity: onResume");
    }

    @Override
    public void onTextChanged(String text) {
        TextView main =  findViewById(R.id.mainTextView);
        main.setText(text);
    }

    @Override
    public void goToNextFragment() {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragmentLinearLayout, new SecondFragment(), "second")
                .addToBackStack(null) //Null is default back-stack
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //Do Nothing
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() > 0){
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }

    }
}
