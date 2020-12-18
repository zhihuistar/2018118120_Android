package com.example.dictionary.collect_frag;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.dictionary.ChengyuInfoActivity;
import com.example.dictionary.R;
import com.example.dictionary.WordInfoActivity;
import com.example.dictionary.db.DBManager;

import java.util.ArrayList;
import java.util.List;

//收藏成语的Fragment
public class CyFragment extends Fragment {
    GridView gv;
    List<String> mDatas;
    private ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_cy, container, false);
        gv = view.findViewById(R.id.cyfrag_gv);
        mDatas = new ArrayList<>();
        adapter = new ArrayAdapter<>(getContext(), R.layout.item_search_pgv, R.id.item_sgv_tv, mDatas);
        gv.setAdapter(adapter);
//        设置GridView的点击事件
        setGVListener();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        List<String>list;
        mDatas.clear();
        list = DBManager.queryAllCyuInCollcyutb();
        mDatas.addAll(list);
        adapter.notifyDataSetChanged();;
    }

    private void setGVListener() {
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String cy = mDatas.get(position);
                Intent intent = new Intent(getActivity(), ChengyuInfoActivity.class);
                intent.putExtra("chengyu",cy);
                startActivity(intent);
            }
        });
    }
}