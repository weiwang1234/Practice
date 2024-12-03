package ShoppingCart;

// 百分比折扣策略实现
public class PercentageDiscount implements DiscountStrategy {
    private double percentage;  // 折扣百分比

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price) {
        // 应用百分比折扣
        return price - (price * (percentage / 100));
    }
}
