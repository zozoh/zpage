package org.nutz.zpage;

import org.nutz.io.ZDir;

/**
 * 这个接口封装了 ZPage 相对于一个工作目录的各种操作
 * 
 * @author zozoh(zozohtnt@gmail.com)
 */
public interface ZPageApi {

    /**
     * 将本工作目录的内容输出到一个目标目录
     * 
     * @param dest
     *            目标目录
     */
    void outputTo(ZDir dest);

    /**
     * 切换到一个新的工作目录
     * 
     * @param home
     *            工作目录
     */
    void switchTo(ZDir home);

    /**
     * @return 配置信息
     */
    ZPageConfig getConfig();

}
