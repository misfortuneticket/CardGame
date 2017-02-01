import java.util.ArrayList;
import java.util.Collections;

class Test
{
   public static void main(String[] args) 
   {
      Deck deck  = new Deck();
      Hand hand1 = new Hand();
      deck.Shuffle();
      hand1.addCard(deck.dealCard());
      hand1.addCard(deck.dealCard());
                  
      System.out.println(hand1.printHand()); 
      System.out.println(hand1.handValue());
     
	}
}
