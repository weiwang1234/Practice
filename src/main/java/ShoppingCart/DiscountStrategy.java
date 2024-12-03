package ShoppingCart;

// 折扣策略接口
public interface DiscountStrategy {
    double applyDiscount(double price);  // 折扣策略：应用折扣到商品价格
}
