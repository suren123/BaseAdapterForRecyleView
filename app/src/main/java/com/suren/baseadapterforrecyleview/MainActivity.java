package com.suren.baseadapterforrecyleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.suren.baseadapter.BaseAdapter;
import com.suren.baseadapterforrecyleview.adapter.StringAdapter;
import com.suren.baseadapterforrecyleview.divider.ListDividerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.rv_items)
    RecyclerView rv_items;
    @InjectView(R.id.srl_flush)
    SwipeRefreshLayout mSrlFlush;
    @InjectView(R.id.btn_add)
    Button btn_add;
    @InjectView(R.id.btn_del)
    Button btn_del;

    private StringAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        rv_items.setHasFixedSize(true);
        rv_items.setLayoutManager(new LinearLayoutManager(this));

        ListDividerView listDividerView = new ListDividerView(this, ListDividerView.VERTICAL_LIST);
        rv_items.addItemDecoration(listDividerView);

        mAdapter = new StringAdapter(initData());

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.addItem("test", 0);
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.removeItem(0);
            }
        });

        mAdapter.setOnItemLongClickLitener(new BaseAdapter.OnItemLongClickLitener() {
            @Override
            public void onItemLongClick(View view, int position) {
                mAdapter.removeItem(position);
            }
        });

        rv_items.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_settings:
                return true;

            case R.id.action_aidltest:
                Intent intent = new Intent(this, AIDLTestActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<String> initData(){
        String[] itemArray = getResources().getStringArray(R.array.item_array);
        return new ArrayList<String>(Arrays.asList(itemArray));
    }
}
