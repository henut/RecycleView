package com.example.a129;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.a129.adapter.EquipmentAdapter;
import com.example.a129.model.EquipmentBean;

import java.util.ArrayList;
import java.util.List;

public class EquipmentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_list);

        //RecycleView初始化
        RecyclerView rvEquipment = findViewById(R.id.rv_equipment);
        rvEquipment.setHasFixedSize(true);
        rvEquipment.setLayoutManager(new LinearLayoutManager(this));

        //初始化列表数据，设置到适配器
        List<EquipmentBean> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            EquipmentBean equipmentBean = new EquipmentBean();
            equipmentBean.setTitle("第" + (i+1) + "个设备的标题");
            equipmentBean.setDescription("第" + (i+1) + "个设备由于温度与湿度不管是从物理量本身还是在实际人们的生活中都有密切关系，所以温湿度一体的传感器就会相应产生。温湿度传感器是指能将温度量和湿度量转换成容易被测量处理的电信号的设备或装置。 市场上的温湿度传感器一般是测量温度量和相对湿度量。");
            if(i % 5 == 1){
                equipmentBean.setImgId(R.drawable.led);
            }else if(i % 5 == 2) {
                equipmentBean.setImgId(R.drawable.little_image_error);
            }else if(i % 5 == 3){
                equipmentBean.setImgId(R.drawable.watch);
            }else{
                equipmentBean.setImgId(R.drawable.ic_launcher_background);
            }
            list.add(equipmentBean);
        }

        EquipmentAdapter equipmentAdapter = new EquipmentAdapter(this);
        equipmentAdapter.setData(list);
        equipmentAdapter.setOnItemClickListener(new EquipmentAdapter.OnItemClickListener() {
            @Override
            public void onClickListener(EquipmentBean bean) {
                Toast.makeText(EquipmentListActivity.this, bean.getTitle() + bean.getDescription(), Toast.LENGTH_SHORT).show();
            }
        });
        rvEquipment.setAdapter(equipmentAdapter);
    }
}