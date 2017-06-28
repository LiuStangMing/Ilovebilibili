package com.bilibili.ccc.ilovebilibili_master.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bilibili.ccc.ilovebilibili_master.Data.LiveBean;
import com.bilibili.ccc.ilovebilibili_master.Data.LiveItemBean;
import com.bilibili.ccc.ilovebilibili_master.Interface.MyItemClickListener;
import com.bilibili.ccc.ilovebilibili_master.R;
import com.bilibili.ccc.ilovebilibili_master.Until.Config;
import com.bilibili.ccc.ilovebilibili_master.Until.GlideImageLoader;
import com.bilibili.ccc.ilovebilibili_master.Until.SpacesItemDecoration;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;


public class LiveRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //banner轮播
    private static final int BANNER = 0;
    //水平title标题
    private static final int HORZIONTAL_TITLE = 1;
    //1.推荐主播
    private static final int TUIJIAN = 2;
    //2.绘画专区
    private static final int HUIHUA = 3;
    //3.生活娱乐
    private static final int SHENGHUO = 42;
    //4.唱见舞见
    private static final int CHANGWU = 52;
    //5.手游直播
    private static final int SHOUYOU = 62;
    //6.单机联机
    private static final int DANJI = 72;
    //7.网络游戏
    private static final int WANGLUOGAME = 82;
    //8.电子竞技
    private static final int DIANJING = 92;
    //9.御宅文化
    private static final int YUZHAI = 102;
    //10.放映厅
    private static final int FANGYIN = 112;

    private List<LiveBean> datas;
    private LayoutInflater mLayoutInfater;
    private Context mContext;
    //当前的布局
    private int currentType = 0;

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case BANNER:
                currentType = BANNER;
                break;
            case HORZIONTAL_TITLE:
                currentType = HORZIONTAL_TITLE;
                break;
            case TUIJIAN:
                currentType = TUIJIAN;
                break;
            case HUIHUA:
                currentType = HUIHUA;
                break;
            case SHENGHUO:
                currentType = SHENGHUO;
                break;
            case CHANGWU:
                currentType = CHANGWU;
                break;
            case SHOUYOU:
                currentType = SHOUYOU;
                break;
            case DANJI:
                currentType = DANJI;
                break;
            case WANGLUOGAME:
                currentType = WANGLUOGAME;
                break;
            case DIANJING:
                currentType = DIANJING;
                break;
            case YUZHAI:
                currentType = YUZHAI;
                break;
            case FANGYIN:
                currentType = FANGYIN;
                break;
        }
        Log.i("currentType = ", currentType+"");
        return currentType;
    }

    public LiveRecyclerViewAdapter(Context context, List<LiveBean> datas){
        this.datas = datas;
        mContext = context;
        mLayoutInfater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BANNER){
            return new BannerViewHolder(mLayoutInfater.inflate(R.layout.banner_viewholder
            ,parent,false));
        }else if (viewType == HORZIONTAL_TITLE){
            return new HorziontalTitleViewHolder(mLayoutInfater.inflate(R.layout.horizontal_title
            ,parent,false));
        }else if(viewType == TUIJIAN){
            return new TuijianViewHolder(mLayoutInfater.inflate(R.layout.live_viewholder
            ,parent,false));
        }else if (viewType == HUIHUA){
            return new TuijianViewHolder(mLayoutInfater.inflate(R.layout.live_viewholder,
                    parent,false));
        }else if (viewType == SHENGHUO){
            return new TuijianViewHolder(mLayoutInfater.inflate(R.layout.live_viewholder,
                    parent,false));
        }else if (viewType == CHANGWU){
            return new TuijianViewHolder(mLayoutInfater.inflate(R.layout.live_viewholder,
                    parent,false));
        }else if (viewType == SHOUYOU){
            return new TuijianViewHolder(mLayoutInfater.inflate(R.layout.live_viewholder,
                    parent,false));
        }else if (viewType == DANJI){
            return new TuijianViewHolder(mLayoutInfater.inflate(R.layout.live_viewholder,
                    parent,false));
        }else if (viewType == WANGLUOGAME){
            return new TuijianViewHolder(mLayoutInfater.inflate(R.layout.live_viewholder,
                    parent,false));
        }else if (viewType == DIANJING){
            return new TuijianViewHolder(mLayoutInfater.inflate(R.layout.live_viewholder,
                    parent,false));
        }else if (viewType == YUZHAI){
            return new TuijianViewHolder(mLayoutInfater.inflate(R.layout.live_viewholder,
                    parent,false));
        }else if (viewType == FANGYIN){
            return new TuijianViewHolder(mLayoutInfater.inflate(R.layout.live_viewholder,
                    parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == BANNER){
            BannerViewHolder bannerHolder = (BannerViewHolder) holder;
            bannerHolder.initbanner();
        }else if (getItemViewType(position) == HORZIONTAL_TITLE){
            HorziontalTitleViewHolder horziontalHolder = (HorziontalTitleViewHolder) holder;
            horziontalHolder.setData();
        }else if (getItemViewType(position) == TUIJIAN){
            TuijianViewHolder tuijianHolder = (TuijianViewHolder) holder;
            tuijianHolder.setData(position);
        }else if (getItemViewType(position) == HUIHUA){
            TuijianViewHolder huiHuaViewHolder = (TuijianViewHolder) holder;
            huiHuaViewHolder.setData(position);
        }else if (getItemViewType(position) == SHENGHUO){
            TuijianViewHolder huiHuaViewHolder = (TuijianViewHolder) holder;
            huiHuaViewHolder.setData(position);
        }else if (getItemViewType(position) == DANJI){
            TuijianViewHolder huiHuaViewHolder = (TuijianViewHolder) holder;
            huiHuaViewHolder.setData(position);
        }else if (getItemViewType(position) == WANGLUOGAME){
            TuijianViewHolder huiHuaViewHolder = (TuijianViewHolder) holder;
            huiHuaViewHolder.setData(position);
        }else if (getItemViewType(position) == DIANJING){
            TuijianViewHolder huiHuaViewHolder = (TuijianViewHolder) holder;
            huiHuaViewHolder.setData(position);
        }else if (getItemViewType(position) == CHANGWU){
            TuijianViewHolder huiHuaViewHolder = (TuijianViewHolder) holder;
            huiHuaViewHolder.setData(position);
        }else if (getItemViewType(position) == YUZHAI){
            TuijianViewHolder huiHuaViewHolder = (TuijianViewHolder) holder;
            huiHuaViewHolder.setData(position);
        }else if (getItemViewType(position) == FANGYIN){
            TuijianViewHolder huiHuaViewHolder = (TuijianViewHolder) holder;
            huiHuaViewHolder.setData(position);
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    class BannerViewHolder extends RecyclerView.ViewHolder{

        private Banner banner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.id_live_banner);
        }

        public void initbanner(){
//            List images = new ArrayList<String>();
//            images.add(Config.URL_TWO + "banner_Image1.jpg");
//            images.add(Config.URL_TWO + "banner_Image2.png");

            List<Integer> images2 = new ArrayList<Integer>();
            images2.add(R.drawable.banner1);
            images2.add(R.drawable.banner2);

            //设置banner的样式
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            //设置banner的图片加载器
            banner.setImageLoader(new GlideImageLoader());
            //设置图片的集合
            banner.setImages(images2);
            banner.setBannerAnimation(Transformer.DepthPage);
            //设置标题集合（当banner样式有显示title时
            //banner.setBannerTitles(titles);
            //设置自动轮播，默认为true
            banner.isAutoPlay(true);
            //设置轮播时间
            banner.setDelayTime(3000);
            //设置指示器位置（当banner模式中有指示器时）
            banner.setIndicatorGravity(BannerConfig.RIGHT);
            //banner设置方法全部调用完毕时最后调用
            banner.start();
        }
    }

    class HorziontalTitleViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout ll_look;
        private LinearLayout ll_center;
        private LinearLayout ll_video;
        private LinearLayout ll_sreach;
        private LinearLayout ll_classification;
        private ImageView lookImage;
        private ImageView centerImage;
        private ImageView videoImage;
        private ImageView sreachImage;
        private ImageView classificationImage;

        public HorziontalTitleViewHolder(View itemView) {
            super(itemView);
            ll_center = (LinearLayout) itemView.findViewById(R.id.id_live_ll_center);
            ll_classification = (LinearLayout) itemView.findViewById(R.id.id_live_ll_classification);
            ll_look = (LinearLayout) itemView.findViewById(R.id.id_live_ll_look);
            ll_sreach = (LinearLayout) itemView.findViewById(R.id.id_live_ll_sreach);
            ll_video = (LinearLayout) itemView.findViewById(R.id.id_live_ll_video);
            lookImage = (ImageView) itemView.findViewById(R.id.id_live_ll_look_img);
            sreachImage = (ImageView) itemView.findViewById(R.id.id_live_ll_sreach_img);
            videoImage = (ImageView) itemView.findViewById(R.id.id_live_ll_video_img);
            classificationImage = (ImageView) itemView.findViewById(R.id.id_live_ll_classification_img);
            centerImage = (ImageView) itemView.findViewById(R.id.id_live_ll_center_img);
        }

        public void setData(){
            Glide.with(mContext).load(R.drawable.live_home_all_category).into(classificationImage);
            Glide.with(mContext).load(R.drawable.live_home_clip_video).into(videoImage);
            Glide.with(mContext).load(R.drawable.live_home_search_room).into(sreachImage);
            Glide.with(mContext).load(R.drawable.live_home_live_center).into(centerImage);
            Glide.with(mContext).load(R.drawable.live_home_follow_anchor).into(lookImage);
        }
    }

    class TuijianViewHolder extends RecyclerView.ViewHolder implements MyItemClickListener {

        private ImageView leftImage;
        private TextView mTitle;
        private TextView mlookCount;
        private RecyclerView mRecyclerView;
        private Live_Item_RecyclerViewAdapter adapter;
        private List<LiveItemBean> mDatas;

        public TuijianViewHolder(View itemView) {
            super(itemView);
            leftImage = (ImageView) itemView.findViewById(R.id.id_liveviewholder_img);
            mTitle = (TextView) itemView.findViewById(R.id.id_liveviewholder_tv);
            mlookCount = (TextView) itemView.findViewById(R.id.id_liveviewholder_count);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.id_viewholder_recyclerview);
            mDatas = new ArrayList<LiveItemBean>();
            mDatas.add(new LiveItemBean(R.drawable.image4,"#唱见舞见#暴走百货直播舞台"
                    ,"养鸟少女",3855));
            mDatas.add(new LiveItemBean(R.drawable.image4,"#唱见舞见#暴走百货直播舞台"
                    ,"养鸟少女",3855));
            mDatas.add(new LiveItemBean(R.drawable.image4,"#唱见舞见#暴走百货直播舞台"
                    ,"养鸟少女",3855));
            mDatas.add(new LiveItemBean(R.drawable.image4,"#唱见舞见#暴走百货直播舞台"
                    ,"养鸟少女",3855));
            mDatas.add(new LiveItemBean(R.drawable.image4,"#唱见舞见#暴走百货直播舞台"
                    ,"养鸟少女",3855));
            mDatas.add(new LiveItemBean(R.drawable.image4,"#唱见舞见#暴走百货直播舞台"
                    ,"养鸟少女",3855));
            adapter = new Live_Item_RecyclerViewAdapter(mContext,mDatas);
            StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,
                    StaggeredGridLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(manager);
//            mRecyclerView.addItemDecoration(new SpacesItemDecoration(30));
            mRecyclerView.setAdapter(adapter);

            adapter.setOnItemClickListener(this);
        }

        public void setData(int position){
            LiveBean liveBean = datas.get(position);
            Glide.with(mContext).load(R.drawable.image1).into(leftImage);
            mTitle.setText(liveBean.getTitle());
            mlookCount.setText(liveBean.getCount() + "");
        }

        @Override
        public void onItemClick(View view, int position) {
            switch (position){
                case 0:
                    Toast.makeText(mContext,"click here",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

//    class HuiHuaViewHolder extends RecyclerView.ViewHolder{
//
//        private ImageView leftImage;
//        private TextView mTitle;
//        private TextView mlookCount;
//        private RecyclerView mRecyclerView;
//        private Live_Item_RecyclerViewAdapter adapter;
//        private List<LiveItemBean> mDatas;
//
//        public HuiHuaViewHolder(View itemView) {
//            super(itemView);
//            leftImage = (ImageView) itemView.findViewById(R.id.id_liveviewholder_img);
//            mTitle = (TextView) itemView.findViewById(R.id.id_liveviewholder_tv);
//            mlookCount = (TextView) itemView.findViewById(R.id.id_liveviewholder_count);
//            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.id_viewholder_recyclerview);
//        }
//
//        public void setData(int position){
//            LiveBean liveBean = datas.get(position);
//            Glide.with(mContext).load(R.drawable.image1).into(leftImage);
//            mTitle.setText(liveBean.getTitle());
//            mlookCount.setText(liveBean.getCount() + "");
//            mDatas = new ArrayList<LiveItemBean>();
//            mDatas.add(new LiveItemBean(R.drawable.image4,"#唱见舞见#暴走百货直播舞台"
//                    ,"养鸟少女",3855));
//            mDatas.add(new LiveItemBean(R.drawable.image4,"#唱见舞见#暴走百货直播舞台"
//                    ,"养鸟少女",3855));
//            mDatas.add(new LiveItemBean(R.drawable.image4,"#唱见舞见#暴走百货直播舞台"
//                    ,"养鸟少女",3855));
//            mDatas.add(new LiveItemBean(R.drawable.image4,"#唱见舞见#暴走百货直播舞台"
//                    ,"养鸟少女",3855));
//            mDatas.add(new LiveItemBean(R.drawable.image4,"#唱见舞见#暴走百货直播舞台"
//                    ,"养鸟少女",3855));
//            mDatas.add(new LiveItemBean(R.drawable.image4,"#唱见舞见#暴走百货直播舞台"
//                    ,"养鸟少女",3855));
//            adapter = new Live_Item_RecyclerViewAdapter(mContext,mDatas);
//            mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,2));
//            mRecyclerView.setAdapter(adapter);
//        }
    }


