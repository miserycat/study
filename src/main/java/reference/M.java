package reference;

public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("M is recycled...");
    }
}
