package jvm.bytecode;

import java.io.*;
import java.net.ServerSocket;

/**
 * 非static方法在编译后生成的字节码中，方法参数的数量总比原方法的参数数量多一个（this）,它位于第一个参数处，这样我们就可以在方法中使用this去访问当前读对象。
 *
 * Java字节码对于异常的处理方式"
 * 1。统一采用异常表的方式来对异常进行处理。
 * 2。在jdk1.4.2之前的版本，并不是使用异常表的方式来对异常进行处理的，而是采用特性的指令。
 * 3。当异常处理存在finally语句块时，现代化的JVM采取的处理方式是将finally语句块的字节码重复接到每一个catch块后面。
 */
public class MyTest2 {
    public static void main(String[] args) throws NullPointerException, ArithmeticException {
        try {
            InputStream is = new FileInputStream("test.txt");
            ServerSocket serverSocket = new ServerSocket(8888);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        } catch (Exception e) {

        } finally {
            System.out.println("finally");
        }
    }
}
