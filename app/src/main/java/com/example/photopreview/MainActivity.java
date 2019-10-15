package com.example.photopreview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chezi008.libphotopreview.listener.EventListener;
import com.chezi008.libphotopreview.listener.GlideListener;
import com.chezi008.libphotopreview.manager.PreviewListenerManager;
import com.chezi008.libphotopreview.ui.activity.ImgPreviewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btnPreview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String path = Environment.getExternalStorageDirectory().getPath() + "/netsee/18153817222/photo/";
//                Log.d("MainActivity", "onClick: "+path);
//                File pFile = new File(path);
//                ArrayList<PhotoBean> arrayList = new ArrayList();
//                for (File file :
//                        pFile.listFiles()) {
//                    PhotoBean photoBean = new PhotoBean(file.getPath());
//                    arrayList.add(photoBean);
//                }
//                PreviewActivity.start(MainActivity.this, arrayList, 1);

                ImgPreviewActivity.start(MainActivity.this, "http://i1.sinaimg.cn/ent/d/2008-06-04/U105P28T3D2048907F326DT20080604225106.jpg");
            }
        });
        PreviewListenerManager.getInstance().glideListener = new GlideListener() {
            @Override
            public void loadLocalImage(ImageView imageView, String path) {
                Glide.with(imageView).load(path).into(imageView);
            }
        };
        PreviewListenerManager.getInstance().eventListener = new EventListener() {
            @Override
            public void onVideoPlayClick(String path) {
                Toast.makeText(MainActivity.this, "click0", Toast.LENGTH_SHORT).show();
            }
        };
    }
}
