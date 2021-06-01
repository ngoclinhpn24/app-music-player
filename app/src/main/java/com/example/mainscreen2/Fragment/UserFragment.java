package com.example.mainscreen2.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mainscreen2.LoginActivity;
import com.example.mainscreen2.MainActivity;
import com.example.mainscreen2.R;

import static android.content.Context.MODE_PRIVATE;

public class UserFragment extends Fragment {

    EditText edtName;
    Button btn_logOut;
    public UserFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        edtName = view.findViewById(R.id.edt_name);
//        controlButton();
        return view;
    }


//    private void controlButton() {
//        btn_logOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });


}
