import java.util.*;

public class Card
{
	// object fields
	private int rank;
	//1-13
	private int suit;
	//1 - 4 (Spades, Hearts, Clubs, Diamonds)
	private int value;
	//1-10..., 11, 

	// constructor
	public Card(int r, int s)
	{
		rank = r;
		suit = s;
		if (r <= 10 && r != 1)
		{
			value = r;
		}
		else if (r == 1)
		{
			value = 11;
		}
		else
		{
			value = 10;
		}
	}

	// methods
	public int getRank()
	{
		return rank;
	}

	public int getSuit()
	{
		return suit;
	}

	public int getValue()
	{
		return value;
	}

	public void setRank(int x)
	{
		rank = x;
	}

	public void setSuit(int x)
	{
		suit = x;
	}

	public void setValue(int x)
	{
		value = x;
	}

	public String toString()
	{
		String suitString;
		suitString = "";
		if (suit == 1)
		{
			suitString = "Spades";
		}
		else if (suit == 2)
		{
			suitString = "Hearts";
		}
		else if (suit == 3)
		{
			suitString = "Clubs";
		}
		else if (suit == 4)
		{
			suitString = "Diamonds";
		}
		if (rank <= 10 && rank != 1)
		{
			return "Card: " + rank + " of " + suitString;
		}
		else if (rank == 1)
		{
			return "Card: Ace of " + suitString;
		}
		else if (rank == 11)
		{
			return "Card: Jack of " + suitString;
		}
		else if (rank == 12)
		{
			return "Card: Queen of " + suitString;
		}
		else if (rank == 13)
		{
			return "Card: King of " + suitString;
		}
		return "";
	}
}