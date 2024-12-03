package ShoppingCart;

// 固定金额折扣策略实现
public class FixedDiscount implements DiscountStrategy {
    private double discountAmount;  // 固定金额折扣

    public FixedDiscount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double price) {
        // 应用固定金额折扣
        return price - discountAmount;
    }
}
