package util.download;

/**
 * 下载异常
 * 2019年7月13日
 */
class DownloadException extends Exception {

    DownloadException() {
        super();
    }

    DownloadException(String message) {
        super(message);
    }

    DownloadException(String message, Throwable cause) {
        super(message, cause);
    }

    DownloadException(Throwable cause) {
        super(cause);
    }

    DownloadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
