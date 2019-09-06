package com.chezi008.libphotopreview.listener;

import android.widget.ImageView;

/**
 * - @description:
 * - @author:  chezi008/chezi008@qq.com
 * - @date:  2019/9/6 15:39
 */
public interface GlideListener {
    /**
     * 加载本地图片
     *
     * @param imageView
     * @param path
     */
    void loadLocalImage(ImageView imageView, String path);
}
