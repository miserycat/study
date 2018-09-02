package refactor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface PayProcessor {

  Map<String, PayProcessor> payProcessorMap = new ConcurrentHashMap<>();

  void process(PayContext context);

}
