import java.util.ArrayList;

public class Model {
    private int w;
    private ArrayList<View> views = new ArrayList<>();

    public void changeWert(int w) {
        this.w = w;
        notifyViews();
    }

    public void addView(View v) {
        this.views.add(v);
    }

    private void notifyViews() {
        for (View view : views) {
            view.notify(w);
        }
    }
}
