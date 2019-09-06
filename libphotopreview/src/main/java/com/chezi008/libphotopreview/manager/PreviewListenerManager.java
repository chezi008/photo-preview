package com.chezi008.libphotopreview.manager;

import com.chezi008.libphotopreview.listener.GlideListener;

/**
 * - @description:
 * - @author:  chezi008/chezi008@qq.com
 * - @date:  2019/9/6 15:39
 */
public class PreviewListenerManager {

    private PreviewListenerManager() {

    }

    public static PreviewListenerManager getInstance() {
        return PreviewListenerManagerHolder.intance;
    }

    static class PreviewListenerManagerHolder {
        private final static PreviewListenerManager intance = new PreviewListenerManager();
    }

    public GlideListener glideListener;
}
