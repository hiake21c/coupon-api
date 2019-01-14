package jongminkim.com.controller;

import jongminkim.com.barcode.BarcodeService;
import jongminkim.com.barcode.QRCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Slf4j
@Controller
public class CouponRenderController {

	@Autowired
	private BarcodeService barcodeService;

	@Autowired
	private QRCodeService qrCodeService;

	@GetMapping(value = "/coupon")
	public String rendering(@RequestParam String name
							,@RequestParam String price
							,@RequestParam String code
							, ModelMap modelMap) throws IOException {

		log.debug("Stat= coupon");
		modelMap.put("name", name);
		modelMap.put("price", price);
		modelMap.put("barcode", barcodeService.barcodeAsBase64(code));
		modelMap.put("qrCode", qrCodeService.qrCodeAsBase64(code));
		log.debug("End= coupon");
		return "coupon";
	}
}
