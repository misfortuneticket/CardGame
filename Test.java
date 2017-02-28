import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Test
{
  
   
   
   public static void main(String[] args) 
   {
      ///////////////////////////////////////////
      //         setup
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
      boolean wholeGameOver = false;
      
      
      ///////////////////////////////////////////
      //         takes player names
      String nameinput1 = JOptionPane.showInputDialog(null, "Player 1, What's your name?");
      Player player1 = new Player(nameinput1);
      
      String nameinput2 = JOptionPane.showInputDialog(null, "Player 2, What's your name?");
      Player player2 = new Player(nameinput2);
      
      
      
      ///////////////////////////////////////////
      //        player 1's turn
   while (wholeGameOver == false)   {
    
      //re-setup
      gameOver1 = false;
      gameOver2 = false;

      hand1.clearHand();
      hand2.clearHand();
      player1.setScore(0);
      player2.setScore(0);
      deck.Shuffle();
      hand1.addCard(deck.dealCard());
      hand1.addCard(deck.dealCard());
      hand2.addCard(deck.dealCard());
      hand2.addCard(deck.dealCard());
      JOptionPane.showMessageDialog(null,player1.playerName()+"'s Hand: "+hand1.printHand()+"\nHand Value: "+hand1.handValue());
      int input1=JOptionPane.showOptionDialog(null,"Would you like another card?","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);

      while (gameOver1 == false)
      {   player1.setScore(hand1.handValue());

          if (input1==JOptionPane.YES_OPTION)
          {   
              hand1.addCard(deck.dealCard());
              JOptionPane.showMessageDialog(null,player1.playerName()+"'s Hand: "+hand1.printHand()+"\nHand Value: "+hand1.handValue());

              if (hand1.handValue()>21)
              {   
                  JOptionPane.showMessageDialog(null,"hand Value: "+hand1.handValue()+"\nBUST");
                  gameOver1 = true;
                  input1 =JOptionPane.NO_OPTION;
              }
              
              if (hand1.handValue()>20&&hand1.handValue()<22)
              {   
                  JOptionPane.showMessageDialog(null,"BLACKJACK!!!");
                  gameOver1 = true;
                  input1 =JOptionPane.NO_OPTION;
              }
              
              if (hand1.handValue()<=20) 
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
                       JOptionPane.showMessageDialog(null,"hand Value: "+hand1.handValue()+"\nBUST");
                       input2 = JOptionPane.NO_OPTION;
                       gameOver2 = true;
                  }
                  
                  if (hand2.handValue()>20&&hand2.handValue()<22)
                  {   
                       JOptionPane.showMessageDialog(null,"BLACKJACK!!!");
                       gameOver2 = true;
                       input2 =JOptionPane.NO_OPTION;
                  }
                  if (hand2.handValue()<=20) 
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
         
         // evaluates who won
          if (player1.getScore()<=21&&player1.getScore()>player2.getScore())
          {
              JOptionPane.showMessageDialog(null,player1.playerName()+" WINS!!!!!");
              player1.increaseScore();
          }
          if (player2.getScore()>21&&player1.getScore()<=21)
          {
              JOptionPane.showMessageDialog(null,player1.playerName()+" WINS!!!!!");
              player1.increaseScore();
          }
          if (player2.getScore()<=21&&player1.getScore()<player2.getScore())
          {
              JOptionPane.showMessageDialog(null,player2.playerName()+" WINS!!!!!");
              player2.increaseScore();
          }
          if (player1.getScore()>21&&player2.getScore()<=21)
          {
              JOptionPane.showMessageDialog(null,player2.playerName()+" WINS!!!!!");
              player2.increaseScore();
          }
          if ((player1.getScore()==player2.getScore()&&player1.getScore()<=21&&player2.getScore()<=21)||(player2.getScore()>21&&player1.getScore()>21))
          {
              JOptionPane.showMessageDialog(null,"IT'S A TIE");
          }
          
          JOptionPane.showMessageDialog(null,player1.playerName()+"'s score:"+player1.getfin()+"\n"+player2.playerName()+"'s score:"+player2.getfin());
          int again=JOptionPane.showOptionDialog(null,"Would you like to play again?","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);
          
          // when the whole game is over
          if (again == JOptionPane.NO_OPTION)
          {
                JOptionPane.showMessageDialog(null,"And the winner is.....");
                if (player1.getfin()>player2.getfin())
                  {
                   JOptionPane.showMessageDialog(null,player1.playerName()+"!!!");
                  }
                if (player1.getfin()<player2.getfin())
                  {
                   JOptionPane.showMessageDialog(null,player2.playerName()+"!!!");
                  }
                  if (player1.getfin()==player2.getfin())
                  {
                   JOptionPane.showMessageDialog(null,"It's a tie.");
                  }
               wholeGameOver = true;      
          }
      }
    }
  }   
}

