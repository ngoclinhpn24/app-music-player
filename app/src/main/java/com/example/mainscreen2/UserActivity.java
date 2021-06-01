package com.example.mainscreen2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {

    TextView tvEditInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        tvEditInfo = (TextView) findViewById(R.id.edit_info);

        tvEditInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openEditInfo(Gravity.CENTER);
            }
        });
    }

    private void openEditInfo(int gravity) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_edit_info);

        Window window = dialog.getWindow();
        if(window == null){
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        if(Gravity.CENTER == gravity){
            dialog.setCancelable(true); // click ra ben ngoai de tat dialog
        }
//        else{
//            dialog.setCancelable(false);
//        }

        // tắt dialog: dialog.dismiss()

        EditText edtPassword = dialog.findViewById(R.id.edt_newPass);
        Button btnSubmit = dialog.findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(UserActivity.this, "Password đã update",Toast.LENGTH_SHORT ).show();
            }
        });
        dialog.show();
    }
}