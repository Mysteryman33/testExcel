public class TextCell implements Cell{
    private String val;
    private int vali;

    public TextCell(String value) {
        this.val = value;
    }

    

    @Override
    public String fullCellText() {
        return val;
    }

    @Override
    public String abbreviatedCellText(){
        return (val + "          ").substring(0, 10);
    }

}
