package jvm.memory;

/**
 *  jps -l 查看所有java进程信息
 *  jcmd(从JDK1.7开始增加的命令)
 *
 *  1. jcmd pid VM.flags: 查看JVM启动参数
 *  2. jcmd pid help: 列出当前运行的Java进程可以执行的操作
 *  3. jcmd pid help xxx: 列出xxx命令的选项
 *  4. jcmd pid PerfCounter.print: 查看JVM性能相关的参数
 *  5. jcmd pid VM.uptime: 查看JVM的启动时长
 *  6. jcmd pid GC.class_histogram:查看系统中类的统计信息
 *  7. jcmd pid Thread.print:查看线程堆栈信息
 *  8. jcmd pid GC.jeap_dump filename: 导出Heap dump文件，导出的文件可以通过jvisualvm查看
 *  9. jcmd pid VM.system_properties:查看JVM的属性信息
 *  10.jcmd pid VM.command_line:查看JVM启动的命令行参数信息
 *
 *  jstack: 可以查看或者导出Java程序中线程的堆栈信息
 *
 *  jmc(Java Mission Control)
 *  jfr:Java Flight Recorder: java进程的统计数据的实时记录
 */
public class MyTest5 {
    public static void main(String[] args) {
        for (; ; ) {
            System.out.println("hello world");
        }
    }
}
