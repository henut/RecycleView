package com.example.a129.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a129.R;
import com.example.a129.model.EquipmentBean;

import java.util.ArrayList;
import java.util.List;

//设备适配器
public class EquipmentAdapter extends RecyclerView.Adapter<EquipmentAdapter.ViewHolder> {
    private Context context;
    private List<EquipmentBean> dataList = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public EquipmentAdapter(Context context){
        this.context = context;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //创建itemView
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.adapter_item_equipment,parent,false);

        //创建ViewHolder
        return new EquipmentAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EquipmentBean bean = dataList.get(position);
                onItemClickListener.onClickListener(bean);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setData(List<EquipmentBean> list) {
        dataList.addAll(list);
    }

    //点击事件接口
    public interface OnItemClickListener{
        void onClickListener(EquipmentBean bean);
    }

    //提供点击实现类方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle;
        private TextView tvDesc;
        private ImageView tvImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            tvImg = itemView.findViewById(R.id.tv_img);
        }

        public void bindData(int position) {
            EquipmentBean bean = dataList.get(position);
            tvTitle.setText(bean.getTitle());
            tvDesc.setText(bean.getDescription());
            tvImg.setImageResource(bean.getImgId());
        }
    }

}
