import java.util.*;

public class Hand
{
	private ArrayList<Card> arrayOfCards = new ArrayList<Card>();
	// object fields
	private int totalValue;
	private boolean isDealer;
	private boolean over21;

	// constructor
	public Hand(boolean dealer)
	{
		if (dealer)
		{
			isDealer = true;
		}
		else
		{
			isDealer = false;
		}
	}

	// object methods
	public void addCard(Card drawnCard)
	{
		arrayOfCards.add(drawnCard);
		totalValue += drawnCard.getValue();
		if (totalValue > 21)
		{
			over21 = true;
		}
	}
	
	public void clearHand()
	{
		arrayOfCards.clear();
		totalValue = 0;
	}

	public int getTotalValue()
	{
		return totalValue;
	}
	
	public Card getFirstCard()
	{
		return arrayOfCards.get(0);
	}
	
	//toString method
	public String toString()
	{
		String handInText = ""; 
		
		if(isDealer)
		{
			handInText += "Dealer's Hand: \n	Card: [REDACTED]\n";
			for(int i = 1; i < arrayOfCards.size(); i++)
			{
				handInText +=  "	" + arrayOfCards.get(i);
				handInText += "\n";
			}
		}
		else
		{
			handInText = "Player's Hand: \n";
			for(int i = 0; i < arrayOfCards.size(); i++)
			{
				handInText +=  "	" + arrayOfCards.get(i);
				handInText += "\n";	
			}
			handInText += "	Current Total: " + totalValue;
		}
					
		
		
		return handInText;			
	}
	
}