package bilibili.api.model.ep.initial_state;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class InitialState {

    @JSONField(name = "sponsor")
    private Sponsor sponsor;

    @JSONField(name = "ver")
    private Ver ver;

    @JSONField(name = "ssList")
    private List<SsListItem> ssList;

    @JSONField(name = "ssPayMent")
    private Object ssPayMent;

    @JSONField(name = "epList")
    private List<EpListItem> epList;

    @JSONField(name = "sections")
    private List<SectionsItem> sections;

    @JSONField(name = "loaded")
    private String loaded;

    @JSONField(name = "epPayMent")
    private Object epPayMent;

    @JSONField(name = "ssRecom")
    private List<Object> ssRecom;

    @JSONField(name = "ssr")
    private Ssr ssr;

    @JSONField(name = "userState")
    private UserState userState;

    @JSONField(name = "loginInfo")
    private LoginInfo loginInfo;

    @JSONField(name = "insertScripts")
    private List<String> insertScripts;

    @JSONField(name = "h1Title")
    private String h1Title;

    @JSONField(name = "mediaInfo")
    private MediaInfo mediaInfo;

    @JSONField(name = "epInfo")
    private EpInfo epInfo;

    @JSONField(name = "player")
    private Player player;

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public Ver getVer() {
        return ver;
    }

    public void setVer(Ver ver) {
        this.ver = ver;
    }

    public List<SsListItem> getSsList() {
        return ssList;
    }

    public void setSsList(List<SsListItem> ssList) {
        this.ssList = ssList;
    }

    public Object getSsPayMent() {
        return ssPayMent;
    }

    public void setSsPayMent(Object ssPayMent) {
        this.ssPayMent = ssPayMent;
    }

    public List<EpListItem> getEpList() {
        return epList;
    }

    public void setEpList(List<EpListItem> epList) {
        this.epList = epList;
    }

    public List<SectionsItem> getSections() {
        return sections;
    }

    public void setSections(List<SectionsItem> sections) {
        this.sections = sections;
    }

    public void setLoaded(String loaded) {
        this.loaded = loaded;
    }

    public String isLoaded() {
        return loaded;
    }

    public Object getEpPayMent() {
        return epPayMent;
    }

    public void setEpPayMent(Object epPayMent) {
        this.epPayMent = epPayMent;
    }

    public List<Object> getSsRecom() {
        return ssRecom;
    }

    public void setSsRecom(List<Object> ssRecom) {
        this.ssRecom = ssRecom;
    }

    public Ssr getSsr() {
        return ssr;
    }

    public void setSsr(Ssr ssr) {
        this.ssr = ssr;
    }

    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public List<String> getInsertScripts() {
        return insertScripts;
    }

    public void setInsertScripts(List<String> insertScripts) {
        this.insertScripts = insertScripts;
    }

    public String getH1Title() {
        return h1Title;
    }

    public void setH1Title(String h1Title) {
        this.h1Title = h1Title;
    }

    public MediaInfo getMediaInfo() {
        return mediaInfo;
    }

    public void setMediaInfo(MediaInfo mediaInfo) {
        this.mediaInfo = mediaInfo;
    }

    public EpInfo getEpInfo() {
        return epInfo;
    }

    public void setEpInfo(EpInfo epInfo) {
        this.epInfo = epInfo;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return
                "InitialState{" +
                        "sponsor = '" + sponsor + '\'' +
                        ",ver = '" + ver + '\'' +
                        ",ssList = '" + ssList + '\'' +
                        ",ssPayMent = '" + ssPayMent + '\'' +
                        ",epList = '" + epList + '\'' +
                        ",sections = '" + sections + '\'' +
                        ",loaded = '" + loaded + '\'' +
                        ",epPayMent = '" + epPayMent + '\'' +
                        ",ssRecom = '" + ssRecom + '\'' +
                        ",ssr = '" + ssr + '\'' +
                        ",userState = '" + userState + '\'' +
                        ",loginInfo = '" + loginInfo + '\'' +
                        ",insertScripts = '" + insertScripts + '\'' +
                        ",h1Title = '" + h1Title + '\'' +
                        ",mediaInfo = '" + mediaInfo + '\'' +
                        ",epInfo = '" + epInfo + '\'' +
                        ",player = '" + player + '\'' +
                        "}";
    }
}