package com.uncc.mobileappdev.mobileappweekseven;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {


    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Demo", "AFragment: onCreateView");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Demo", "AFragment: onResume");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Demo", "AFragment: onCreate");
    }

    FragmentTextChange mListner;
    FragmentChange aListner;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("Demo", "AFragment: onAttach");

        try{
            mListner = (FragmentTextChange) context;
            aListner = (FragmentChange) context;

        } catch(ClassCastException e) {
            throw new ClassCastException(context.toString() + " Should implement FragmentTextChange");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Demo", "AFragment: onActivityCreated");

        getActivity().findViewById(R.id.fragmentButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aListner.goToNextFragment();
            }
        });

//        getActivity().findViewById(R.id.button_click_me).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "Button Pressed!", Toast.LENGTH_SHORT).show();
//            }
//        });

//        final EditText editText = getView().findViewById(R.id.fragmentEditText);
//
//        getView().findViewById(R.id.fragmentButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String text = editText.getText().toString();
//
//                if(text == null){
//                    text = "";
//                }
//
//                mListner.onTextChanged(text);
//            }
//        });

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Demo", "AFragment: onStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Demo", "AFragment: onDestroy");
    }

    public void changeColor(int color){
//        getActivity().findViewById(R.id.fragmentLayout).setBackgroundColor(color);

        getView().setBackgroundColor(color);

    }

    public interface FragmentTextChange{
        void onTextChanged(String text);
    }

    public interface FragmentChange{
        void goToNextFragment();
    }

}
