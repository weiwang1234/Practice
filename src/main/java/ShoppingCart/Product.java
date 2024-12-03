package ShoppingCart;

// 商品类
public class Product {
    String id;       // 商品ID
    String name;     // 商品名称
    double price;    // 商品单价
    int quantity;    // 商品数量

    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // 更新商品数量
    void updateQuantity(int quantity) {
        this.quantity += quantity;
    }

    // 计算商品总价，考虑折扣
    double getTotalPrice(DiscountStrategy discountStrategy) {
        double discountedPrice = discountStrategy.applyDiscount(price);  // 获取折扣后的价格
        return discountedPrice * quantity;  // 计算商品的总价
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ") - Price: " + price + " x Quantity: " + quantity;
    }
}
