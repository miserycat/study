package refactor;

import org.springframework.stereotype.Service;

@Service
public class AliPayProcessor extends AbstractPayProcessor {
  @Override
  public boolean preConditionContext(PayContext context) {
    return !context.getName().equals("aliPay");
  }

  @Override
  public void doPay(PayContext context) {
    System.out.println("阿里支付 支付逻辑。。。");
  }

  @Override
  protected String getPayChannel() {
    return PayTypeEnum.ALIPAY.getChannel();
  }


}
