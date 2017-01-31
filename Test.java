import java.util.ArrayList;
import java.util.Collections;

class Test
{
   public static void main(String[] args) 
   {
      Deck deck  = new Deck();
      Hand hand1 = new Hand();
      
      hand1.addCard(deck.dealCard());
      
      System.out.println();
      System.out.println(deck.printAll());      
	}
}
