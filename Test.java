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
      System.out.println("Enter Name:");
      String nameinput = System.console().readLine();
      Player player1 = new Player(nameinput);
      PrintHandStatus(hand1);
      boolean yes = false;
      boolean gameOver = false;
      while (gameOver == false)
      { 
          System.out.println("Would you like another card? (Y/N)");  
          String input = System.console().readLine();
          if (input.equals("Y")){yes = true;}
          else {gameOver = true;}
          if (yes == true) 
          {
              hand1.addCard(deck.dealCard());
              PrintHandStatus(hand1);
              if (hand1.handValue()>=21)
              {
                   gameOver = true;
              }
              yes = false;
          }
      }
      
 
 
	}
   
   private static void PrintHandStatus(Hand hand)
   {
      System.out.println("Your Hand:"); 
      System.out.println(hand.printHand());
      System.out.println("Total Value:"); 
      System.out.println(hand.handValue());
      if (hand.handValue()>21)
      {
          System.out.println("BUST");
      }
      if (hand.handValue()==21)
      {
          System.out.println("BLACKJACK");  
      }
   }
}
