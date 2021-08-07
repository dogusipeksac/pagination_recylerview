package com.example.pagination_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    /*private List<ListItem> listItems;*/
    private Button nextButton,prevButton;
    private Paginator paginator=new Paginator();
    private int totalPages=Paginator.TOTAL_NUM_ITEMS / Paginator.ITEMS_PER_PAGE;
    private int currentPage=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        nextButton=findViewById(R.id.nextButton);
        prevButton=findViewById(R.id.prevButton);
        prevButton.setEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        /*listItems=new ArrayList<>();*/
        /*addList();*/
        adapter=new MyAdapter(/*listItems,*/this,paginator.generatePage(currentPage));
        recyclerView.setAdapter(adapter);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPage+=1;
                recyclerView.setAdapter(new MyAdapter(getApplicationContext(),paginator.generatePage(currentPage)));
                toggleButtons();
            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPage-=1;
                recyclerView.setAdapter(new MyAdapter(getApplicationContext(),paginator.generatePage(currentPage)));
                toggleButtons();
            }
        });

    }

    private void toggleButtons() {
        if(currentPage==totalPages){
            nextButton.setEnabled(false);
            prevButton.setEnabled(true);
        }
        else if(currentPage==0){
            prevButton.setEnabled(false);
            nextButton.setEnabled(true);
        }else if(currentPage>=1 && currentPage<=totalPages){
            nextButton.setEnabled(true);
            prevButton.setEnabled(true);
        }
    }

}