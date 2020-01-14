package bilibili.download.download_list;

import bilibili.api.AvApi;
import bilibili.api.EpApi;
import bilibili.api.SsApi;
import bilibili.api.model.av.new_video_url.AudioItem;
import bilibili.api.model.av.new_video_url.AvNewVideoUrl;
import bilibili.api.model.av.new_video_url.VideoItem;
import bilibili.api.model.av.old_video_url.AvOldVideoUrl;
import bilibili.api.model.common.VideoUrl;
import bilibili.api.model.common.video_detail.PagesItem;
import bilibili.api.model.common.video_detail.VideoDetail;
import bilibili.api.model.ep.initial_state.EpListItem;
import bilibili.api.model.ep.initial_state.InitialState;
import bilibili.api.model.ep.initial_state.SectionsItem;
import bilibili.api.model.ep.new_video_url.Dash;
import bilibili.api.model.ep.new_video_url.EpNewVideoUrl;
import bilibili.api.model.ep.old_video_url.DurlItem;
import bilibili.api.model.ep.old_video_url.EpOldVideoUrl;
import bilibili.data.BaseData;
import bilibili.download.download_list.download_item.DownloadItem;
import bilibili.download.download_list.download_item.VideoDownloadItem;
import bilibili.download.enums.DownloadType;
import bilibili.download.enums.VideoType;
import bilibili.util.CommonsUtils;
import util.FileUtils;
import util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 下载EP和SS视频
 */
public class VideoDownloadList {

    /**
     * 根据URL获取SS的下载链接
     *
     * @param url URL
     * @return SS的下载链接列表
     * @throws IOException #
     */
    public static List<DownloadItem> getSSDownloadList(String url) throws IOException {
        List<DownloadItem> list = new ArrayList<>();
        // 获取SS的ID
        String ssid = CommonsUtils.getPlayId(url, "ss");
        if (!StringUtils.isNotEmpty(ssid)) return new ArrayList<>();
        // 获取SS的信息
        InitialState initialState = SsApi.getSsInitialState(ssid);
        // 获取大标题
        String title = FileUtils.getPrettyFileName(initialState.getMediaInfo().getTitle());
        List<EpListItem> epList = initialState.getEpList();
        List<SectionsItem> sections = initialState.getSections();
        epItem(list, title, epList);
        for (SectionsItem section : sections) {
            epItem(list, title, section.getEpList());
        }
        return list;
    }

    /**
     * 解析EP和SS的列表
     *
     * @param list   封装到这个列表
     * @param title  大标题
     * @param epList EpList
     * @throws IOException #
     */
    private static void epItem(List<DownloadItem> list, String title, List<EpListItem> epList) throws IOException {
        for (EpListItem epListItem : epList) {
            VideoDownloadItem downloadItem = new VideoDownloadItem();
            downloadItem.downloadType = DownloadType.EP;
            // ====== 处理标题 ===========
            String fileName = FileUtils.getPrettyFileName(epListItem.getTitleFormat() + " " + epListItem.getLongTitle());
            downloadItem.title = fileName;
            File targetPath = new File(BaseData.path + title + File.separator + fileName + BaseData.VIDEO_EXTENSION);
            // 如果没有长标题，这个专辑可能是单P的
            if (!StringUtils.isNotEmpty(epListItem.getLongTitle())) {
                String name = FileUtils.getPrettyFileName(epListItem.getTitleFormat());
                downloadItem.title = name;
                targetPath = new File(BaseData.path + title + File.separator + name + BaseData.VIDEO_EXTENSION);
                if ("第0话".equalsIgnoreCase(epListItem.getTitleFormat()) ||
                        "正片".equalsIgnoreCase(epListItem.getTitleFormat())) {
                    downloadItem.title = title;
                    targetPath = new File(BaseData.path + title + BaseData.VIDEO_EXTENSION);
                }
            }
            downloadItem.outputFile = targetPath;
            downloadItem.aid = epListItem.getAid();
            downloadItem.cid = epListItem.getCid();
            downloadItem.epId = epListItem.getCid();
            VideoUrl videoUrl = SsApi.getVideoUrl(epListItem.getAid(), epListItem.getCid(), epListItem.getId());
            if (videoUrl == null) continue;
            // ================Dash流的视频=================
            if (videoUrl instanceof EpNewVideoUrl) {
                downloadItem.videoType = VideoType.DASH;
                EpNewVideoUrl epNewVideoUrl = (EpNewVideoUrl) videoUrl;
                Dash dash = epNewVideoUrl.getResult().getDash();
                if (dash == null) continue;
                if (dash.getVideo() == null || dash.getVideo().size() <= 0) continue;
                if (dash.getAudio() == null || dash.getAudio().size() <= 0) continue;
                downloadItem.videoUrl = dash.getVideo().get(0).getBaseUrl();
                downloadItem.audioUrl = dash.getAudio().get(0).getBaseUrl();
                downloadItem.videoBackUpUrls = dash.getVideo().get(0).getBackupUrl().toArray(new String[0]);
                downloadItem.audioBackUpUrls = dash.getAudio().get(0).getBackupUrl().toArray(new String[0]);
            }
            // =================FLV视频====================
            if (videoUrl instanceof EpOldVideoUrl) {
                downloadItem.videoType = VideoType.DURL;
                EpOldVideoUrl epOldVideoUrl = (EpOldVideoUrl) videoUrl;
                List<DurlItem> durl = epOldVideoUrl.getResult().getDurl();
                if (durl == null || durl.size() <= 0) continue;
                List<String> urls = new ArrayList<>();
                List<String[]> backUpUrls = new ArrayList<>();
                for (DurlItem durlItem : durl) {
                    urls.add(durlItem.getUrl());
                    backUpUrls.add(durlItem.getBackupUrl().toArray(new String[0]));
                }
                downloadItem.flvUrls = urls;
                downloadItem.flvBackUpUrls = backUpUrls;
            }
            list.add(downloadItem);
        }
    }

    /**
     * 根据URL获取EP的下载列表
     *
     * @param url URL
     * @return SS的下载链接列表
     * @throws IOException #
     */
    public static List<DownloadItem> getEPDownloadList(String url) throws IOException {
        List<DownloadItem> list = new ArrayList<>();
        // 获取Ep的ID
        String epid = CommonsUtils.getPlayId(url, "ep");
        if (!StringUtils.isNotEmpty(epid)) return new ArrayList<>();
        // 获取Ep的信息
        InitialState initialState = EpApi.getEpInitialState(epid);
        // 获取大标题
        String title = FileUtils.getPrettyFileName(initialState.getMediaInfo().getTitle());
        List<EpListItem> epList = initialState.getEpList();
        List<SectionsItem> sections = initialState.getSections();
        epItem(list, title, epList);
        for (SectionsItem section : sections) {
            epItem(list, title, section.getEpList());
        }
        return list;
    }

    /**
     * 获取AV的下载链接列表
     *
     * @param url AV的URL
     * @return 下载链接列表
     * @throws IOException #
     */
    public static List<DownloadItem> getAVDownloadList(String url) throws IOException {
        ArrayList<DownloadItem> list = new ArrayList<>();
        // AV号
        String aid = CommonsUtils.getPlayId(url, "av");
        if (!StringUtils.isNotEmpty(aid)) return new ArrayList<>();
        // 获取该AV号的详细信息,这个对象可以判断该视频是否是多P
        VideoDetail videoDetail = AvApi.getVideoDetail(aid);
        // 获取视频标题,并把它转换成可以作为文件名的字符串
        String title = FileUtils.getPrettyFileName(videoDetail.getData().getView().getTitle());
        // 获取视频Page列表
        List<PagesItem> pages = videoDetail.getData().getView().getPages();
        if (pages != null) {
            if (pages.size() > 1) { // ====多P=====
                for (int i = 0; i < pages.size(); i++) {
                    VideoDownloadItem downloadItem = new VideoDownloadItem();
                    String fileName = (i + 1) + "、" + FileUtils.getPrettyFileName(pages.get(i).getPart());
                    downloadItem.title = fileName;
                    downloadItem.outputFile = new File(BaseData.path + title + File.separator + fileName + BaseData.VIDEO_EXTENSION);
                    // 下载的目标路径
                    avItem(aid, pages.get(i), downloadItem);
                    list.add(downloadItem);
                }
            } else { // =====单P=====
                VideoDownloadItem downloadItem = new VideoDownloadItem();
                downloadItem.title = title;
                downloadItem.outputFile = new File(BaseData.path + title + BaseData.VIDEO_EXTENSION);
                avItem(aid, pages.get(0), downloadItem);
                list.add(downloadItem);
            }
        }
        return list;
    }

    /**
     * 执行下载操作
     *
     * @param aid  AV号
     * @param page 单P的信息
     * @throws IOException #
     */
    private static void avItem(String aid, PagesItem page, VideoDownloadItem downloadItem) throws IOException {
        downloadItem.aid = aid;
        downloadItem.page = page;
        downloadItem.downloadType = DownloadType.AV;
        VideoUrl videoUrl = AvApi.getVideoUrl(aid, page.getCid()); // 获取播放链接
        if (videoUrl != null) {
            // ===============Dash协议================
            if (videoUrl instanceof AvNewVideoUrl) {
                // 获取视频的Dash流
                bilibili.api.model.av.new_video_url.Dash dash = ((AvNewVideoUrl) videoUrl).getData().getDash();
                if (dash != null) {
                    downloadItem.videoType = VideoType.DASH;
                    // =============================下载视频文件============================
                    List<VideoItem> video = dash.getVideo();
                    if (video != null && video.size() > 0) {
                        VideoItem videoItem = video.get(0);
                        downloadItem.videoUrl = videoItem.getBaseUrl();
                        if (videoItem.getBackupUrl() != null) {
                            downloadItem.videoBackUpUrls = videoItem.getBackupUrl().toArray(new String[0]);
                        }
                    }
                    // ===============================下载音频文件===============================
                    List<AudioItem> audio = dash.getAudio();
                    if (audio != null && audio.size() > 0) {
                        AudioItem audioItem = audio.get(0);
                        downloadItem.audioUrl = audioItem.getBaseUrl();
                        if (audioItem.getBackupUrl() != null) {
                            downloadItem.audioBackUpUrls = audioItem.getBackupUrl().toArray(new String[0]);
                        }
                    }
                }
            }
            // ==================FLV==================
            if (videoUrl instanceof AvOldVideoUrl) {
                downloadItem.videoType = VideoType.DURL;
                List<bilibili.api.model.av.old_video_url.DurlItem> durl = ((AvOldVideoUrl) videoUrl).getData().getDurl();
                if (durl == null || durl.size() <= 0) return;
                List<String> urls = new ArrayList<>();
                List<String[]> backUpUrls = new ArrayList<>();
                for (bilibili.api.model.av.old_video_url.DurlItem durlItem : durl) {
                    urls.add(durlItem.getUrl());
                    if (durlItem.getBackupUrl() != null) {
                        backUpUrls.add(durlItem.getBackupUrl().toArray(new String[0]));
                    } else {
                        backUpUrls.add(null);
                    }
                }
                downloadItem.flvUrls = urls;
                downloadItem.flvBackUpUrls = backUpUrls;
            }
        }
    }

    /**
     * 更新下载项中的URL
     *
     * @param downloadItem 下载项
     */
    public static void refreshUrlOfItem(VideoDownloadItem downloadItem) throws IOException {
        if (downloadItem.downloadType == DownloadType.AV) {
            avItem(downloadItem.aid, downloadItem.page, downloadItem);
        } else if (downloadItem.downloadType == DownloadType.EP) {
            VideoUrl videoUrl = SsApi.getVideoUrl(downloadItem.aid, downloadItem.cid, downloadItem.epId);
            if (videoUrl == null) return;
            // ================Dash流的视频=================
            if (videoUrl instanceof EpNewVideoUrl) {
                downloadItem.videoType = VideoType.DASH;
                EpNewVideoUrl epNewVideoUrl = (EpNewVideoUrl) videoUrl;
                Dash dash = epNewVideoUrl.getResult().getDash();
                if (dash == null) return;
                if (dash.getVideo() == null || dash.getVideo().size() <= 0) return;
                if (dash.getAudio() == null || dash.getAudio().size() <= 0) return;
                downloadItem.videoUrl = dash.getVideo().get(0).getBaseUrl();
                downloadItem.audioUrl = dash.getAudio().get(0).getBaseUrl();
                downloadItem.videoBackUpUrls = dash.getVideo().get(0).getBackupUrl().toArray(new String[0]);
                downloadItem.audioBackUpUrls = dash.getAudio().get(0).getBackupUrl().toArray(new String[0]);
            }
            // =================FLV视频====================
            if (videoUrl instanceof EpOldVideoUrl) {
                downloadItem.videoType = VideoType.DURL;
                EpOldVideoUrl epOldVideoUrl = (EpOldVideoUrl) videoUrl;
                List<DurlItem> durl = epOldVideoUrl.getResult().getDurl();
                if (durl == null || durl.size() <= 0) return;
                List<String> urls = new ArrayList<>();
                List<String[]> backUpUrls = new ArrayList<>();
                for (DurlItem durlItem : durl) {
                    urls.add(durlItem.getUrl());
                    backUpUrls.add(durlItem.getBackupUrl().toArray(new String[0]));
                }
                downloadItem.flvUrls = urls;
                downloadItem.flvBackUpUrls = backUpUrls;
            }
        } else {
            throw new IllegalStateException("无法更新URL信息");
        }
    }
}
