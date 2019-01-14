package jongminkim.com.config;

import lombok.Data;
import net.glxn.qrgen.core.image.ImageType;

@Data
public class QRCodeConfig {
    private int width;

    private int height;

    private ImageType imageType;

    public static QRCodeConfig defaultConfig() {
        QRCodeConfig qrConfig = new QRCodeConfig();
        qrConfig.setWidth(400);
        qrConfig.setHeight(400);
        qrConfig.setImageType(ImageType.JPG);
        return qrConfig;
    }
}