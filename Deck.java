import java.util.*;

public class Deck
{
	private ArrayList<Card> arrayOfCards = new ArrayList<Card>();

	// Constructor
	public Deck()
	{
		for (int i = 1; i <= 4; i++)
		{
			for (int j = 1; j <= 13; j++)
			{
				arrayOfCards.add(new Card(j, i));
			}
		}
	}

	// methods
	public void shuffle()
	{
		Collections.shuffle(arrayOfCards);
	}

	public Card draw()
	{
		Card topCard = arrayOfCards.get(0);
		arrayOfCards.remove(0);
		// return arrayOfCards.get(0);
		return topCard;
	}
}
