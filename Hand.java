import java.util.ArrayList;



public class Hand
{
  int value = 0;
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
   
   public String printHand()
   {
      String thisHand = "";
      
      for (int i = 0; i < hand.size(); i++)
      {
         thisHand = thisHand + hand.get(i).getBoth() + ", ";
      }
      return thisHand;
   }

   public int handValue()
   {    value = 0;

       boolean containsAce = false;
       for (int i = 0; i < hand.size(); i++)
        { 
         if (hand.get(i).getRank()==1)
            {
             containsAce = true;
             value = value + 10;
            }
         if (hand.get(i).getRank()<10)
            {
             value = value + hand.get(i).getRank();
            }
         if (hand.get(i).getRank()>=10)
            {
             value = value + 10;
            }
        }
        return value;
   }
   
   public int returnValue()
   {
   return value;
   }
   public void setValue(int v)
   {
   v = value;
   }
}
