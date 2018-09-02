package refactor;

public enum PayTypeEnum {
  ALIPAY("ali pay", "阿里支付"),
  WECHATPAY("weChat pay", "微信支付");

  PayTypeEnum(String name, String channel) {
    this.name = name;
    this.channel = channel;
  }

  private String name;

  private String channel;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }
}
