package com.java.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @auther: wynnzuo
 * @date: 2018/11/4 14:47
 * @description: 文件拷贝 用到io、nio  java7 TWR语法
 */
public final class CopyFileUtil {
    private CopyFileUtil() {
            throw new AssertionError();//断言错
    }
    /**
     *
     * @param source
     * @param target
     * @throws IOException
     * 这是jdk1.7加入的try-with-resources写法  TWR写法
     * 可以用来代替之前的try-catch-finally语句块
     * 实现对某些资源开销大的resource省去写finally语句块释放资源的代码
     * 例如关闭流、断开数据库连接等等，都不在需要写finally语句块释放资源，try-with-resources会自动释放try后面()内占用的资源
     */
    public static void fileCopy(String source,String target)throws IOException {
        try (InputStream in = new FileInputStream(source)){
            try(OutputStream out = new FileOutputStream(target)){
                byte[] buffer = new byte[4096];
                int bytesToRead;
                while ((bytesToRead=in.read(buffer))!=-1){
                    out.write(buffer,0,bytesToRead);
                }
            }
        }
    }

    /**
     * NIO实现   channel和buffer
     * @param source
     * @param target
     * @throws IOException
     */
    public static void fileCopyNIO(String source,String target)throws IOException {
        try (InputStream in = new FileInputStream(source)){
            try(OutputStream out = new FileOutputStream(target)){
                FileChannel inChannel = ((FileInputStream) in).getChannel();
                FileChannel outChannel = ((FileOutputStream) out).getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while (inChannel.read(buffer)!=-1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            for (int i=1;i<=100;i++) {
                CopyFileUtil.fileCopy("E:\\lihong\\Java 8实战.pdf","C:\\Users\\Administrator\\Desktop\\test\\Java 8实战"+i+".pdf");
            }
            long endTime = System.currentTimeMillis();
            System.out.println("io 100次所需时间"+(endTime-startTime));

            long startTime1 = System.currentTimeMillis();
            for (int i=1;i<=100;i++) {
                CopyFileUtil.fileCopyNIO("E:\\lihong\\Java 8实战.pdf","C:\\Users\\Administrator\\Desktop\\test1\\Java 8实战"+i+".pdf");
            }
            long endTime1 = System.currentTimeMillis();
            System.out.println("nio 100次所需时间"+(endTime1-startTime1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
