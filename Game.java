public class Game
{
	public static void main(String[] args)
	{
		BlackJack x = new BlackJack();
		while(true)
		{
			
			x.run();
			x.getBet();
			if (x.getAmount() >= 0 && !x.getBroke())
			{
				x.playerTurn();
				x.dealerTurn();
				x.winLose();
			}
			else
			{
				break;
			}
		}
		System.exit(0);
	}
}