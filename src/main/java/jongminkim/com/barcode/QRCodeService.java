package jongminkim.com.barcode;

import jongminkim.com.config.QRCodeConfig;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class QRCodeService {

    //QR코드 생성
    public byte[] qrCode(String code, QRCodeConfig qrCodeConfig) {
        return QRCode.from(code)
                .withSize(qrCodeConfig.getWidth()
                          ,qrCodeConfig.getHeight())
                .to(qrCodeConfig.getImageType())
                .stream()
                .toByteArray();
    }

    //이미지 읽어서 바이트로 담아 이미지IO에 담음
    public BufferedImage qrCode(String code)  {

        byte[] bytes = this.qrCode(code, QRCodeConfig.defaultConfig());

        try {
            return ImageIO.read(new ByteArrayInputStream(bytes));
        } catch (IOException e) {}

        return null;
    }

    public String qrCodeAsBase64(String code) throws IOException {

        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        BufferedImage bufferedImage = this.qrCode(code);

        ImageIO.write(bufferedImage, "png", Base64.getEncoder().wrap(byteArrayOutputStream));
        return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
    }
}
