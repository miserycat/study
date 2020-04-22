package wenjun.concurrent.chapter22;

public class QueryFromHttpAction {
    public void execute() {
        Context context = ActionContext.getInstance().getContext();
        String cardID = queryCardId();
        context.setCardId(cardID);
    }

    public void execute(Context context) {
        String cardId = queryCardId();
        context.setCardId(cardId);
    }

    private String queryCardId() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "123456789" + Thread.currentThread().getId();
    }
}
