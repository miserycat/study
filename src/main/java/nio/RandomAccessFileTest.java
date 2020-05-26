package nio;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.Objects;

/**
 *
 *
 * 首先，我们定义了一个变量position，记录在发生中断的时候，已完成读写的位置。（这是为了方便，实际来说肯定应该讲这个值存到文件或者数据库等进行持久化）
 * 然后在文件读写的while循环中，我们去模拟一个中断行为的发生。这里是当targetFile的文件长度为3个字节则模拟抛出一个我们自定义的异常。
 * (我们可以想象为实际下载中，已经上传(下载)了”x”个字节的内容，这个时候网络中断了，那么我们就在网络中断抛出的异常中将”x”记录下来)。
 * 剩下的就如果我们之前说的一样，在“续传”行为开始后，通过RandomAccessFile类来包装我们的文件，然后通过seek将指针指定到之前发生中断的位置进行读写就搞定了。
 * （实际的文件下载上传，我们当然需要将保存的中断值上传给服务器，这个方式通常为httpConnection.setRequestProperty(“RANGE”,”bytes=x”);）
 */
public class RandomAccessFileTest {
    private static int position = -1;

    public static void main(String[] args) {
        String fileClassPath = Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("")).getPath() ;
        // 源文件与目标文件
        File sourceFile = new File(fileClassPath, "test.txt");
        File targetFile = new File(fileClassPath, "target.txt");
        // 输入输出流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        // 数据缓冲区
        byte[] buf = new byte[1];

        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(targetFile);
            // 数据读写
            while (fis.read(buf) != -1) {
                fos.write(buf);
                // 当已经上传了3字节的文件内容时,模拟网络中断了，抛出异常
                if (targetFile.length() == 3) {
                    position = 3;
                    throw new FileAccessException();
                }
            }

        } catch (FileAccessException e) {
            keepGoing(sourceFile, targetFile, position);
        } catch (FileNotFoundException e) {
            System.out.println("file not existed");
        } catch (IOException e) {

        } finally {
            try {
                // 关闭输入输出流
                if (fis != null)
                    fis.close();

                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void keepGoing(File source, File target, int position) {
        try {
            Thread.sleep(30000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            RandomAccessFile readFile = new RandomAccessFile(source, "rw");
            RandomAccessFile writeFile = new RandomAccessFile(target, "rw");

            readFile.seek(position);
            writeFile.seek(position);

            // 数据缓冲区
            byte[] buf = new byte[1];
            // 数据读写
            while (readFile.read(buf) != -1) {
                writeFile.write(buf);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class FileAccessException extends RuntimeException {
        public FileAccessException() {
            super();
        }
    }
}
