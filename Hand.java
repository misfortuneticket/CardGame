import java.util.ArrayList;

public class Hand
{

    public ArrayList<Card> hand = new ArrayList<Card>();

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
      String thisHand="";
      
      for (int i = 0; i < hand.size(); i++)
      {
         thisHand = thisHand + hand.get(i).getBoth() + ", ";
      }
      return thisHand;
    }

    public int handValue()
    {  int  value = 0;

       boolean containsBigAce = false;
       for (int i = 0; i < hand.size(); i++)
        { 
         if (hand.get(i).getRank()==1)
            {
             containsBigAce = true;
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
         if (containsBigAce==true&&value>21)
            {
              value = value - 10;
              containsBigAce = false;

            }
        }
        return value;
    }
 }
