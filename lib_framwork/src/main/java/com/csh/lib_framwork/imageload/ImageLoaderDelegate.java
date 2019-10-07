package com.csh.lib_framwork.imageload;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/**
 * @author chenshanghui
 * @intro
 * @date 2019/7/26
 */
public class ImageLoaderDelegate {

    public static final ImageLoaderDelegate INSTANCE = new ImageLoaderDelegate();

    public static ImageLoaderDelegate getInstance() {
        return INSTANCE;
    }

    public void loadImage(ImageView iv, LoadConfig config) {
        RequestBuilder builder = Glide.with(iv.getContext())
                .load(config.getUrl());
        if (config.isCircle()) {
            builder.apply(RequestOptions.bitmapTransform(new CircleCrop()));
        } else {
            if (config.getRadius() > 0) {
                RoundedCorners roundedCorners = new RoundedCorners(config.getRadius());
                RequestOptions options = new RequestOptions().transform(new MultiTransformation(new CenterCrop(),roundedCorners));
                builder.apply(options);
            }
        }
        builder.into(iv);
    }

}
