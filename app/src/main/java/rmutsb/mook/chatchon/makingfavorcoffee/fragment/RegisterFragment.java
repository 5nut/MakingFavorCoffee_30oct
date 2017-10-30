package rmutsb.mook.chatchon.makingfavorcoffee.fragment;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


import rmutsb.mook.chatchon.makingfavorcoffee.MainActivity;
import rmutsb.mook.chatchon.makingfavorcoffee.R;
import rmutsb.mook.chatchon.makingfavorcoffee.ultility.MyAlertDialog;

/**
 * Created by nutchatchon 13/9/2560.
 */

public class RegisterFragment extends Fragment {

    //Explicit
    private String nameString, surnameString, idCardString,PhoneString, EmailString, passwordString;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        return view;
    } //onCreateView

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //ToolBar Controller
        toolBarController();

        //Save Controller
        saveController();


    } //onActivityCreated

    private void saveController() {
        ImageView imageView = getView().findViewById(R.id.imvSave);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String url = "http://10.0.3.2/coffemaking/saveAddData.php";
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);
                List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(6);
                nameValuePair.add(new BasicNameValuePair("sName", "nutn"));
                nameValuePair.add(new BasicNameValuePair("sSurName", "nuts"));
                nameValuePair.add(new BasicNameValuePair("sIdcrad", "1234567891234"));
                nameValuePair.add(new BasicNameValuePair("sPhone", "0843884698"));
                nameValuePair.add(new BasicNameValuePair("sEmail", "nut@g.com"));
                nameValuePair.add(new BasicNameValuePair("sPassword", "123"));
                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_LONG).show();
                }

                // Execute HTTP Post Request
                try {
                    HttpResponse response = httpclient.execute(httpPost);
                    StatusLine statusLine = response.getStatusLine();
                    int statusCode = statusLine.getStatusCode();

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_LONG).show();
                }

                //Initial View
//                EditText nameEditText = getView().findViewById(R.id.edtName);
//                EditText surNameEditText = getView().findViewById(R.id.edtsurName);
//                EditText idCardEditText = getView().findViewById(R.id.edtidCard);
//                EditText PhoneNumberEditText = getView().findViewById(R.id.edtPhoneNumber);
//                EditText eMailEditText = getView().findViewById(R.id.edtEmail);
//                EditText passwordEditText = getView().findViewById(R.id.edtPassword);

                //Get Value From Edittext
//                nameString = nameEditText.getText().toString().trim();
//                surnameString = surNameEditText.getText().toString().trim();
//                idCardString = idCardEditText.getText().toString().trim();
//                PhoneString = PhoneNumberEditText.getText().toString().trim();
//                EmailString = eMailEditText.getText().toString().trim();
//                passwordString = passwordEditText.getText().toString().trim();

                //Check Space
//                if (nameString.equals("") || surnameString.equals("") ||
//                        idCardString.equals("") || PhoneString.equals("")||
//                        EmailString.equals("") || passwordString.equals("")){
                    //Have Space
//                    MyAlertDialog myAlertDialog = new MyAlertDialog(getActivity());
//                    myAlertDialog.myDialog(getResources().getString(R.string.title_haveSpace),
//                            getResources().getString(R.string.messsage_haveSpace));
//                }


            }  //OnClick
        });
    }

    private void toolBarController() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarRegister);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });


    }
} //Main Class
