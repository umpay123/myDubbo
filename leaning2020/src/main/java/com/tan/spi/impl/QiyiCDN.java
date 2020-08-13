package com.tan.spi.impl;

import com.tan.spi.export.UploadCDN;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/08/13/14:35
 * @Description:
 */
public class QiyiCDN implements UploadCDN {
    @Override
    public void upload(String url) {
        System.out.println("upload to qiyi cdn!");
    }
}
