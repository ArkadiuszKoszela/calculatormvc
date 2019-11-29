package pl.koszela.calculator.calculatormvc.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "accesories")
public class Accessories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type = "LUX";
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean offer;
    private String dateChange;

    private String name;
    private String manufacturer;
    private Double quantity;
    private Double unitPurchasePrice;
    private Double unitDetalPrice;
    private Double allpriceAfterDiscount;
    private Double allpricePurchase;
    private Double allprofit;
    private String category;
    private String size;
    private String date;

    private Integer discount;
    private Integer basicDiscount;
    private Integer promotionDiscount;
    private Integer additionalDiscount;
    private Integer skontoDiscount;

    public Accessories() {
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getBasicDiscount() {
        return basicDiscount;
    }

    public void setBasicDiscount(Integer basicDiscount) {
        this.basicDiscount = basicDiscount;
    }

    public Integer getPromotionDiscount() {
        return promotionDiscount;
    }

    public void setPromotionDiscount(Integer promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    public Integer getAdditionalDiscount() {
        return additionalDiscount;
    }

    public void setAdditionalDiscount(Integer additionalDiscount) {
        this.additionalDiscount = additionalDiscount;
    }

    public Integer getSkontoDiscount() {
        return skontoDiscount;
    }

    public void setSkontoDiscount(Integer skontoDiscount) {
        this.skontoDiscount = skontoDiscount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPurchasePrice() {
        return unitPurchasePrice;
    }

    public void setUnitPurchasePrice(Double unitPurchasePrice) {
        this.unitPurchasePrice = unitPurchasePrice;
    }

    public Double getUnitDetalPrice() {
        return unitDetalPrice;
    }

    public void setUnitDetalPrice(Double unitDetalPrice) {
        this.unitDetalPrice = unitDetalPrice;
    }

    public Double getAllpriceAfterDiscount() {
        return allpriceAfterDiscount;
    }

    public void setAllpriceAfterDiscount(Double allpriceAfterDiscount) {
        this.allpriceAfterDiscount = allpriceAfterDiscount;
    }

    public Double getAllpricePurchase() {
        return allpricePurchase;
    }

    public void setAllpricePurchase(Double allpricePurchase) {
        this.allpricePurchase = allpricePurchase;
    }

    public Double getAllprofit() {
        return allprofit;
    }

    public void setAllprofit(Double allprofit) {
        this.allprofit = allprofit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOffer() {
        return offer;
    }

    public void setOffer(boolean offer) {
        this.offer = offer;
    }

    public String getDateChange() {
        return dateChange;
    }

    public void setDateChange(String dateChange) {
        this.dateChange = dateChange;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}