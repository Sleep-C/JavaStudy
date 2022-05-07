package JVM.studyJVM;

public class ReferenceCountTest {
    private static final byte[] MEMORY = new byte[1024*1024*2];

    private ReferenceCountTest reference;

    public static void main(String[] args) {
        ReferenceCountTest a = new ReferenceCountTest();
        ReferenceCountTest b = new ReferenceCountTest();
        a.reference = b;
        b.reference = a;
        a = null;
        b = null;
        System.gc();
    }
}
