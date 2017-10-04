package com.helix.admin.fragmentviewpager.retrofitdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HaiLS on 17/09/2017.
 */

public class VideoDetails {
    @SerializedName("duration")
    private String duration;
    @SerializedName("dimension")
    private String dimension;
    @SerializedName("definition")
    private String definition;
    @SerializedName("caption")
    private String caption;
    @SerializedName("licensedContent")
    private boolean licensedContent;
    @SerializedName("projection")
    private String projection;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public boolean isLicensedContent() {
        return licensedContent;
    }

    public void setLicensedContent(boolean licensedContent) {
        this.licensedContent = licensedContent;
    }

    public String getProjection() {
        return projection;
    }

    public void setProjection(String projection) {
        this.projection = projection;
    }

    @Override
    public String toString() {
        return "VideoDetails{" +
                "duration='" + duration + '\'' +
                ", dimension='" + dimension + '\'' +
                ", definition='" + definition + '\'' +
                ", caption='" + caption + '\'' +
                ", licensedContent='" + licensedContent + '\'' +
                ", projection='" + projection + '\'' +
                '}';
    }
}
