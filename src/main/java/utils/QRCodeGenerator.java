    package utils;

    import com.google.zxing.BarcodeFormat;
    import com.google.zxing.WriterException;
    import com.google.zxing.client.j2se.MatrixToImageWriter;
    import com.google.zxing.common.BitMatrix;
    import com.google.zxing.qrcode.QRCodeWriter;
    import java.io.IOException;
    import java.nio.file.FileSystems;
    import java.nio.file.Path;

    public class QRCodeGenerator {

        public static void main(String[] args) {
            // 要编码的字符串内容，这里改为网址
            String qrCodeText = "https://www.baidu.com";

            // 保存二维码的文件路径和名称
            String filePath = "QRCode.png";

            // 二维码的宽度和高度（像素）
            int width = 300;
            int height = 300;

            try {
                // 调用方法生成二维码并保存为图片
                generateQRCodeImage(qrCodeText, width, height, filePath);
                System.out.println("QR Code generated successfully!");
            } catch (WriterException | IOException e) {
                // 捕获并处理可能的异常
                System.err.println("Could not generate QR code: " + e.getMessage());
            }
        }

        /**
         * 生成二维码并将其保存为图像文件
         *
         * @param text 要编码的文本内容（这里是网址）
         * @param width 图像的宽度（像素）
         * @param height 图像的高度（像素）
         * @param filePath 保存图像的文件路径
         * @throws WriterException 如果编码过程出现错误
         * @throws IOException 如果文件写入过程出现错误
         */
        private static void generateQRCodeImage(String text, int width, int height, String filePath)
                throws WriterException, IOException {
            // 创建QRCodeWriter实例用于生成二维码
            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            // 将网址编码为QR码矩阵
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

            // 获取文件系统路径对象
            Path path = FileSystems.getDefault().getPath(filePath);

            // 将QR码矩阵写入到文件路径中，并以PNG格式保存
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        }
    }
