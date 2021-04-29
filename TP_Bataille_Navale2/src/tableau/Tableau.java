package tableau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Tableau extends Thread{
	
            

	public static void show(int[][] tableau, PrintWriter out)
{      out.println("  ABCDEFGHIJ");
int courant=0;
for(int i = 0; i<10; i++)                       
{              

out.print(courant+" ");  
courant=courant+1;
for(int j = 0; j<10; j++)
{ 
out.print((tableau[i][j]));  
}
out.println("");  
}              
  
}
	
	public static boolean choixCible(BufferedReader in, PrintWriter outTir, PrintWriter outTouche, int[][] tableauAdv, int[][] tableauTir) 
	{ //Pour qu'un joueur donne une case cible
		outTir.println("C'est � votre tour, o� voulez vous tirer ? :");
		String cibleString;
		boolean touche = false;
		boolean bonneEntree = false;
		try {
			
			while (bonneEntree == false) {
				cibleString = in.readLine().toString();
			int x = Character.getNumericValue(cibleString.charAt(0));
			int y = Character.getNumericValue(cibleString.charAt(1));
			
			if (x>=25 || x<10 || y<0 || y>9 || cibleString.length()>2 ||cibleString.length()== 0) {
				outTir.println("Rentrez seulement deux charact�res compris entre A et O, 0 et 9");
			}
			else{
				bonneEntree = true;
				outTir.println("Vous avez choisi la case : " + cibleString);
				if (tableauAdv[y][x-10] ==1) {
					outTir.println("touch� !");
					tableauTir[y][x-10] = 1;
					outTouche.println("Vous avez �t� touch� !");
					touche = true;					
				}
				else {
					outTir.println("Dans l'eau !");
					tableauTir[y][x-10] = 2;
					outTouche.println("Vous n'avez pas �t� touch� !");
					touche = false;
				}
			}
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return touche;
				}
	

	public static int[] positionnerBateau(BufferedReader in, PrintWriter out, int[][] tableauJoueur, int[] bateaux )
	{
		boolean bonneEntree = false;
		String longueur = null;
		
		out.println("C'est � votre tour \nil vous reste : ");
		for (int i=0 ; i<4 ;i++) {
			out.print((bateaux[i]));  
			out.print(" bateaux de longueur " + (i+2)+" \n");
			
			}
		
		out.println("quel taille de bateau voulez vous mettre ? ");
		try {
			while(bonneEntree == false) {
			
				longueur = in.readLine();
			
			if(longueur.length()!=1) {
				
				out.println("Rentrez 1 charact�res");
				
			}else if (Integer.parseInt(longueur)>5) { 
				
				out.println("Rentrez une valeur entre 1 et 5");

			}else if (bateaux[Integer.parseInt(longueur)-1]==0) {
				
				out.println("Vous n'avez plus de bateaux de cette longueur");
			
			}else {
				bonneEntree = true;
			}
			}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				out.println(e1.toString());
			}
		
		bonneEntree = false;
			
			while (bonneEntree == false) {
				out.println("Entrez les coordonn�es, comprise entre A et O, 0 et 9");
				String cibleString;
				try {
					cibleString = in.readLine();
				 
				
				
			int x = Character.getNumericValue(cibleString.charAt(0));
			int y = Character.getNumericValue(cibleString.charAt(1));
				
			if (x>=25 || x<10 || y<0 || y>9 || cibleString.length()!=2 ||  tableauJoueur[y][x-10]==1) {
				out.println("Rentrez seulement deux charact�res compris entre A et 0, 0 et 9\nNe mettez pas un bateau sur une case que vous avez d�j� choisi");
			}
			else{
				out.println("Rentrez dans quel sens vous voulez que le bateau s'oriente?\nV pour Vertical et H pour Horizontal");
				int sens;
				try {
					sens = Character.getNumericValue(in.readLine().charAt(0));
				
				if(sens !=17 && sens!=31 ) {//V = 31 , H=17
					
					out.println("Nous attendons V ou H \nRentrez de nouveau les coordonn�es");
				}else {
					if (sens==31) {
						if (y+Integer.parseInt(longueur)<=10) { //taille tableau
						for(int i = 0; i<Integer.parseInt(longueur); i++) {
							if (tableauJoueur[y+i][x-10] == 1) {
								bonneEntree=false;
								
							}
							else {bonneEntree=true;}
							}
							if(bonneEntree) {
						for(int i = 0; i<Integer.parseInt(longueur); i++) {
								
							tableauJoueur[y+i][x-10] = 1;}
						bonneEntree = true;
							}else {out.println("Le bateau d�passe du cadre ou alors il y a d�j� un bateau, recommencez");
							
						
					}
						}else {out.println("Le bateau d�passe du cadre");}
						
					}
						if (sens==17) {
							if (x-10+Integer.parseInt(longueur)<=15) { //taille tableau
								for(int i = 0; i<Integer.parseInt(longueur); i++) {
									if (tableauJoueur[y][x-10+i] == 1) {
										bonneEntree=false;
									}else {bonneEntree = true;}
								}
								if(bonneEntree) {	
									
								for(int i = 0; i<Integer.parseInt(longueur); i++) {
										
									tableauJoueur[y][x-10+i] = 1;}
								bonneEntree = true;
									}
							}else {out.println("Le bateau d�passe du cadre ou alors il y a d�j� un bateau, recommencez");
									
									}
							
						}else {out.println("Le bateau d�passe du cadre");}
									
								
						
				
				}
			
				
			}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}

}catch (IOException e1) {
	// TODO Auto-generated catch block

	out.println("Rentrez  seulement 2 charact�res");

			}			
	}bateaux[Integer.parseInt(longueur)-1]--;

			return bateaux;
}
}
	