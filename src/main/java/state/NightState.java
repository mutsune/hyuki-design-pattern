package state;

public class NightState implements State {
    private static final NightState singleton = new NightState();

    public static NightState getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("非常: 夜間の金庫使用");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル (夜間)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("夜間の通話録音");
    }

    @Override
    public String toString() {
        return "[夜間]";
    }
}
