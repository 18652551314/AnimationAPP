package com.example.android.animationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LayoutActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayAdapter mAdapter;

    private Button mAddListBtn,addData, Next;
    private GridAdapter mGrideAdapter;
    private List<String> mDatas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        mListView = (ListView) findViewById(R.id.listview);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData());
        mListView.setAdapter(mAdapter);

        mAddListBtn = (Button)findViewById(R.id.addlist);
        mAddListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.addAll(getData());
            }
        });
        //代码设置通过加载XML动画设置文件来创建一个Animation对象；
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.slide_in_left);   //得到一个LayoutAnimationController对象；
        LayoutAnimationController controller = new LayoutAnimationController(animation);   //设置控件显示的顺序；
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);   //设置控件显示间隔时间；
        controller.setDelay(0.3f);   //为ListView设置LayoutAnimationController属性；
        mListView.setLayoutAnimation(controller);
        mListView.startLayoutAnimation();
/**
 * 填充gridview
 */
        GridView grid = (GridView) findViewById(R.id.grid);
        mDatas.addAll(getGData());
        mGrideAdapter = new GridAdapter();
        grid.setAdapter(mGrideAdapter);

        /**
         * 按钮点击响应
         */
         addData = (Button)findViewById(R.id.add_data);
            addData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addData();
                }
        });
        Next= (Button) findViewById(R.id.next);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LayoutActivity.this, LayoutChangesActivity.class));
            }
        });

    }

    private List<String> getGData() {

        List<String> data = new ArrayList<String>();
        for (int i = 1;i<35;i++){
            data.add("DATA "+i);
        }
        return data;
    }


    public void addData(){
        mDatas.addAll(mDatas);
        mGrideAdapter.notifyDataSetChanged();
    }

    private List<String> getData() {

        List<String> data = new ArrayList<String>();
        data.add("测试数据1");
        data.add("测试数据2");
        data.add("测试数据3");
        data.add("测试数据4");

        return data;
    }
    class GridAdapter extends BaseAdapter {
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView i = new TextView(LayoutActivity.this);
            i.setText(mDatas.get(position));
            i.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.WRAP_CONTENT, GridView.LayoutParams.WRAP_CONTENT));
            return i;
        }

        public final int getCount() {
            return mDatas.size();
        }

        public final Object getItem(int position) {
            return null;
        }

        public final long getItemId(int position) {
            return position;
        }
    }

}
