package vagas.challenges.merchantsguide;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class QuestionsInputMain {

	
	public static void main(String args[]) {
		try {
			Scanner in = new Scanner(new FileReader(args[0]));
			
			while(in.hasNextLine()){
				String input = in.nextLine();
				System.out.print(input);
				boolean b = Pattern.matches(".*is.*Credits$", input);
				System.out.print(" " + b + " \n");
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}
}
