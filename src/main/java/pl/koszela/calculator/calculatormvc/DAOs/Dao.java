package pl.koszela.calculator.calculatormvc.DAOs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koszela.calculator.calculatormvc.HasLogger;
import pl.koszela.calculator.calculatormvc.ServiceAccessories;
import pl.koszela.calculator.calculatormvc.model.Accessories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Service
public class Dao implements HasLogger {

    private NameFromURL nameFromURL = new NameFromURL();

    private ServiceAccessories serviceAccessories;

    @Autowired
    public Dao(ServiceAccessories serviceAccessories) {
        this.serviceAccessories = Objects.requireNonNull(serviceAccessories);
    }

    public void readAndSaveToORMTest(String filePath) {
        String line = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");

                Accessories accessories = new Accessories();

                accessories.setName(string(data, 1));
                accessories.setUnitDetalPrice(Double.valueOf(string(data, 2)));
                accessories.setCategory(string(data, 3));
                accessories.setSize(string(data, 4));
                accessories.setType(string(data, 9));
                accessories.setQuantity(0d);
                accessories.setDiscount(0);
                accessories.setBasicDiscount(67);
                accessories.setAdditionalDiscount(0);
                accessories.setPromotionDiscount(0);
                accessories.setSkontoDiscount(0);
                accessories.setManufacturer(nameFromURL.getName(filePath));
                accessories.setUnitPurchasePrice(calculatePurchasePrice(accessories));

                serviceAccessories.addAccesories(accessories);
            }
        } catch (IOException f) {
            f.printStackTrace();
            getLogger().debug(" cannot be imported");
        } finally {
            if (br != null) {
                try {
                    br.close();
                    getLogger().info("success - import ");
                } catch (IOException f) {
                    f.printStackTrace();
                }
            }
        }
    }


    private String string(String[] strings, int i) {
        if (i < strings.length) {
            return strings[i];
        } else {
            return "";
        }
    }

    public static Double calculatePurchasePrice(Accessories baseEntity) {
        BigDecimal priceDetal = BigDecimal.valueOf(baseEntity.getUnitDetalPrice());
        BigDecimal discounts = BigDecimal.valueOf(4 - discount(baseEntity.getBasicDiscount()) - discount(baseEntity.getAdditionalDiscount()) - discount(baseEntity.getPromotionDiscount()) - discount(baseEntity.getSkontoDiscount()));
        BigDecimal result = BigDecimal.valueOf(1).subtract(discounts).setScale(2, RoundingMode.HALF_UP);
        return priceDetal.multiply(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    private static Double discount(Integer value) {
        return BigDecimal.valueOf(100 - value).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP).doubleValue();
    }

    static Double calculateDetalPrice(Accessories baseEntity) {
        BigDecimal pricePurchase = BigDecimal.valueOf(baseEntity.getUnitPurchasePrice());
        BigDecimal discounts = BigDecimal.valueOf(4 - discount(baseEntity.getBasicDiscount()) - discount(baseEntity.getAdditionalDiscount()) - discount(baseEntity.getPromotionDiscount()) - discount(baseEntity.getSkontoDiscount()));
        BigDecimal result = BigDecimal.valueOf(1).subtract(discounts).setScale(2, RoundingMode.HALF_UP);
        return pricePurchase.divide(result, 2, RoundingMode.HALF_UP).doubleValue();
    }
}