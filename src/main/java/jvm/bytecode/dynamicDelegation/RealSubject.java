package jvm.bytecode.dynamicDelegation;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("real subject implementation...");
    }
}
