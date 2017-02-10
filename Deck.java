import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class Deck
{

   ArrayList<Card> deck = new ArrayList<Card>();
   
   public Deck()
   {
      Card card = new Card(1,"H");

      for (int i = 1; i < 14; i++)
      {  
         card = new Card(i,"H");
         deck.add(card);
         card = new Card(i,"S");
         deck.add(card);
         card = new Card(i,"C");
         deck.add(card);
         card = new Card(i,"D");
         deck.add(card);
      }
   }
   
   
   public void Shuffle()
   {
       Collections.shuffle(deck);
   }
   
   
   public Card getTopCard()
   {
        return deck.get(0);
   }
  
   public String printAll()
   {
      String wholeDeck = "";
      
      for (int i = 0; i < deck.size(); i++)
      {
         wholeDeck = wholeDeck + deck.get(i).getBoth() + ", ";
      }
      return wholeDeck;
   }
   
   
   public void removeTopCard()
   {
      deck.remove(0);
   }
   
   public Card dealCard()
   {
      Card topCard = getTopCard();
      removeTopCard();
      return topCard;
   }
}