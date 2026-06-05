public class SpreadsheetLoc implements Location{
    private int row;
    private int col;





    public SpreadsheetLoc(String cellName){
        col = cellName.charAt(0) - 'A';
        row = Integer.parseInt(cellName.substring(1));
    }
    
    @Override
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
}

