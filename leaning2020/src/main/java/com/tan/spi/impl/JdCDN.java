package com.tan.spi.impl;

import com.tan.spi.export.UploadCDN;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/08/13/14:36
 * @Description:
 */
public class JdCDN implements UploadCDN {
    @Override
    public void upload(String url) {
        System.out.println("upload to jd cdn!");
    }
}
