public class PercentCell implements Cell{
    private double val;

    public PercentCell(double value) {
        this.val = value;
    }

    

    @Override
    public String fullCellText() {
        return Double.toString(val*0.01);
    }

    @Override
    public String abbreviatedCellText(){
        return (val + "%         ").substring(0, 10);
    }

}
