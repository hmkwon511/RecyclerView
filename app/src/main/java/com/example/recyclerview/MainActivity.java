package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class MainActivity extends AppCompatActivity {

    String[] titles = { "한산: 용의 출현", "탑건: 메버릭",  "비상선언", "헤어질 결심", "덤블도어의 비밀",
                         "헌트1", "헌트2", "헌트3", "헌트4", "헌트5" };
    int[] images = {R.drawable.movie1,R.drawable.movie2, R.drawable.movie3, R.drawable.movie4,
            R.drawable.movie5, R.drawable.movie6, R.drawable.movie6, R.drawable.movie6,
            R.drawable.movie6, R.drawable.movie6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.rv1);
        //레이아웃매니져 필요?

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        CustomAdapter customAdapter = new CustomAdapter(titles, images);

        ////////////////아이템 클릭 처리를 위해 추가가 필요한 코드///////////////////////////////////////////////////////
        customAdapter.setOnItemClickListener(new CustomAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int pos, String data) {
                //실제 해야 할 일 구현
                Toast.makeText(getApplicationContext(), pos + "위치의" + data +" 영화가 선택", Toast.LENGTH_SHORT).show();
            }
        });
        /////////////////이번트 처리와 연관된 코드 끝//////////////////////////////////////////////////////////

        recyclerView.setAdapter(customAdapter);

    }
}