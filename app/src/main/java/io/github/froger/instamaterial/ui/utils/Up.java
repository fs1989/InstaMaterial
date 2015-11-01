package io.github.froger.instamaterial.ui.utils;

import java.io.File;

import main.java.com.UpYun;

/**
 * Created by Dan on 2015-10-28.
 * <p/>
 *
 * 上传文件:
 * public boolean writeFile(String filePath, String datas, boolean auto);
 * public boolean writeFile(String filePath, File file, boolean auto);
 * public boolean writeFile(String filePath, byte[] datas, boolean auto);
 * 参数说明：
 * filePath：保存到又拍云存储的文件路径，以/开始
 * 第二个参数：接受String、File和byte[]三种类型的数据
 * auto（可选）：若为true则自动创建父级目录（只支持自动创建10级以内的父级目录）
 *
 * 下载文件
 * public String readFile(String filePath);
 * public boolean readFile(String filePath, File file);
 * boolean result = yun.readFile(remoteFilePath, file);
 * 参数说明：
 * filePath：文件在又拍云存储中的路径
 * file：本地临时文件（用来保存下载下来的数据）
 *
 * 删除文件
 * public boolean deleteFile(String filePath);
 * 参数说明：
 * filePath：文件在又拍云的路径
 *
 * String filePath = "/path/to/file";
 * // 删除文件
 * boolean result = upyun.deleteFile(filePath);
 *
 *
 */

public class Up {

     public static UpYun yun;

    public Up() {
        yun = new UpYun("fs1989", "farseer1989", "Fs1234567890");
    }

}
