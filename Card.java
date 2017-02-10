public class Card
{
   int rank;
   String suit; 
   
   public Card(int cardrank, String cardsuit)
   {
      rank = cardrank;
      suit = cardsuit;
   }
   
   public void setSuit(String st)
   {
      suit = st;
   }
   
   public int getRank()
   {
      return rank;
   }
    
   public String getSuit()
   {
      return suit;
   }
       
   public String getBoth()
   {
      return rank + suit;
   }
   
}
