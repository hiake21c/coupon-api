package jongminkim.com.phantomjs;

import jongminkim.com.config.CaptureConfig;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhantomDriverTest {

	@Autowired
	private PhantomDriver ghostDriver;

	@Test
	public void captureTest() throws IOException {
		BufferedImage capturedImage = ghostDriver.getScreenshotAsBufferedImage("http://www.naver.com/");

		ImageIO.write(capturedImage, "png", new File("/Users/jongminkim/Desktop/naver.png"));
	}

	//서버 띄워놓고 테스트 할것
	@Test
	public void captureCouponImage() throws IOException {
		CaptureConfig captureConfig = new CaptureConfig();
		captureConfig.setWidth(350);
		captureConfig.setHeight(620);

		String randomString = RandomStringUtils.randomAlphabetic(7);
		BufferedImage jognminKim = ghostDriver.getScreenshotAsBufferedImage("http://localhost:8080/coupon?name=Jongmin Kim&price=100&code=" + randomString, captureConfig);
		ImageIO.write(jognminKim, "png", new File("/Users/jongminkim/Desktop/jongmin.png"));

		randomString = RandomStringUtils.randomAlphabetic(7);
		BufferedImage ria = ghostDriver.getScreenshotAsBufferedImage("http://localhost:8080/coupon?name=Ria YU&price=500&code=" + randomString, captureConfig);
		ImageIO.write(ria, "png", new File("/Users/jongminkim/Desktop/ria.png"));

		randomString = RandomStringUtils.randomAlphabetic(7);
		BufferedImage sorang = ghostDriver.getScreenshotAsBufferedImage("http://localhost:8080/coupon?name=Sorang&price=500&code=" + randomString, captureConfig);
		ImageIO.write(sorang, "png", new File("/Users/jongminkim/Desktop/sorang.png"));
	}
}