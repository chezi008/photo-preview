package com.chezi008.libphotopreview.ui.adapter;

import com.chezi008.libphotopreview.bean.PhotoBean;
import com.ibbhub.adapterdelegate.ListDelegationAdapter;

import java.util.List;

/**
 * @author ：chezi008 on 2018/8/9 19:33
 * @description ：
 * @email ：chezi008@163.com
 */
public class PreviewAdappter extends ListDelegationAdapter<List<PhotoBean>> {

    public PreviewAdappter(List<PhotoBean> data) {
        delegatesManager.addDelegate(new PreviewPhotoDelegate());
        delegatesManager.addDelegate(new PreviewVideoDelegate());
        setItems(data);
    }
}
