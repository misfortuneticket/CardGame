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
      
      boolean gameOver1 = false;
      boolean gameOver2 = false;
      
      ///////////////////////////////////////////
      //         takes player names
      System.out.println("Player 1 Enter Name:");
      String nameinput1 = System.console().readLine();
      Player player1 = new Player(nameinput1);
      
      System.out.println("Player 2 Enter Name:");
      String nameinput2 = System.console().readLine();
      Player player2 = new Player(nameinput2);
      
      
      
      ///////////////////////////////////////////
      //        player 1's turn
       
      PrintHandStatus(hand1,player1);
      System.out.println("Would you like another card? (Y/N)");      
      String input1 = System.console().readLine();
      
      while (gameOver1 == false)
      {   
          if (input1.equals("Y")||input1.equals("y"))
          {
              hand1.addCard(deck.dealCard());
              PrintHandStatus(hand1,player1);
              
              if (hand1.handValue()>=21)
              {
                  gameOver1 = true;
                  input1 = "N";
              }
              if (hand1.handValue()<21) 
              {
                  System.out.println("Would you like another card? (Y/N)");  
                  input1 = System.console().readLine();
              }
          }
          
          if (input1.equals("N")||input1.equals("n")) 
          {
              gameOver1 = true;
          }
          
          else 
          {
              System.out.println("Invalid response");
              System.out.println("Would you like another card? (Y/N)");  
          }

          if (gameOver1 == true)
          {
              player1.setScore(hand1.handValue());
          }
         
      }
      
 
 
      ///////////////////////////////////////////
      //        Player 2's turn 
       
      if (gameOver1 == true)
      {   
          String n = System.console().readLine();
          PrintHandStatus(hand2,player2);
          System.out.println("Player 2, Would you like another card? (Y/N)");  
          String input2 = System.console().readLine();
          while (gameOver2 == false)
          {   

              if (input2.equals("Y")||input2.equals("y"))
              {
                  hand2.addCard(deck.dealCard());
                  PrintHandStatus(hand2,player2);
              
                  if (hand2.handValue()>=21)
                  {
                      gameOver2 = true;
                      input2 = "N";
                  }
                  
                  if (hand2.handValue()<21) 
                  {
                      System.out.println("Would you like another card? (Y/N)");  
                      input2 = System.console().readLine();
                  }
              }
          
          
              if (input2.equals("N")||input2.equals("n")) 
              {
                  gameOver2 = true;
              }
               
               
              else 
              {
                  System.out.println("Invalid response");
                  System.out.println("Would you like another card? (Y/N)");  
              }
           }

          if (gameOver2 == true)
          {
              player2.setScore(hand2.handValue());
          }  
      }
      
      
      
      ///////////////////////////////////////////
      //      when the game is over    
      if (gameOver1==true && gameOver2==true)
      { 
          String n = System.console().readLine();
          System.out.println("");
          System.out.println(nameinput1 + "'s score: " + player1.getScore());
          System.out.println(nameinput2 + "'s score: " + player2.getScore());
          System.out.println("");
         
          if (player1.getScore()<=21&&player1.getScore()>player2.getScore())
          {
              System.out.println(player1.playerName()+" WINS!!!!!");
          }
          if (player2.getScore()>21&&player1.getScore()<=21)
          {
              System.out.println(player1.playerName()+" WINS!!!!!");
          }
          if (player2.getScore()<=21&&player1.getScore()<player2.getScore())
          {
              System.out.println(player2.playerName()+" WINS!!!!!");
          }
          if (player1.getScore()>21&&player2.getScore()<=21)
          {
              System.out.println(player2.playerName()+" WINS!!!!!");
          }
          if ((player1.getScore()==player2.getScore()&&player1.getScore()<=21&&player2.getScore()<=21)||(player2.getScore()>21&&player1.getScore()>21))
          {
              System.out.println("IT'S A TIE");
          }
      }
  } 
   
   
      ///////////////////////////////////////////
      //        PrintHandStatus()
      private static void PrintHandStatus(Hand hand, Player player)
      { 
         System.out.println(" ");
         System.out.println(player.playerName() + "'s Hand:"); 
         System.out.println(hand.printHand());
         System.out.println("Total Value:"); 
         System.out.println(hand.handValue());
       
         if (hand.handValue()>=22)  
         {
             System.out.println("BUST");
             System.out.println(hand.handValue());
         }
      
         if (hand.handValue()==21)
         {
          System.out.println("BLACKJACK"); 
      }
   }




}

