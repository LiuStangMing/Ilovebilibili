package com.bilibili.ccc.ilovebilibili_master.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bilibili.ccc.ilovebilibili_master.Data.LiveItemBean;
import com.bilibili.ccc.ilovebilibili_master.Interface.MyItemClickListener;
import com.bilibili.ccc.ilovebilibili_master.R;
import com.bumptech.glide.Glide;


import java.util.List;


public class Live_Item_RecyclerViewAdapter extends RecyclerView.Adapter<Live_Item_RecyclerViewAdapter.ItemViewHolder>{

    private Context mContext;
    private List<LiveItemBean> datas;
    private LayoutInflater mLayoutInflater;

    public Live_Item_RecyclerViewAdapter(Context context, List<LiveItemBean> data){
        mContext = context;
        datas = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    private MyItemClickListener listener;
    public void setOnItemClickListener(MyItemClickListener listener){
        this.listener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.live_itemview2,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = holder;
        LiveItemBean data = datas.get(position);
//        Glide.with(mContext).load(data.getImage()).into(itemViewHolder.imageView);
        itemViewHolder.imageView.setImageResource(data.getImage());
        itemViewHolder.title.setText(data.getTitle());
        itemViewHolder.name.setText(data.getName());
        itemViewHolder.count.setText(data.getCount() + "");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView title;
        private TextView name;
        private TextView count;

        public ItemViewHolder(View itemView) {
            super(itemView);
//            imageView = (ImageView) itemView.findViewById(R.id.id_live_item_img);
//            title = (TextView) itemView.findViewById(R.id.id_live_item_title);
//            name = (TextView) itemView.findViewById(R.id.id_live_item_name);
//            count = (TextView) itemView.findViewById(R.id.id_live_item_count);
            imageView = (ImageView) itemView.findViewById(R.id.itemview_img);
            title = (TextView) itemView.findViewById(R.id.itemview_title);
            name = (TextView) itemView.findViewById(R.id.itemview_name);
            count = (TextView) itemView.findViewById(R.id.itemview_count);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(v,getAdapterPosition());
        }
    }
}
