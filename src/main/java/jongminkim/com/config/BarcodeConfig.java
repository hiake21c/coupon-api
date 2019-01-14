package jongminkim.com.config;

import lombok.Data;
import org.krysalis.barcode4j.tools.UnitConv;

@Data
public class BarcodeConfig {

    private int dpi;

    private double height;

    private double barHeight;

    private double fontSize;

    private double moduleWidth;



    public static BarcodeConfig defaultConfig() {
        BarcodeConfig barcode = new BarcodeConfig();
        barcode.setDpi(300);
        barcode.setBarHeight(40);
        barcode.setHeight(64);
        barcode.setFontSize(1.6);
        barcode.setModuleWidth(UnitConv.in2mm(8.0f / barcode.getDpi()));
        return barcode;
    }
}