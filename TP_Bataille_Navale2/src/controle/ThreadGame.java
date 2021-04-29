package controle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class ThreadGame extends Thread {

	BufferedReader in1;
	PrintWriter out1;
	BufferedReader in2;
	PrintWriter out2;

	public ThreadGame (Socket client1, Socket client2) {
		try {
			in1 = new BufferedReader (new InputStreamReader(client1.getInputStream()));
			out1 = new PrintWriter (client1.getOutputStream(), true);
			in2 = new BufferedReader (new InputStreamReader(client2.getInputStream()));
			out2 = new PrintWriter (client2.getOutputStream(), true);
			
			out1.println("Nous avons trouvé un autre joureur ! Vous ètes joueur 1 \n");
			out2.println("Nous avons trouvé un autre joureur ! Vous ètes joueur 2 \n");
								
			
		}catch(Exception e) {e.getMessage();}
	}
	
	public int[] choixCible(Scanner scin, PrintWriter out, PrintWriter out_adv) { //Pour qu'un joueur donne une case cible
		out.println("C'est à votre tour, veuiller envoyer une case cible :");
		out_adv.println("Veuillez patienter, votre adversaire choisi une cible...");
		String cible_s = scin.nextLine();
		int x = Character.getNumericValue(cible_s.charAt(0));
		int y = Character.getNumericValue(cible_s.charAt(1));
		out.println("Vous avez choisi la case : " + cible_s);
		int[] cible = {x,y};
		return cible;
	}
	
	public boolean[][] remplireGrille (Scanner scin, PrintWriter out, PrintWriter out_adv){ //Pour qu'un joueur définisse sa grille de jeu
		boolean[][] grille = new boolean[9][9];
		out.println("Pour commencer la partie nous vous demandons de remplir votre grille.");
		out_adv.println("Veuillez patienter, votre adversaire place ses bateaux....");
		for (int t=0; t<5; t++) {
			out.println("Veuiller entrer une case pour votre bateau n°" + (t+1));
			String pos = scin.nextLine();
			int x = Character.getNumericValue(pos.charAt(0));
			int y = Character.getNumericValue(pos.charAt(1));
			grille[x][y] = true;
		} 
		return grille; //attention, retourne une grille de null et de true, pas de false ici !
	}
	
	public void afficherGrille(boolean[][] grille, boolean[][] grille_cible, PrintWriter out) { //affiche la grille du joueur et sa grille_cible
		
		out.println("Voici votre grille et la grille contenant les cases que vous avez ciblé chez votre adversaire :");
		
		for(int i=0; i<9 ;i++) { //parcour les lignes
			for(int y=0; y<9; y++) { //parcour les colonnes
				
				if(grille[i][y]==true) {out.print("+ ");}
				else {out.print("- ");}
			}
			
			out.print(" | | ");  //sépare les deux grilles
			
			for(int y=0; y<9; y++) {
				
				if(grille_cible[i][y]==true) {out.print("+ ");}
				else {out.print("- ");}
			}
			
			out.println("");  // va a la ligne en fin de ligne
		}
	}

	public int verif_cible (boolean[][] grille_adv, int compteur_adv, int[] cible, PrintWriter out, boolean[][] grille_cible) { //vérifier si une case cible est un bateau adverse ou non et met a jour les grilles + compteur
		
		if (grille_adv[cible[0]][cible[1]]==true) {
			compteur_adv = compteur_adv-1;
			out.println("Touché ! l'advesaire perd un bateau !");
		}
		else {
			out.println("Manqué ! Pas de bateau sur cette case...");
		}
		grille_adv[cible[0]][cible[1]] = false;
		grille_cible[cible[0]][cible[1]] = true;
		
		return compteur_adv;
	}
	
	public void run() {
		
		Scanner scin1 = new Scanner(in1);
		Scanner scin2 = new Scanner(in2);
		
		boolean[][] grille_cible_j1 = new boolean[9][9];
		boolean[][] grille_cible_j2 = new boolean[9][9];
		
		int compteur_j1 = 5;
		int compteur_j2 = 5;
		
		boolean[][] grille_j1 = remplireGrille(scin1,out1,out2);
		boolean[][] grille_j2 = remplireGrille(scin2,out2,out1);
		
		try {
			while ((compteur_j1!=0) && (compteur_j2!=0)){
				
				afficherGrille(grille_j1,grille_cible_j1,out1);
				afficherGrille(grille_j2,grille_cible_j2,out2);
				
				int[] cible_j1 = choixCible(scin1,out1,out2);
				int[] cible_j2 = choixCible(scin2,out2,out1);
				
				compteur_j1 = verif_cible(grille_j1, compteur_j1, cible_j2, out2, grille_cible_j2);
				compteur_j2 = verif_cible(grille_j2, compteur_j2, cible_j1, out1, grille_cible_j1);
				
				out1.println("il vous reste "+compteur_j1+" bateau(x) en jeu !");
				out2.println("il vous reste "+compteur_j2+" bateau(x) en jeu !");
			}
			
			out1.println("partie terminé !");
			out2.println("partie terminé !");
			
		}catch(Exception e) {e.getMessage();}
		
		//scin1.close();
		//scin2.close();
	}
}
