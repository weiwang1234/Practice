package ShoppingCart;

import java.util.*;

// 购物车类
public class ShoppingCart {
    private Map<String, Product> cart = new HashMap<>();  // 使用 Map 存储商品，key 为商品 ID

    // 添加商品到购物车，若商品已存在，则更新数量
    public void addProduct(Product product) {
        if (cart.containsKey(product.id)) {
            Product existingProduct = cart.get(product.id);  // 获取已存在的商品
            existingProduct.updateQuantity(product.quantity);  // 更新数量
        } else {
            cart.put(product.id, product);  // 添加新商品
        }
    }

    // 从购物车中删除商品
    public void removeProduct(String id) {
        cart.remove(id);  // 根据商品 ID 删除商品
    }

    // 查看购物车中的商品及总价
    public void viewCart(DiscountStrategy discountStrategy) {
        if (cart.isEmpty()) {
            System.out.println("购物车为空！");
        } else {
            cart.values().forEach(product -> System.out.println(product + " | Total: " + product.getTotalPrice(discountStrategy)));
        }
    }

    // 计算购物车中所有商品的总价
    public double calculateTotal(DiscountStrategy discountStrategy) {
        return cart.values().stream()
                .mapToDouble(product -> product.getTotalPrice(discountStrategy))
                .sum();  // 计算购物车总价
    }

    // 合并两个购物车中的商品
    public void mergeCart(ShoppingCart anotherCart) {
        anotherCart.cart.values().forEach(this::addProduct);  // 将另一个购物车的商品合并到当前购物车
    }

    // 获取购物车中的所有商品
    public Collection<Product> getProducts() {
        return cart.values();
    }
}
