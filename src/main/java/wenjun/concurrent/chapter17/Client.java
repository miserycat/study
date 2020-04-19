package wenjun.concurrent.chapter17;

public class Client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User shl = new User("SHL", "Shanghai", gate);
        User bjl = new User("BJL", "Beijing", gate);
        User gdl = new User("GDL", "GuangDong", gate);

        shl.start();
        bjl.start();
        gdl.start();
    }
}
