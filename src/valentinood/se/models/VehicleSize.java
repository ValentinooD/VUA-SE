package valentinood.se.models;

public enum VehicleSize {
    SMALL(7, 8),
    BIG(8, 10);

    private final int lowerFee;
    private final int higherFee;

    VehicleSize(int lowerFee, int higherFee) {
        this.lowerFee = lowerFee;
        this.higherFee = higherFee;
    }

    public int getLowerFee() {
        return lowerFee;
    }

    public int getHigherFee() {
        return higherFee;
    }
}
