public class IntCell implements Cell{
    private int val;

    public IntCell(int value) {
        this.val = value;
    }

    

    @Override
    public String fullCellText() {
        return Integer.toString(val);
    }

    @Override
    public String abbreviatedCellText(){
        return (val + "          ").substring(0, 10);
    }

}
