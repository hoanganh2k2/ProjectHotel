package entity;

public class Product {
    private int productId;
    private String productName;
    private String image;
    private int purchasePrice;
    private int salePrice;

    public Product() {
    }

    public Product(int productId, String productName, String image, int purchasePrice, int salePrice) {
        this.productId = productId;
        this.productName = productName;
        this.image = image;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", image=" + image
                + ", purchasePrice=" + purchasePrice + ", salePrice=" + salePrice + '}';
    }
    
    
}
