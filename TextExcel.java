import java.util.*;

public class TextExcel
{

	public static void main(String[] args)
	{
		Grid sheet = new Spreadsheet(); // Keep this as the first statement in main
		Scanner ui = new Scanner(System.in);
		String command = ui.nextLine();
		while (!command.equals("quit")) {
			System.out.println(sheet.processCommand(command));
			command = ui.nextLine();
		}

	}
}
