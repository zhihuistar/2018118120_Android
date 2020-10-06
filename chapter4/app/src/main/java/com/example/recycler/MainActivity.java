package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Plant> plantList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPlants();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        PlantAdapter adapter = new PlantAdapter(plantList);
        recyclerView.setAdapter(adapter);
    }
    private void initPlants(){
        for(int i = 0; i < 2; i++){
            Plant xiang_ri_kui = new Plant(getRandomLengthName("向日葵"), R.drawable.xiang_ri_kui);
            plantList.add(xiang_ri_kui);
            Plant jian_guo = new Plant(getRandomLengthName("坚果"), R.drawable.jian_guo);
            plantList.add(jian_guo);
            Plant tu_dou_di_lei = new Plant(getRandomLengthName("土地地雷"), R.drawable.tu_dou_di_lei);
            plantList.add(tu_dou_di_lei);
            Plant wo_gua = new Plant(getRandomLengthName("窝瓜"), R.drawable.wo_gua);
            plantList.add(wo_gua);
            Plant ying_tao_zha_dan = new Plant(getRandomLengthName("樱桃炸弹"), R.drawable.ying_tao_zha_dan);
            plantList.add(ying_tao_zha_dan);
            Plant xian_ren_zhang = new Plant(getRandomLengthName("仙人掌"), R.drawable.xian_ren_zhang);
            plantList.add(xian_ren_zhang);
            Plant xi_gua_tou_shou = new Plant(getRandomLengthName("西瓜投手"), R.drawable.xi_gua_tou_shou);
            plantList.add(xi_gua_tou_shou);
            Plant bing_xi_gua = new Plant(getRandomLengthName("冰西瓜"), R.drawable.bing_xi_gua);
            plantList.add(bing_xi_gua);
            Plant shuang_xiang_she_shou = new Plant(getRandomLengthName("双向射手"), R.drawable.shuang_xiang_she_shou);
            plantList.add(shuang_xiang_she_shou);
            Plant cai_wen = new Plant(getRandomLengthName("菜问"), R.drawable.cai_wen);
            plantList.add(cai_wen);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < length; i++){
            builder.append(name);
        }
        return builder.toString();
    }
}