package utils;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ChristmasTreeSwing extends JPanel {

    public static void main(String[] args) {
        // 创建并显示窗口
        JFrame frame = new JFrame("酷炫圣诞树");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.add(new ChristmasTreeSwing());
        frame.setVisible(true);
    }

    // 重写 paintComponent 方法来绘制圣诞树
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 绘制圣诞树
        drawTree(g2d);

        // 绘制树干
        drawTrunk(g2d);

        // 绘制装饰
        drawDecorations(g2d);

        // 绘制星星
        drawStar(g2d);

        // 添加底部祝福语
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.setColor(Color.RED);
        g2d.drawString("Merry Christmas!", 120, 500);
    }

    // 绘制圣诞树叶部分
    private void drawTree(Graphics2D g2d) {
        g2d.setColor(Color.GREEN);
        int[] xPoints = { 150, 50, 250 };  // 叶子宽度
        int[] yPoints = { 100, 300, 300 }; // 叶子高度

        for (int i = 0; i < 3; i++) {
            g2d.fillPolygon(xPoints, yPoints, 3);
            yPoints[1] -= 40;
            yPoints[2] -= 40;
            xPoints[0] -= 20;
            xPoints[1] += 20;
            xPoints[2] -= 20;
        }
    }

    // 绘制圣诞树的树干
    private void drawTrunk(Graphics2D g2d) {
        g2d.setColor(new Color(139, 69, 19)); // 树干的颜色
        g2d.fillRect(140, 400, 30, 80);
    }

    // 绘制装饰（使用随机生成的圆形来模拟彩球）
    private void drawDecorations(Graphics2D g2d) {
        Random rand = new Random();
        g2d.setColor(Color.RED);
        for (int i = 0; i < 5; i++) {
            int x = rand.nextInt(200) + 100;
            int y = rand.nextInt(200) + 150;
            int size = rand.nextInt(10) + 10;
            g2d.fillOval(x, y, size, size);
        }

        g2d.setColor(Color.YELLOW);
        for (int i = 0; i < 5; i++) {
            int x = rand.nextInt(200) + 100;
            int y = rand.nextInt(200) + 150;
            int size = rand.nextInt(10) + 10;
            g2d.fillOval(x, y, size, size);
        }
    }

    // 绘制树顶的星星
    private void drawStar(Graphics2D g2d) {
        g2d.setColor(Color.YELLOW);
        int[] xPoints = { 160, 170, 180, 190, 200 };
        int[] yPoints = { 120, 110, 120, 110, 120 };
        g2d.fillPolygon(xPoints, yPoints, 5);
    }
}
