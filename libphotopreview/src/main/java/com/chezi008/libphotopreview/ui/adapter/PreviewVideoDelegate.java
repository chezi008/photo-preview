package com.chezi008.libphotopreview.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chezi008.libphotopreview.R;
import com.chezi008.libphotopreview.bean.PhotoBean;
import com.chezi008.libphotopreview.manager.PreviewListenerManager;
import com.ibbhub.adapterdelegate.AdapterDelegate;

import java.util.List;

/**
 * @author ：chezi008 on 2018/8/9 19:41
 * @description ：
 * @email ：chezi008@163.com
 */
class PreviewVideoDelegate extends AdapterDelegate<List<PhotoBean>> {
    @Override
    public boolean isForViewType(@NonNull List<PhotoBean> items, int position) {
        return items.get(position).path.endsWith(".mp4");
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pp_item_preview_video, parent, false);
        return new PreviewVideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull List<PhotoBean> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        final PreviewVideoHolder pHolder = (PreviewVideoHolder) holder;
        final PhotoBean mb = items.get(position);
        //thumb
        if (PreviewListenerManager.getInstance().glideListener != null) {
            PreviewListenerManager.getInstance().glideListener.loadLocalImage(pHolder.ivPhoto, mb.path);
        }
        pHolder.ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PreviewListenerManager.getInstance().glideListener != null) {
                    PreviewListenerManager.getInstance().eventListener.onVideoPlayClick(mb.path);
                }
            }
        });
    }

    static class PreviewVideoHolder extends RecyclerView.ViewHolder {
        public ImageView ivPhoto;
        public ImageView ivPlay;

        public PreviewVideoHolder(View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.ivPhoto);
            ivPlay = itemView.findViewById(R.id.ivPlay);
        }
    }
}
