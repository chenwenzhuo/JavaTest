package ventrol_chen.com;

/**
 * Created by --C-W-Z-- on 2016/12/9 0009.
 */

public class Generic {
    public <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }
}
