package controllers;

import models.Card;
import models.Deck;

public class StartController extends KlondikeController {
	
	public void start() {
		//Create Tableau
		for(int i=0;i<7;i++){
			Deck tableau = new Deck();
			for(int j=0;j<=i;j++){
				if(j==i)
					tableau.add(new Card(true));
				else
					tableau.add(new Card(false));
			}
			this.tableaus.add(tableau);
		}
		
		//Create Foundations
		for(int i=0;i<4;i++){
			foundations.add(new Deck());
		}
						
		//Create draw
		for(int i=0;i<24;i++){
			draw.add(new Card(false));
		}
	}
}
