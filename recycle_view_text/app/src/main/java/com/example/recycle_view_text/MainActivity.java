package com.example.recycle_view_text;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.anhttvn.customrecyclerview.adapter.ListAdapter;
import com.anhttvn.customrecyclerview.model.ItemAdapter;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecycleview;
    private List<ItemAdapter> mList = new ArrayList<>();
    private ListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addList();
        adapter();
    }
    private void init(){
        mRecycleview = findViewById(R.id.listView);
    }
    private void addList(){
        ItemAdapter itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.cachua);
        itemAdapter.setName("Tomato");
        mList.add(itemAdapter);
        itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.bo);
        itemAdapter.setName("butter");
        mList.add(itemAdapter);
        itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.cam);
        itemAdapter.setName("oranges");
        mList.add(itemAdapter);
        itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.quaxoai);
        itemAdapter.setName("mango");
        mList.add(itemAdapter);
        itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.dau);
        itemAdapter.setName("strawberry");
        mList.add(itemAdapter);
        itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.tao);
        itemAdapter.setName("Apple");
        mList.add(itemAdapter);
        mList.add(itemAdapter);
        itemAdapter = new ItemAdapter();
        itemAdapter.setImage(R.drawable.oi);
        itemAdapter.setName("guava fruit");
        mList.add(itemAdapter);
    }
    private void adapter(){
        mAdapter = new ListAdapter(mList, this);
        mRecycleview.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}