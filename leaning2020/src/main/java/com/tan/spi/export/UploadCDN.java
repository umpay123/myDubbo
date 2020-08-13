package com.tan.spi.export;

import org.apache.dubbo.common.extension.SPI;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/08/13/14:34
 * @Description:
 */
@SPI
public interface UploadCDN {
    void upload(String url);
}
