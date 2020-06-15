package wenjun.concurrent.chapter29;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BrokenParentClassLoader extends ClassLoader {
    private static final String DEFAULT_DIR_PATH = "/Users/Shengchaowu/MyClassLoaderDir";
    private String dir = DEFAULT_DIR_PATH;
    private String classLoaderName;

    public BrokenParentClassLoader() {
        super();
    }

    public BrokenParentClassLoader(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public BrokenParentClassLoader(String classLoaderName, ClassLoader parent) {
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

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> clazz = null;
        if (name.startsWith("java.lang")) {
            try {
                return ClassLoader.getSystemClassLoader()
                        .loadClass(name);
            } catch (Exception e) {

            }
        }
        try {
            clazz = findClass(name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (clazz == null && getParent() != null) {
            getParent().loadClass(name);
        }

        return clazz;
    }

    private byte[] loadClassBytes(File classFile) {
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
            FileInputStream fis = new FileInputStream(classFile);) {
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = fis.read(buff)) != -1) {
                baos.write(buff, 0, len);
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