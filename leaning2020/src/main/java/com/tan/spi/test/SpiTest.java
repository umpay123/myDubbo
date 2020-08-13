package com.tan.spi.test;

import com.tan.spi.export.UploadCDN;

import java.util.ServiceLoader;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/08/13/14:38
 * @Description:
 */
public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<UploadCDN> uploadCDNS = ServiceLoader.load(UploadCDN.class);
        for (UploadCDN u : uploadCDNS){
            u.upload("sss");
        }
    }
}
