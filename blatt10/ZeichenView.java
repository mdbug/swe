public class ZeichenView implements View {
    private char z;

    public ZeichenView(char z) {
        this.z = z;
    }

    public void notify(int w) {
        for (int i = 0; i < w; ++i) {
            System.out.print(z);
        }
        System.out.print('\n');
    }
}