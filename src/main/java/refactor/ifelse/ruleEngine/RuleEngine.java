package refactor.ifelse.ruleEngine;

import com.google.common.collect.Lists;

import java.util.List;

public class RuleEngine {
    private List<Rule> rules = Lists.newArrayList(new AddRule());


    public Result process(Expression expression) {
        Rule rule = rules.stream()
                .filter(r -> r.evaluate(expression))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("expression does not match any rule"));

        return rule.getResult();
    }
}
