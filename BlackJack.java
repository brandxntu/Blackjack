import java.util.*;

public class BlackJack
{
	// Object variables
	private int amount = 100;
	private int bet;
	private String winner;
	private boolean busted = false;
	private boolean betted = false;
	private boolean broke = false;
	
	private Hand playerhand = new Hand(false);
	private Hand dealerhand = new Hand(true);
	// Scanner
	Scanner scan = new Scanner(System.in);
	public static Deck d = new Deck();

	public int getAmount()
	{
		return amount;
	}
	
	public boolean getBroke()
	{
		return broke;
	}
	
	public void run()
	{
		d.shuffle();
		playerhand.clearHand();
		dealerhand.clearHand();
		playerhand.addCard(d.draw());
		playerhand.addCard(d.draw());
		dealerhand.addCard(d.draw());
		dealerhand.addCard(d.draw());
		System.out.println("Thank you for playing blackjack! You have $" + amount + "!");
		busted = false;
		bet = 0;
		
	}
	
	

	// Object methods
	public void getBet()
	{
		betted = false;
		while (!betted)
		{
			if(amount == 0)
			{
				System.out.print("You have no more money ~ Game over!");
				broke = true;
				break;
			}
			else
			{
				System.out.print("How much would you like to bet? ");
				String betNumberStr = scan.nextLine();
				int	betNumber;
				try 
				{
					betNumber = Integer.parseInt(betNumberStr);
				} catch (NumberFormatException e) {
					System.out.println("Please input an integer"); 
					continue;
				}
				if (betNumber > 0 && betNumber <= amount)
				{
					bet = betNumber;
					amount -= bet;
					System.out.println("You now have $" + amount);
					betted = true;
					
					if(amount == 0)
					{
						broke = false;
						System.out.println("You're all in!");
					}
					
				}
				else
				{
					System.out.println("Invalid input!");
				}
//				scan.nextLine();
			}
		}
	}

	public void playerTurn()
	{
		System.out.print(playerhand);
		System.out.print("\n");
		System.out.print(dealerhand);
		//System.out.print(dealerhand.getTotalValue());
		System.out.print("\nWould you like to hit or stand?");
		String hitStand;
		while (true)
		{
			if (playerhand.getTotalValue() < 21)
			{
				hitStand = scan.nextLine();
				if (hitStand.equals("Hit") || hitStand.equals("hit"))
				{
					playerhand.addCard(d.draw());
					System.out.println(playerhand);
					if(playerhand.getTotalValue() < 21)
					{
						System.out.println("Would you like to hit or stand?");
					}
					
				}
				else if (hitStand.equals("Stand") || hitStand.equals("stand"))
				{
					break;
				}
				else
				{
					System.out.println("Invalid input! Would you like to hit or stand?");
				}
			}
			else if (playerhand.getTotalValue() == 21)
			{
				System.out.println("\nYou have blackjack! On to the opponents turn now");
				break;
			}
			else
			{
				winner = "dealer";
				busted = true;
				System.out.println("You have busted");
				break;
			}
		}
	}

	public void dealerTurn()
	{
		while (true)
		{
			if (dealerhand.getTotalValue() > 21 && busted == false)
			{
				winner = "player";
				System.out.println("The dealer has busted and the player has won!");
				System.out.println("Dealer's First " + dealerhand.getFirstCard() + "\nHis total value was " + dealerhand.getTotalValue());
				break;
			}
			else if (dealerhand.getTotalValue() > playerhand.getTotalValue() && busted == false)
			{
				winner = "dealer";
				System.out.println("The dealer has won!");
				System.out.println("Dealer's First " + dealerhand.getFirstCard() + "\nHis total value was " + dealerhand.getTotalValue());
				break;
			}
			else if (busted == false && dealerhand.getTotalValue() == playerhand.getTotalValue())
			{	
				winner = "tie";
				System.out.println("Tie!");
				System.out.println("Dealer's First " + dealerhand.getFirstCard() + "\nHis total value was " + dealerhand.getTotalValue());
				break;
			}
			else
			{
				if(busted == false)
				{
					System.out.println("The dealer has decided to hit!");
					dealerhand.addCard(d.draw());
					System.out.println(dealerhand);
					//System.out.println(dealerhand.getTotalValue());
				}
				else
				{
					break;
				}
				
			}
		}
	}
	
	public void winLose()
	{
		if(winner == "player")
		{
			amount += bet*2;
		}
		else if(winner == "tie")
		{
			amount += bet;
		}
		else
		{		
		}
		System.out.println("Money: $" + amount);
	}
}
