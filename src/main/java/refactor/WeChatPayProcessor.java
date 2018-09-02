package refactor;

import org.springframework.stereotype.Service;

@Service
public class WeChatPayProcessor extends AbstractPayProcessor {

  @Override
  public boolean preConditionContext(PayContext context) {
    return !context.getName().equals("weChatPay");
  }

  @Override
  public void doPay(PayContext context) {
    System.out.println("执行微信支付逻辑。。。");
  }

  @Override
  protected String getPayChannel() {
    return PayTypeEnum.ALIPAY.getChannel();
  }
}
