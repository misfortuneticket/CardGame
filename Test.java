import java.util.ArrayList;
import java.util.Collections;

class Test
{
   public static void main(String[] args) 
   {
   
      Deck deck  = new Deck();
      deck.Shuffle();
      
      Hand hand1 = new Hand();
      Hand hand2 = new Hand();
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
      
      PrintHandStatus(hand1,player1.playerName(),player1);
      
      boolean gameOver1 = false;
      boolean gameOver2 = false;
      
      while (gameOver1 == false)
      {   
          System.out.println("Would you like another card? (Y/N)");  
          String input1 = System.console().readLine();
          if (input1.equals("Y"||"y"))
          {
              hand1.addCard(deck.dealCard());
              hand1.value = 0;
              PrintHandStatus(hand1,player1.playerName(),player1);
              if (hand1.returnValue()>=21)
              {
                   player1.setScore(0);
                   gameOver1 = true;
              }
          }
          
          else {gameOver1 = true;}

          if (gameOver1 == true)
          {
              player1.setScore(hand1.returnValue());
          }
      }
      
      
      if (gameOver1 == true)
      {   
          PrintHandStatus(hand2, player2.playerName(),player2);
          while (gameOver2 == false)
          { 
             System.out.println("Player 2, Would you like another card? (Y/N)");  
             String input2 = System.console().readLine();
             if (input2.equals("Y"))
             {
                 hand2.addCard(deck.dealCard());
                 hand2.value = 0;
                 PrintHandStatus(hand2,player2.playerName(),player2);
                 if (hand2.handValue()>=21)
                 {   
                      gameOver2 = true;
                 }
             }
             else {gameOver2 = true;}             
         }
 
         if (gameOver2 == true)
         {
            player2.setScore(hand2.returnValue());
         }

	   }
      
      if (gameOver1==true && gameOver2==true)
      {  if (player1.bust == true){player1.setScore(0);}
         if (player2.bust == true){player2.setScore(0);}
         System.out.println(nameinput1 + "'s score: "+player1.getScore());
         System.out.println(nameinput2 + "'s score: "+player2.getScore());
         if (player1.getScore() > player2.getScore())
         {
         System.out.println("PLAYER 1 WINS!!!!!");
         }
         if (player1.getScore() < player2.getScore())
         {
         System.out.println("PLAYER 2 WINS!!!!!");
         }
         if (player1.getScore() == player2.getScore())
         {
         System.out.println("ITS A TIE");
         }
      }
   }
   
   
   
   private static void PrintHandStatus(Hand hand, String pl, Player player)
   {
      System.out.println(pl + "'s Hand:"); 
      System.out.println(hand.printHand());
      System.out.println("Total Value:"); 
      System.out.println(hand.handValue());
      if (hand.returnValue()>=22)
      
      {
          System.out.println("BUST");
          player.bust = true;
          System.out.println(hand.returnValue());
      }
      if (hand.returnValue()==21)
      {
          System.out.println("BLACKJACK"); 
      }
   }
}
