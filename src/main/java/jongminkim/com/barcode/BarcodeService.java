package jongminkim.com.barcode;

import jongminkim.com.config.BarcodeConfig;
import org.krysalis.barcode4j.impl.AbstractBarcodeBean;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class BarcodeService {

	public byte[] barcode(String code, BarcodeConfig barcode) throws IOException {
		AbstractBarcodeBean codeBean = new Code128Bean();

		final int dpi = barcode.getDpi();

		codeBean.setHeight(barcode.getHeight());
		codeBean.setBarHeight(barcode.getBarHeight());
		codeBean.setFontSize(barcode.getFontSize());
		codeBean.setModuleWidth(barcode.getModuleWidth());

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		BitmapCanvasProvider canvasProvider = new BitmapCanvasProvider(byteArrayOutputStream, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);
		codeBean.generateBarcode(canvasProvider, code);
		canvasProvider.finish();

		return byteArrayOutputStream.toByteArray();
	}

	public BufferedImage barcode(String code) throws IOException {
		byte[] bytes = this.barcode(code, BarcodeConfig.defaultConfig());

		try {
			return ImageIO.read(new ByteArrayInputStream(bytes));
		} catch (IOException e) {}

		return null;
	}

	public String barcodeAsBase64(String code) throws IOException {
		final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		BufferedImage bufferedImage = this.barcode(code);
		ImageIO.write(bufferedImage, "png", Base64.getEncoder().wrap(byteArrayOutputStream));
		return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
	}


}
