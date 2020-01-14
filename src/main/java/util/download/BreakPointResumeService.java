package util.download;

import java.io.*;
import java.util.TreeMap;

import static util.download.Commons.mkdirs;

/**
 * 断点续传服务
 * 2019年7月13日
 */
class BreakPointResumeService {

    /**
     * 下载的链接地址，用来标识唯一的文件
     */
    private String url;

    /**
     * 用来记录断点的Map
     * key: start  value: end
     */
    private TreeMap<Long, Long> breakPoint;

    /**
     * 私有化该构造器仅供类的内部使用
     */
    private BreakPointResumeService() {
    }

    /**
     * 创建一个断点信息
     *
     * @param breakPoint 断点Map
     */
    BreakPointResumeService(String url, TreeMap<Long, Long> breakPoint) {
        if (url == null || breakPoint == null || breakPoint.size() <= 0) return;
        this.url = url;
        this.breakPoint = breakPoint;
    }

    /**
     * 从临时文件中读取断点数据 OK
     */
    synchronized static BreakPointResumeService readBreakPointInfo(File breakPointFile) {
        if (breakPointFile == null || !breakPointFile.exists()) return null;
        try (DataInputStream dataInputStream =
                     new DataInputStream(new FileInputStream(breakPointFile))) {
            BreakPointResumeService breakPointResumeService = new BreakPointResumeService();
            // 读取URL
            breakPointResumeService.url = dataInputStream.readUTF();
            // 读取断点的数量
            int breakPointNum = dataInputStream.readInt();
            // 读取所有断点
            TreeMap<Long, Long> breakPoint = new TreeMap<>();
            for (int i = 0; i < breakPointNum; i++) {
                breakPoint.put(dataInputStream.readLong(), dataInputStream.readLong());
            }
            breakPointResumeService.breakPoint = breakPoint;
            return breakPointResumeService;
        } catch (IOException e) {
            return null;
        }
    }

    String getUrl() {
        return url;
    }

    TreeMap<Long, Long> getBreakPoint() {
        return breakPoint;
    }

    /**
     * 将断点数据保存在临时文件中
     *
     * @param breakPointFile 临时文件的位置
     */
    void writeBreakPointInfo(File breakPointFile) {
        if (breakPointFile == null || breakPoint == null || breakPoint.size() == 0) return;
        // 这个锁之前为了应对静态方法使用，现在已经没有啥用了
        synchronized (BreakPointResumeService.class) {
            mkdirs(breakPointFile); // 如果文件夹不存在，创建
            try (DataOutputStream dataOutputStream =
                         new DataOutputStream(new FileOutputStream(breakPointFile))) {
                dataOutputStream.writeUTF(url);
                dataOutputStream.writeInt(breakPoint.size());
                breakPoint.forEach((start, end) -> {
                    try {
                        dataOutputStream.writeLong(start);
                        dataOutputStream.writeLong(end);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (IOException ignored) {
            }
        }
    }
}