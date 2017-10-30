package rmutsb.mook.chatchon.makingfavorcoffee.fragment;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import android.os.StrictMode;

import rmutsb.mook.chatchon.makingfavorcoffee.R;

/**
 * Created by chatchon on 13/9/2560.
 */

public class MainFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    } //onCreateView

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Register Controller
        registerController();

    } //onActivityCreated

    private void registerController() {
        TextView textView = getView().findViewById(R.id.txtNewRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentFragmentMain, new RegisterFragment())
                        .addToBackStack(null)
                        .commit();

            }
        });


    }
}//Main Class
