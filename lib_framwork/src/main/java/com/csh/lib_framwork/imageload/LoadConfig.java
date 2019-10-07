package com.csh.lib_framwork.imageload;

/**
 * @author chenshanghui
 * @intro
 * @date 2019/7/26
 */
public class LoadConfig {


    private String url;
    private int radius;
    private boolean isCircle;

    public LoadConfig(Builder builder) {
        this.url = builder.url;
        this.radius = builder.radius;
        this.isCircle = builder.isCircle;
    }

    public boolean isCircle() {
        return isCircle;
    }

    public String getUrl() {
        return url;
    }

    public int getRadius() {
        return radius;
    }

    public static class Builder {

        String url;
        int radius = -1;
        boolean isCircle;


        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setRadius(int radius) {
            this.radius = radius;
            return this;
        }

        public Builder setCircle(boolean b) {
            this.isCircle = b;
            return this;
        }


        public LoadConfig build() {
            return new LoadConfig(this);
        }
    }

}
