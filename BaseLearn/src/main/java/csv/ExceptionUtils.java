package csv;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author Hanz
 * @date 2020/6/30
 */
public final class ExceptionUtils {

    private ExceptionUtils() {

    }

    /**
     * 返回一个新的异常，统一构建，方便统一处理
     *
     * @param msg 消息
     * @param t   异常信息
     * @return 返回异常
     */
    public static BusinessException mpe(String msg, Throwable t, Object... params) {
        return new BusinessException(format(msg, params), t);
    }

    /**
     * 重载的方法
     *
     * @param msg 消息
     * @return 返回异常
     */
    public static BusinessException mpe(String msg, Object... params) {
        return new BusinessException(format(msg, params));
    }

    /**
     * 重载的方法
     *
     * @param t 异常
     * @return 返回异常
     */
    public static BusinessException mpe(Throwable t) {
        return new BusinessException(t);
    }

    /**
     * 安全的进行字符串 format
     *
     * @param target 目标字符串
     * @param params format 参数
     * @return format 后的
     */
    private static String format(String target, Object... params) {
        if (target != null && target.contains("%s") && ArrayUtils.isNotEmpty(params)) {
            return String.format(target, params);
        }
        return target;
    }
}