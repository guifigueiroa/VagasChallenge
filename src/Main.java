import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 
 * @author Guilherme M. Figueiroa
 *
 */
public class Main {

	public static void main(String args[]) {
		try {
			Scanner in = new Scanner(new FileReader(args[0]));
			QuestionsInput q = new QuestionsInput();
			while(in.hasNextLine()){
				String input = in.nextLine();
				String output = q.getAnswer(input);
				
				if(output != null){
					System.out.println(output);
				}
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}
}
