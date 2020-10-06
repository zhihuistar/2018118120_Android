package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Plant> plantList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPlants();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        PlantAdapter adapter = new PlantAdapter(plantList);
        recyclerView.setAdapter(adapter);
    }
    private void initPlants(){
        for(int i = 0; i < 2; i++){
            Plant jian_guo = new Plant("坚果", R.drawable.jian_guo);
            plantList.add(jian_guo);
            Plant bing_xi_gua = new Plant("冰西瓜", R.drawable.bing_xi_gua);
            plantList.add(bing_xi_gua);
            Plant shuang_xiang_she_shou = new Plant("双向射手", R.drawable.shuang_xiang_she_shou);
            plantList.add(shuang_xiang_she_shou);
            Plant tu_dou_di_lei = new Plant("土地地雷", R.drawable.tu_dou_di_lei);
            plantList.add(tu_dou_di_lei);
            Plant wo_gua = new Plant("窝瓜", R.drawable.wo_gua);
            plantList.add(wo_gua);
            Plant xi_gua_tou_shou = new Plant("西瓜投手", R.drawable.xi_gua_tou_shou);
            plantList.add(xi_gua_tou_shou);
            Plant xian_ren_zhang = new Plant("仙人掌", R.drawable.xian_ren_zhang);
            plantList.add(xian_ren_zhang);
            Plant xiang_ri_kui = new Plant("向日葵", R.drawable.xiang_ri_kui);
            plantList.add(xiang_ri_kui);
            Plant ying_tao_zha_dan = new Plant("樱桃炸弹", R.drawable.ying_tao_zha_dan);
            plantList.add(ying_tao_zha_dan);
            Plant xing_xing_guo = new Plant("星星果", R.drawable.xing_xing_guo);
            plantList.add(xing_xing_guo);
        }
    }
}