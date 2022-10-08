package com.example.profile_ltdtdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DangNhap extends AppCompatActivity {
    EditText eUser,ePassword;
    Button bDangnhap,bDangKy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide(); //This line hides the acction bar

        setContentView(R.layout.activity_dangnhap);
        Anhxa();
        bDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (eUser.getText().length() != 0 && ePassword.getText().length() !=0){
                    if (eUser.getText().toString().equals("Trung") && ePassword.getText().toString().equals("12345")){
                        Toast.makeText(DangNhap.this,"Dang Nhap Thanh Cong",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DangNhap.this, Home.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(DangNhap.this,"Sai Mat Khau",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(DangNhap.this,"Vui Long Nhap Day Du Thong Tin",Toast.LENGTH_SHORT).show();
                }
            }
        });
        bDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(DangNhap.this, DangKy.class);
                startActivity(intent2);
            }
        });

    }
    private void Anhxa(){
        eUser = (EditText) findViewById(R.id.edittextUser);
        ePassword = (EditText) findViewById(R.id.edittextPassword);
        bDangnhap = (Button) findViewById(R.id.buttonDangNhap);
        bDangKy =(Button) findViewById(R.id.buttonDangKy);
    }
}