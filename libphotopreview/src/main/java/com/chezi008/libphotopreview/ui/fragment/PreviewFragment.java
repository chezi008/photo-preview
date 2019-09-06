package com.chezi008.libphotopreview.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chezi008.libphotopreview.PhotoPagerHelper;
import com.chezi008.libphotopreview.R;
import com.chezi008.libphotopreview.bean.PhotoBean;
import com.chezi008.libphotopreview.ui.adapter.PreviewAdappter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：chezi008 on 2018/8/9 19:28
 * @description ：
 * @email ：chezi008@163.com
 */
public class PreviewFragment extends Fragment implements PhotoPagerHelper.PageHelperListener{

    private RecyclerView rcList;

    protected List<PhotoBean> mData = new ArrayList<>();
    private PreviewAdappter mAdappter;
    private PhotoPagerHelper taPagerHelper = new PhotoPagerHelper();
    private TextView ltAddDot;
    protected int position;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_album_preview, container, false);
        List<PhotoBean> list = getArguments().getParcelableArrayList("data");
        mData.addAll(list);
        position = getArguments().getInt("pos");

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcList = view.findViewById(R.id.rcList);

        mAdappter = new PreviewAdappter(mData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rcList.setLayoutManager(linearLayoutManager);
        rcList.setAdapter(mAdappter);
        rcList.scrollToPosition(position);

        taPagerHelper.setListener(this);
        taPagerHelper.attachToRecyclerView(rcList);

        ltAddDot = view.findViewById(R.id.ltAddDot);
        ltAddDot.setText(String.format("%s/%s",position+1,mData.size()));
    }


    @Override
    public void onPageChanged(int position) {
        //设置标题
        this.position = position;
        ltAddDot.setText(String.format("%s/%s",position+1,mData.size()));
    }
}
