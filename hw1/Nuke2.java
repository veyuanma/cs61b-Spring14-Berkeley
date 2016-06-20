package hw1;

import java.io.*;

public class Nuke2 {
	public static void main(String[] arg) throws Exception{
		BufferedReader keyboard;
		String line;
		keyboard=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Please enter a string at lease two characters:");
		System.out.flush();
		line=keyboard.readLine();
		System.out.println(line.substring(0, 1)+line.substring(2));
		
		
	}
}
