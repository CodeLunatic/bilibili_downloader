package bilibili.api.model.av.new_video_url;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Dash {

    @JSONField(name = "duration")
    private String duration;

    @JSONField(name = "minBufferTime")
    private String minBufferTime;

    @JSONField(name = "video")
    private List<VideoItem> video;

    @JSONField(name = "audio")
    private List<AudioItem> audio;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getMinBufferTime() {
        return minBufferTime;
    }

    public void setMinBufferTime(String minBufferTime) {
        this.minBufferTime = minBufferTime;
    }

    public List<VideoItem> getVideo() {
        return video;
    }

    public void setVideo(List<VideoItem> video) {
        this.video = video;
    }

    public List<AudioItem> getAudio() {
        return audio;
    }

    public void setAudio(List<AudioItem> audio) {
        this.audio = audio;
    }
}