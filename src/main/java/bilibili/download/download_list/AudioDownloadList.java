package bilibili.download.download_list;

import bilibili.api.AmApi;
import bilibili.api.AuApi;
import bilibili.api.model.am.album_info.AlbumInfo;
import bilibili.api.model.am.album_list.AlbumList;
import bilibili.api.model.am.album_list.DataItem;
import bilibili.api.model.au.music_detail.Data;
import bilibili.api.model.au.music_detail.MusicDetail;
import bilibili.api.model.au.music_url.MusicUrl;
import bilibili.data.BaseData;
import bilibili.download.download_list.download_item.AudioDownloadItem;
import bilibili.download.download_list.download_item.DownloadItem;
import bilibili.util.CommonsUtils;
import util.FileUtils;
import util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AudioDownloadList {

    // ===============================音乐=======================================
    public static List<DownloadItem> getAUDownloadList(String url) throws IOException {
        List<DownloadItem> list = new ArrayList<>();
        String sid = CommonsUtils.getPlayId(url, "au");
        if (!StringUtils.isNotEmpty(sid)) return new ArrayList<>();
        list.add(auItem(sid, null));
        return list;
    }

    // ===============================音乐专辑=======================================
    public static List<DownloadItem> getAMDownloadList(String url) throws IOException {
        List<DownloadItem> list = new ArrayList<>();
        String amId = CommonsUtils.getPlayId(url, "am");
        AlbumInfo albumInfo = AmApi.getAlbumInfo(amId);
        String album_title = FileUtils.getPrettyFileName(albumInfo.getData().getTitle());
        AlbumList albumList = AmApi.getAlbumList(amId);
        List<DataItem> data = albumList.getData().getData();
        for (DataItem dataItem : data) {
            DownloadItem downloadItem = auItem(dataItem.getId(), album_title);
            if (downloadItem != null) {
                list.add(downloadItem);
            }
        }
        return list;
    }

    /**
     * 单个音频项
     *
     * @param sid         音频的ID
     * @param album_title 专辑的标题
     * @return 音频的下载地址等重要信息
     * @throws IOException #
     */
    private static DownloadItem auItem(String sid, String album_title) throws IOException {
        AudioDownloadItem auDownloadItem = new AudioDownloadItem();
        // 获取音乐的详情信息
        MusicDetail musicDetail = AuApi.getMusicDetail(sid);
        Data data = musicDetail.getData();
        if (data == null) {
            System.err.println("该音频不存在或已被下架");
            return null;
        }
        // 获取音乐的标题
        String title = FileUtils.getPrettyFileName(data.getTitle());
        auDownloadItem.title = title;
        auDownloadItem.sid = sid;
        // 获取音乐的播放链接
        MusicUrl musicUrl = AuApi.getMusicUrl(sid);
        // 获取音乐所在的CDN
        List<String> cdns = musicUrl.getData().getCdns();
        auDownloadItem.audioUrl = cdns.toArray(new String[0]);
        // 音乐要保存到的目标位置
        auDownloadItem.musicOutputFile = new File(BaseData.path + album_title + File.separator + title + BaseData.AUDIO_EXTENSION);
        if (album_title == null) {
            auDownloadItem.musicOutputFile = new File(BaseData.path + title + BaseData.AUDIO_EXTENSION);
        }
        // 下载歌词
        if (BaseData.isDownloadLrc) {
            String lyricUrl = musicDetail.getData().getLyric();
            auDownloadItem.lrcUrl = lyricUrl;
            if (StringUtils.isNotEmpty(lyricUrl)) {
                auDownloadItem.lrcOutputFile = new File(BaseData.path + album_title + File.separator + title + BaseData.LYRIC_EXTENSION);
                if (album_title == null) {
                    auDownloadItem.lrcOutputFile = new File(BaseData.path + title + BaseData.LYRIC_EXTENSION);
                }
            }
        }
        return auDownloadItem;
    }


    /**
     * 更新下载项中的URL
     *
     * @param downloadItem 下载项
     */
    public static void refreshUrlOfItem(AudioDownloadItem downloadItem) throws IOException {
        // 获取音乐的播放链接
        MusicUrl musicUrl = AuApi.getMusicUrl(downloadItem.sid);
        // 获取音乐所在的CDN
        List<String> cdns = musicUrl.getData().getCdns();
        downloadItem.audioUrl = cdns.toArray(new String[0]);
    }
}
