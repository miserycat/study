package refactor;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan("refactor")
public class PayApp {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PayApp.class);

    PayContext context = new PayContext(10000, "aliPay");

    PayProcessor.payProcessorMap.get(PayTypeEnum.ALIPAY.getChannel()).process(context);
  }


}
