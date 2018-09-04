package mybatis.mbg;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengchao wu on 6/13/2018.
 */
public class MbgGeneratorUtils {
    public void generator() throws Exception
    {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        //指定 逆向工程配置文件
        URL resource = MbgGeneratorUtils.class.getClassLoader().getResource("generatorConfig.xml");
        File configFile = new File(resource.getPath());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,callback, warnings);
        myBatisGenerator.generate(null);

    }

    public static void main(String[] args) throws Exception
    {
        try
        {
            new MbgGeneratorUtils().generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
