package wenjun.concurrent.chapter17;

/**
 * shared resource
 */
public class Gate {
    private String name;
    private int counter;
    private String address;

    /**
     * threshold
     * @param name
     * @param address
     */
    public synchronized void pass(final String name, final String address) {
        //race
        counter++;
        this.name = name;
        this.address = address;
        verify();
    }

    private void verify() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("*****************BROKEN*****************" + toString());
        }
    }

    @Override
    public synchronized String toString() {
        return "Gate{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
