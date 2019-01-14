package jongminkim.com.barcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QRCodeServiceTest {


    @Autowired
    private QRCodeService qrCodeService;

    @Test
    public void qrCodeTest() throws IOException, InterruptedException {
        BufferedImage barcode = qrCodeService.qrCode("Jongmin Kim");

        ImageIO.write(barcode, "png", new File("/Users/jongminkim/Desktop/qrcode.png"));
    }
}