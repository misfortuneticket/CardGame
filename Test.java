import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


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
      String nameinput1 = JOptionPane.showInputDialog(null, "Player 1, What's your name?");
      Player player1 = new Player(nameinput1);
      
      String nameinput2 = JOptionPane.showInputDialog(null, "Player 2, What's your name?");
      Player player2 = new Player(nameinput2);
      
      
      
      ///////////////////////////////////////////
      //        player 1's turn
       
      JOptionPane.showMessageDialog(null,player1.playerName()+"'s Hand: "+hand1.printHand()+"\nHand Value: "+hand1.handValue());
      int input1=JOptionPane.showOptionDialog(null,"Would you like another card?","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);

      while (gameOver1 == false)
      {   

          if (input1==JOptionPane.YES_OPTION)
          {
              hand1.addCard(deck.dealCard());
              JOptionPane.showMessageDialog(null,player1.playerName()+"'s Hand: "+hand1.printHand()+"\nHand Value: "+hand1.handValue());

              if (hand1.handValue()>21)
              {   
                  JOptionPane.showMessageDialog(null,"hand Value: "+hand1.handValue()+"BUST");
                  gameOver1 = true;
                  input1 =JOptionPane.NO_OPTION;
              }
              
              if (hand1.handValue()==21)
              {   
                  JOptionPane.showMessageDialog(null,"BLACKJACK!!!");
                  gameOver1 = true;
                  input1 =JOptionPane.NO_OPTION;
              }
              
              if (hand1.handValue()<21) 
              {
              input1=   JOptionPane.showOptionDialog(null," Would you like another card?","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);
              }
          }
          
          else if (input1 == JOptionPane.NO_OPTION) 
          {
              gameOver1 = true;
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
          JOptionPane.showMessageDialog(null,player2.playerName()+"'s Hand: "+hand2.printHand()+"\nHand Value: "+hand2.handValue());
          int input2=JOptionPane.showOptionDialog(null," Would you like another card?","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);

          while (gameOver2 == false)
          {   

              if (input2==JOptionPane.YES_OPTION)
              {   
                  hand2.addCard(deck.dealCard());
                  JOptionPane.showMessageDialog(null,player2.playerName()+"'s Hand: "+hand2.printHand()+"\nHand Value: "+hand2.handValue());

                  if (hand2.handValue()>21)
                  {
                       JOptionPane.showMessageDialog(null,"hand Value: "+hand1.handValue()+"BUST");
                       input2 = JOptionPane.NO_OPTION;
                       gameOver2 = true;
                  }
                  
                  if (hand2.handValue()==21)
                  {   
                       JOptionPane.showMessageDialog(null,"BLACKJACK!!!");
                       gameOver2 = true;
                       input2 =JOptionPane.NO_OPTION;
                  }
                  if (hand2.handValue()<21) 
                  {
                       input2 = JOptionPane.showOptionDialog(null," Would you like another card?","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);                  }
                  }
          
          
              else if (input2==JOptionPane.NO_OPTION) 
              {
                  gameOver2 = true;
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
          JOptionPane.showMessageDialog(null,nameinput1 + "'s score: " + player1.getScore());
          JOptionPane.showMessageDialog(null,nameinput2 + "'s score: " + player2.getScore());
         
          if (player1.getScore()<=21&&player1.getScore()>player2.getScore())
          {
              JOptionPane.showMessageDialog(null,player1.playerName()+" WINS!!!!!");
          }
          if (player2.getScore()>21&&player1.getScore()<=21)
          {
              JOptionPane.showMessageDialog(null,player1.playerName()+" WINS!!!!!");
          }
          if (player2.getScore()<=21&&player1.getScore()<player2.getScore())
          {
              JOptionPane.showMessageDialog(null,player2.playerName()+" WINS!!!!!");
          }
          if (player1.getScore()>21&&player2.getScore()<=21)
          {
              JOptionPane.showMessageDialog(null,player2.playerName()+" WINS!!!!!");
          }
          if ((player1.getScore()==player2.getScore()&&player1.getScore()<=21&&player2.getScore()<=21)||(player2.getScore()>21&&player1.getScore()>21))
          {
              JOptionPane.showMessageDialog(null,"IT'S A TIE");
          }
      }
  } 
   
   
      }

