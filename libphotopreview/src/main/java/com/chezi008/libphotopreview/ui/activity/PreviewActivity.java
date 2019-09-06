package com.chezi008.libphotopreview.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chezi008.libphotopreview.R;
import com.chezi008.libphotopreview.bean.PhotoBean;
import com.chezi008.libphotopreview.ui.fragment.PreviewFragment;

import java.util.ArrayList;

/**
 * - @description:预览界面
 * - @author:  chezi008/chezi008@qq.com
 * - @date:  2019/9/6 15:55
 */
public class PreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pp_activity_preview);

        Fragment fragment = buildAlbumFragment();
        fragment.setArguments(getIntent().getExtras());
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.clParent, fragment, "preview");
        ft.commit();
    }


    protected Fragment buildAlbumFragment() {
        PreviewFragment fragment = (PreviewFragment) getSupportFragmentManager().findFragmentByTag("preview");
        if (fragment == null) {
            fragment = new PreviewFragment();
        }
        return fragment;
    }


    public static void start(Context context, ArrayList<PhotoBean> data, int pos) {
        Intent starter = new Intent(context, PreviewActivity.class);
        starter.putParcelableArrayListExtra("data", data);
        starter.putExtra("pos", pos);
        context.startActivity(starter);
    }
}
