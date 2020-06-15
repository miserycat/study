package wenjun.concurrent.chapter29;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DecryptClassLoader extends ClassLoader {
    private static final String DEFAULT_DIR_PATH = "/Users/Shengchaowu/MyClassLoaderDir";
    private String dir = DEFAULT_DIR_PATH;
    private String classLoaderName;

    public DecryptClassLoader() {
        super();
    }

    public DecryptClassLoader(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public DecryptClassLoader(String classLoaderName, ClassLoader parent) {
        super(parent);
    }


    //xxx.xxx.xxx.xxx.AAA -> xxx/xxx/xxx/xxx/AAA.class
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        File classFile = new File(dir, classPath + ".class");
        if (!classFile.exists()) {
            throw new ClassNotFoundException();
        }

        byte[] classBytes = loadClassBytes(classFile);
        if (classBytes == null || classBytes.length == 0) {
            throw new ClassNotFoundException();
        }
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    private byte[] loadClassBytes(File classFile) {
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
            FileInputStream fis = new FileInputStream(classFile);) {
            int data;
            while ((data = fis.read()) != -1) {
                baos.write(data ^ EncryptUtils.ENCRYPT_FACTOR);
            }
            baos.flush();

            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getDir() {
        return dir;
    }

    public String getClassLoaderName() {
        return classLoaderName;
    }

    public void setClassLoaderName(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
}