package com.app.maxim.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // get link
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // create layout
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        String [] arr = new String [] {"Maxim", "Nina", "George", "Alex", "Piter", "Nikita"};

        MyAdapter myAdapter = new MyAdapter(arr, this);
        mRecyclerView.setAdapter(myAdapter);
    }

    public void printMessage(String s) {
        Toast toast = Toast.makeText(this, s, Toast.LENGTH_LONG);
        toast.show();
    }
}


class MyAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder> {
    class MyElementOfList extends RecyclerView.ViewHolder {
        public TextView t1;
        public TextView t2;

        public MyElementOfList(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.textview_1);
            t2 = (TextView) itemView.findViewById(R.id.textview_2);

            t1.setOnClickListener(new MyClick());
        }

        class MyClick implements View.OnClickListener{

            @Override
            public void onClick(View view) {
                activity.printMessage(t1.getText().toString());
            }
        }
    }

    private String [] myArray;
    private MainActivity activity;

    MyAdapter(String [] myArrayParam, MainActivity activityParam) {
        myArray = myArrayParam;
        activity = activityParam;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card, parent, false);
        return new MyElementOfList(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyElementOfList myHolder = (MyElementOfList) holder;
        String s1 = myArray[position] + " header";
        String s2 = myArray[position] + " content";
        myHolder.t1.setText(s1);
        myHolder.t2.setText(s2);
    }


    @Override
    public int getItemCount() {
        return myArray.length;
    }
}
