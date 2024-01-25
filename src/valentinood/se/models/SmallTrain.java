package valentinood.se.models;

public class SmallTrain extends Train {
    public SmallTrain() {
        super(VehicleSize.SMALL);
    }

    @Override
    public int getMaxSpace() {
        return 8;
    }
}
