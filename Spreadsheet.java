import java.util.*;
// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] cells = new Cell[10][10];


	public static boolean isDouble(String str) {
    if (str == null) {
        return false;
    }
    try {
        Double.parseDouble(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}


	@Override
	public String processCommand(String command)
	{
		if (command.equals("print")){
			return getGridText();
		} else if (command.contains("=")){
			if (command.contains("avg")){
				String[] parts = command.split("-");
				System.out.println(Arrays.toString(parts));
				String [] parts2 = parts[0].split("=");
				Location loc = new SpreadsheetLoc(parts2[0].trim().toUpperCase());
				
			} else {
				String[] parts = command.split("=");
				Location loc = new SpreadsheetLoc(parts[0].trim().toUpperCase());
				if (isDouble(parts[1].trim())) {
					cells[loc.getRow()-1][loc.getCol()] = new IntCell(Double.parseDouble(parts[1].trim()));
					return "INT ITS AN INT welll its technically a double!!!!!!";
				} else if (command.contains("%")) {
					parts[1] = parts[1].replaceAll("%", "");
					cells[loc.getRow()-1][loc.getCol()] = new PercentCell(Double.parseDouble(parts[1].trim()));
				}
				
				else {
				cells[loc.getRow()-1][loc.getCol()] = new TextCell(parts[1].trim());
				return "Got it! Personal Owen Excel Manager At Your Service \n";}
		} 
		} else if (command.equals("clear")) {
			cells = new Cell[10][10];
		} else {
			Location loc = new SpreadsheetLoc(command.trim().toUpperCase());
			Cell c = getCell(loc);
			if (c == null) {
				return "Cell is empty";
			}
			return c.fullCellText();
		}
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return cells[loc.getRow()-1][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String res = "       |";
		for (int col = 0; col < getCols(); col++){
			String header = (char)('A'+col)+ "          ";
			res += header.substring(0, 10) + "|";
		}
		res += "\n";

		for (int row = 1; row <= getRows(); row++){
			
			res += (row+"       ").substring(0, 7)+"|";
			for (int col = 0; col <getCols();col++){
				Cell c = cells[row-1][col];
				res += (c == null ? "          " : c.abbreviatedCellText())+"|";
			}
			res += "\n";
		}
		return res;
	}

}
