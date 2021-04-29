package controle;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class Controle {
	public static void main (String[] args) {
	String message= "1ZZ";
	tir(message);
	
}
	static void tir(String message) {
		//while(true) {
			if(message.length()>2) {
				System.out.println("ce n'est pas possible, recommencez");

			}
					else {
		System.out.println(message.charAt(0));	
		System.out.println(message.charAt(1));	
		//break;
	}
			}
}

//, PrintWriter out