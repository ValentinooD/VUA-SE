package valentinood.se.models;

public class LargeTrain extends Train {
    public LargeTrain() {
        super(VehicleSize.BIG);
    }

    @Override
    public int getMaxSpace() {
        return 6;
    }
}
