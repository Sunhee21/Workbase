package com.csh.lib_framwork.imageload;

import android.widget.ImageView;

/**
 * @author sunhee
 * @intro
 * @date 2019/7/25
 */
public class ImageLoader {


    public static void loadImage(ImageView iv, LoadConfig config){
        ImageLoaderDelegate.getInstance().loadImage(iv,config);
    }


}
