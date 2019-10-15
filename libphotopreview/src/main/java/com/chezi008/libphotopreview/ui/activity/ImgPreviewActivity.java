package com.chezi008.libphotopreview.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.chezi008.libphotopreview.R;
import com.chezi008.libphotopreview.manager.PreviewListenerManager;
import com.github.chrisbanes.photoview.PhotoView;

/**
 *  -description:  单独图片预览页
 *  -author: created by tang on 2019/10/15 15:13
 */
public class ImgPreviewActivity extends AppCompatActivity {

    private PhotoView mPhotoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //不显示程序的标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //不显示系统的标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_img_preview);

        mPhotoView = findViewById(R.id.img_pre);

        String url = getIntent().getStringExtra("url");
        if (PreviewListenerManager.getInstance().glideListener != null) {
            PreviewListenerManager.getInstance().glideListener.loadLocalImage(mPhotoView, url);
        }
    }

    /**
     * @param context 上下文
     * @param imgUrl 图片地址
     */
    public static void start(Context context, String imgUrl) {
        Intent starter = new Intent(context, ImgPreviewActivity.class);
        starter.putExtra("url", imgUrl);
        context.startActivity(starter);
    }
}
