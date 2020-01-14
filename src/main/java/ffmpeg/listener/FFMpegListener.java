package ffmpeg.listener;

/**
 * FFMpeg的回调
 *
 * @author CY
 */
public abstract class FFMpegListener {

    /**
     * 开始进行 2019年7月11日
     */
    public void start() {
    }

    /**
     * 命令行打印信息回调
     *
     * @param line 打印信息
     */
    public void commandLine(String line) {
    }

    /**
     * 执行完成回调
     */
    public abstract void over();
}