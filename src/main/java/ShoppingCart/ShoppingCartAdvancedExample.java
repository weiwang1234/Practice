package ShoppingCart;

public class ShoppingCartAdvancedExample {
    public static void main(String[] args) {
        // 创建折扣策略对象
        DiscountStrategy percentageDiscount = new PercentageDiscount(10);  // 10%折扣
        DiscountStrategy fixedDiscount = new FixedDiscount(5);  // 每个商品5元折扣

        // 创建商品
        Product apple = new Product("1", "Apple", 2.0, 3);  // 创建苹果商品
        Product banana = new Product("2", "Banana", 1.5, 5);  // 创建香蕉商品
        Product orange = new Product("3", "Orange", 3.0, 2);  // 创建橙子商品

        // 创建购物车1并添加商品
        ShoppingCart cart1 = new ShoppingCart();
        cart1.addProduct(apple);  // 将苹果添加到购物车
        cart1.addProduct(banana); // 将香蕉添加到购物车

        // 创建购物车2并添加商品
        ShoppingCart cart2 = new ShoppingCart();
        cart2.addProduct(orange);  // 将橙子添加到购物车
        cart2.addProduct(banana);  // 将香蕉再次添加到购物车，测试合并时数量更新

        // 查看购物车1的商品和总价，使用百分比折扣
        System.out.println("购物车1（百分比折扣10%）:");
        cart1.viewCart(percentageDiscount);  // 查看购物车内容
        System.out.println("购物车总价: " + cart1.calculateTotal(percentageDiscount));  // 计算总价

        // 合并购物车2到购物车1
        cart1.mergeCart(cart2);

        // 查看合并后的购物车1
        System.out.println("\n合并购物车2后的购物车1:");
        cart1.viewCart(percentageDiscount);  // 查看合并后的购物车内容
        System.out.println("购物车总价: " + cart1.calculateTotal(percentageDiscount));  // 计算总价

        // 使用固定折扣策略，查看合并后的购物车1
        System.out.println("\n使用固定折扣:");
        cart1.viewCart(fixedDiscount);  // 使用固定折扣查看购物车内容
        System.out.println("购物车总价: " + cart1.calculateTotal(fixedDiscount));  // 计算总价
    }
}
