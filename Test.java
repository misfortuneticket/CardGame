import java.util.ArrayList;
import java.util.Collections;

class Test
{
   public static void main(String[] args) 
   {
   
      Deck deck  = new Deck();
      Hand hand1 = new Hand();
      Hand hand2 = new Hand();
      deck.Shuffle();
      hand1.addCard(deck.dealCard());
      hand1.addCard(deck.dealCard());
      hand2.addCard(deck.dealCard());
      hand2.addCard(deck.dealCard());
      
      System.out.println("Player 1 Enter Name:");
      String nameinput1 = System.console().readLine();
      Player player1 = new Player(nameinput1);
      System.out.println("Player 2 Enter Name:");
      String nameinput2 = System.console().readLine();
      Player player2 = new Player(nameinput2);
      
      PrintHandStatus(hand1,1);
      
      boolean yes1 = false;
      boolean gameOver1 = false;
      while (gameOver1 == false)
      { 
          System.out.println("Would you like another card? (Y/N)");  
          String input = System.console().readLine();
          if (input.equals("Y")){yes1 = true;}
          else {gameOver1 = true;}
          if (yes1 == true) 
          {
              hand1.addCard(deck.dealCard());
              PrintHandStatus(hand1,1);
              if (hand1.handValue()>=21)
              {
                   gameOver1 = true;
              }
              yes1 = false;
          }
      }
      
      if (gameOver1 == true)
      {
          boolean yes2 = false;
          boolean gameOver2 = false;
          while (gameOver2 == false)
          { 
             System.out.println("Would you like another card? (Y/N)");  
             String input = System.console().readLine();
             if (input.equals("Y")){yes2 = true;}
             else {gameOver2 = true;}
             if (yes2 == true) 
             {
                 hand1.addCard(deck.dealCard());
                 PrintHandStatus(hand2,2);
                 if (hand2.handValue()>=21)
                 {
                      gameOver2 = true;
                 }
                 yes2 = false;
             }
         }
 
 
	   }
   }
   
   
   
   
   private static void PrintHandStatus(Hand hand, int pl)
   {
      System.out.println("Player "+ pl+ "'s Hand:"); 
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
