public class OuterClass {
    private int y = 100;
    public AnnoInner getAnnoInner() {
        int z = 10;
        return new AnnoInner() {
            @Override
            public int innerAdd(int x) {
//                 z = 20;
                return x + y + z;
            }
        };
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        AnnoInner inner = outer.getAnnoInner();
        System.out.println(inner.innerAdd(5)); //result: 115
    }
}


interface AnnoInner {
    int innerAdd(int x);
}
