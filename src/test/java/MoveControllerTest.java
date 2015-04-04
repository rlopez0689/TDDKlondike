import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import models.Card;
import models.CardType;

import org.junit.Test;

import controllers.MoveController;


public class MoveControllerTest {

	private MoveController moveController;
		
	@Test
	public void testMoveDrawToWaste() {
		moveController = new MoveController(2,2);
		moveController.moveFromDrawToWaste();		
		assertEquals(1, moveController.getDraw().getCards().size());
		assertEquals(3, moveController.getWaste().getCards().size());
		
		moveController = new MoveController(1,3);
		moveController.moveFromDrawToWaste();		
		assertEquals(1, moveController.getDraw().getCards().size());
		assertEquals(3, moveController.getWaste().getCards().size());
		
		moveController = new MoveController(0,3);
		moveController.moveFromDrawToWaste();		
		assertEquals(0, moveController.getDraw().getCards().size());
		assertEquals(3, moveController.getWaste().getCards().size());	
		
		moveController = new MoveController(20,0);
		moveController.moveFromDrawToWaste();		
		assertEquals(17, moveController.getDraw().getCards().size());
		assertEquals(3, moveController.getWaste().getCards().size());
		
		moveController = new MoveController(20,2);
		moveController.moveFromDrawToWaste();		
		assertEquals(19, moveController.getDraw().getCards().size());
		assertEquals(3, moveController.getWaste().getCards().size());
	}
	
	@Test
	public void testMoveWasteToFoundation(){
		moveController = new MoveController(0,0);
		Card card1 = new Card(10,CardType.CLUB,true);
		Card card2 = new Card(10,CardType.HEART,true);
		Card card3 = new Card(10,CardType.SPADE,true);
		List<Card> cards = new ArrayList<Card>();
		cards.add(card1);
		cards.add(card2);
		cards.add(card3);
		this.moveController.getWaste().assignCards(cards);
		
		this.moveController.moveFromWasteToFoundation(CardType.HEART);
	}

}
