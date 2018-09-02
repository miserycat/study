package refactor;

public class PayContext {

  private double cents;

  private String name;

  private String msg;

  public PayContext(double cents, String name) {
    this.cents = cents;
    this.name = name;
  }

  public double getCents() {
    return cents;
  }

  public void setCents(double cents) {
    this.cents = cents;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
