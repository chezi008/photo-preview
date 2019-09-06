package com.chezi008.libphotopreview.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chezi008.libphotopreview.R;
import com.chezi008.libphotopreview.bean.PhotoBean;
import com.chezi008.libphotopreview.manager.PreviewListenerManager;
import com.github.chrisbanes.photoview.PhotoView;
import com.ibbhub.adapterdelegate.AdapterDelegate;

import java.util.List;

/**
 * @author ：chezi008 on 2018/8/9 19:34
 * @description ：
 * @email ：chezi008@163.com
 */
class PreviewPhotoDelegate extends AdapterDelegate<List<PhotoBean>> {
    private String TAG = getClass().getSimpleName();

    @Override
    public boolean isForViewType(@NonNull List<PhotoBean> items, int position) {
        return isImageFile(items.get(position).path);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_preview_photo, parent, false);
        return new PreviewPhotoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull List<PhotoBean> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        PhotoBean mb = items.get(position);
        if (PreviewListenerManager.getInstance().glideListener != null) {
            PreviewListenerManager.getInstance().glideListener.loadLocalImage(((PreviewPhotoHolder) holder).ptView, mb.path);
        }
    }

    static class PreviewPhotoHolder extends RecyclerView.ViewHolder {
        private PhotoView ptView;

        public PreviewPhotoHolder(View itemView) {
            super(itemView);
            ptView = itemView.findViewById(R.id.ptView);
        }
    }

    public static boolean isImageFile(String fName) {
        boolean re;
        String end = fName
                .substring(fName.lastIndexOf(".") + 1, fName.length())
                .toLowerCase();
        if (end.equals("jpg") || end.equals("gif") || end.equals("png")
                || end.equals("jpeg") || end.equals("bmp")) {
            re = true;
        } else {
            re = false;
        }
        return re;
    }
}
