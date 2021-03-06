package server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import tableau.Tableau;

public class ThreadGroup extends Thread {
	BufferedReader in1;
	PrintWriter out1;
	BufferedReader in2;
	PrintWriter out2;
	int[] bateauxJoueur1 = {1,2,1,1};
	int[] bateauxJoueur2 = {1,2,1,1};
	int[][] tableauJoueur1=new int[10][10]; // tableau vu par le joueur - � afficher
	
	int[][] tableauJoueur2=new int[10][10];
	
	int[][] tableauTir1=new int[10][10]; // tableau vu par le joueur - � afficher
	
	int[][] tableauTir2=new int[10][10];
	
	public ThreadGroup (Socket client1, Socket client2) {
		try {
			
			in1 = new BufferedReader (new InputStreamReader(client1.getInputStream()));
			out1 = new PrintWriter (client1.getOutputStream(), true);
			in2 = new BufferedReader (new InputStreamReader(client2.getInputStream()));
			out2 = new PrintWriter (client2.getOutputStream(), true);
			
			out1.println("Les deux clients sont connect�s, Vous �tes le joueur 1 \n");
			out1.println("Appuyez sur entree pour commencer");
			out2.println("Les deux clients sont connect�s, Vous �tes le joueur 2 \n");
			out2.println("Appuyez sur entree pour commencer");
		}catch(Exception e) {}
		}	
	
	

	public void run() {
		try {
			
			
			boolean tourde1 = true;
			boolean tourde2 = false;
			int compteurScore1 = 0;
			int compteurScore2 = 0;
			int NbrBateaux = 5;
			while (NbrBateaux !=0) {
				Tableau.show(tableauJoueur1, out1);
				bateauxJoueur1 = Tableau.positionnerBateau(in1, out1, tableauJoueur1, bateauxJoueur1);
				Tableau.show(tableauJoueur1, out1);
				Tableau.show(tableauJoueur2, out2);
				bateauxJoueur2 = Tableau.positionnerBateau(in2, out2, tableauJoueur2, bateauxJoueur2);
				Tableau.show(tableauJoueur2, out2);
				NbrBateaux--;
			}
			while(true) {
			if(tourde1) {
				Tableau.show(tableauTir1, out1);
				if(Tableau.choixCible(in1,out1, out2, tableauJoueur2, tableauTir1 )) {
					compteurScore1++;
					tourde2 = false;
					tourde1 = true;
				}else {
					tourde2 = true;
					tourde1 = false;	
					
					}
				
				if(compteurScore1 == 17) {
					out1.println("Vous avez gagn�");
					out2.println("Vous avez perdu");
					break;
				}
				out1.println("Vous avez "+ compteurScore1 +" points.\nIl vous manque " +(17-compteurScore1));
				out2.println("Le joueur 1 a " +compteurScore1+" points.\nIl lui manque "+(17-compteurScore1));
			}
			else if(tourde2) {
				Tableau.show(tableauTir2, out2);
				if(Tableau.choixCible(in2,out2, out1, tableauJoueur1, tableauTir2)) {
					compteurScore2++;
					tourde1 = false;
					tourde2 = true;
				}
				else {
				tourde1 = true;
				tourde2 = false;	
				}
				if(compteurScore2 == 17) {
					out2.println("Vous avez gagn�");
					out1.println("Vous avez perdu");
					break;
				}
				out2.println("Vous avez "+ compteurScore2 +" points.\nIl vous manque " +(17-compteurScore2));
				out1.println("Le joueur 2 a " +compteurScore2+" points.\nIl lui manque "+(17-compteurScore2));
			}
			}
			}
		catch(Exception e) {}
		
	}
}
	