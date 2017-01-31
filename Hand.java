import java.util.ArrayList;



public class Hand
{
  public ArrayList<Card> hand = new ArrayList<Card>();

   public Hand() 
   {
   
   }
   
   public void addCard(Card card)
   {
    hand.add(card);
   }
   
   public boolean emptyHand()
   {
      if (hand.size() == 0) 
       {
        return true;
       }
       
       else 
       {
        return false;
       }
   }
   
   public void clearHand()
   {
   hand.clear();
   }
}