package refactor;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractPayProcessor implements PayProcessor {

  @PostConstruct
  public void init() {
    payProcessorMap.put(getPayChannel(), this);
  }

  @Override
  public void process(PayContext context) {
    if(preConditionContext(context)) {
      context.setMsg("error..");
      return;
    }
    doPay(context);
  }

  public abstract boolean preConditionContext(PayContext context);

  public abstract void doPay(PayContext context);

  protected abstract String getPayChannel();


}
