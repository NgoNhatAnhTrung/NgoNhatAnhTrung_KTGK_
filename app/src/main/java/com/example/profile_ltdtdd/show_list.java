package com.example.profile_ltdtdd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class show_list extends AppCompatActivity {

    ListView lvThucAn;
    ArrayList<ThucAn> arrayThucAn;
    ThucAnAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide(); //This line hides the acction bar
        setContentView(R.layout.activity_show_list);

        AnhXa();

        adapter = new ThucAnAdapter(this, R.layout.dong_thuc_an, arrayThucAn);
        lvThucAn.setAdapter(adapter);

        lvThucAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(show_list.this, Detail.class);
                ThucAn thucAn = arrayThucAn.get(i);
                intent.putExtra("ten",thucAn.getTen());
                intent.putExtra("moTa",thucAn.getMota());
                intent.putExtra("hinh",thucAn.getHinh());
                intent.putExtra("",thucAn.getThongTin());
                startActivity(intent);
            }
        });


        lvThucAn.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacNhanXoa(i);

                return false;
            }
        });

    }

    private void XacNhanXoa(final int position) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("B???n c?? ch???c mu???n x??a kh??ng?");

        alertDialog.setPositiveButton("C??", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayThucAn.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        alertDialog.setNegativeButton("Kh??ng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }

    private void AnhXa() {
        lvThucAn = (ListView) findViewById(R.id.listviewThucAn);
        arrayThucAn = new ArrayList<>();

        arrayThucAn.add(new ThucAn("M?? Qu???ng", "?????c s???n Qu???ng Nam", R.drawable.miquang));
        arrayThucAn.add(new ThucAn("Ch??o", "Ch??o Ch?? Ph??o", R.drawable.chao));
        arrayThucAn.add(new ThucAn("B??nh M??", "Ngon B??? R???", R.drawable.banhmi));
        arrayThucAn.add(new ThucAn("H??? Ti???u", "R???t ngon", R.drawable.hutieu));
        arrayThucAn.add(new ThucAn("Ph??? B??", "Ch??n c??m th??m Ph???", R.drawable.phobo));


    }
}