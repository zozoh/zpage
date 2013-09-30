package org.nutz.io;

import java.util.List;

/**
 * 封装了对于 ZPage 目录的操作，通过这个接口的不通实现，<br>
 * 可以将 ZPage 移植到特殊的文件系统甚至数据库上。
 * 
 * @author zozoh(zozohtnt@gmail.com)
 */
public interface ZDir {

    /**
     * @return 本目录下所有的文件
     */
    List<ZFile> ls();

    /**
     * 获取一个文件
     * 
     * @param path
     *            相对于本目录的路径
     * @return 文件对象，null 表示不存在
     */
    ZFile get(String path);

    /**
     * 获取一个文件，如果不存在就创建
     * 
     * @param path
     *            相对于本目录的路径
     * @return 文件对象
     */
    ZFile createIfNoExists(String path);

    /**
     * 遍历本目录内所包含的所有文件
     * 
     * @param walker
     *            遍历器
     */
    void walk(ZFWalker walker);

    /**
     * 清除本目录
     */
    void clear();

    /**
     * 删除本目录
     */
    void remove();

}
