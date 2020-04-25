package wenjun.concurrent.chapter28;

class Servant implements ActiveObject {
    @Override
    public Result<String> makeString(int count, char fillChar) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(fillChar);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new RealResult<>(sb.toString());
    }

    @Override
    public void displayString(java.lang.String text) {
        System.out.println("Display:" + text);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
