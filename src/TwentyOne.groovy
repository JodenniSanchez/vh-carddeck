// Rules for 21
// Two players: One is a player and the other is the dealer.
// The dealer deals two cards to each player. 
// Values of cards range from 2 to 11.
// Jacks, Queens, and Kings are all worth 10 points.
// Each player (including the dealer) decides whether he or she wants to "hit" or "pass".

import Deck
import Card

def deck = new Deck(true) // passing true makes it a 21 deck

def console = System.console()

deck.shuffle()

def h1 = deck.deal(2)
def h2 = deck.deal(2)
println (h1)
println (h2)

int p1p = handCount(h1)
int p2p = handCount(h2)

println ("Player 1's points: " + p1p)
println ("Player 2's points: " + p2p)

	int i = 0
	int z = 0

while (p1p < 21 && p2p < 21)
{
	boolean pass = false
	boolean pass2 = false

	//// PLAYER 1 -- MAKE THIS A FUNCTION AND CALL IT HERE
    println("Player 1 has " + p1p)
	println("Player 1: Would you like to hit or pass? (enter 1 or 2)")
	String choice = console.readLine()
	if (choice == "1")
	{
	    h1.addAll(deck.deal())
	    p1p = handCount(h1)
	}
	if (choice == "2")
	{
		pass = true
		println("No action taken")
	}

	//// PLAYER 2 -- CALL THE FUNCTION YOU WROTE ABOVE HERE
    println("Player 2 has " + p2p)
	println("Player 2: Would you like to hit or pass? (enter 1 or 2)")
	int choice2 = console.readLine()
	if (choice2 == "1")
	{
	    h2.addAll(deck.deal())
	    p2p = handCount(h2)
	    print(h2)
	}
	if (choice2 == "2")
	{
		pass2 = true
		println("No action taken")
	}

	if (pass == true && pass2 == true)
	{
		break
	}
}

if ((p1p > p2p) || (p2p > 21 && p1p <= 21))
{
	println("Player 1 wins. The real MVP")
	println("Player 2 loses. Scrub.")
}

if ((p2p > p1p) || (p1p > 21 && p2p <= 21))
{
	println("Player 2 wins. The real MVP")
	println("Player 1 loses. Scrub.")
}

if (p1p == p2p)
{
	println("Player 1 and Player 2 have tied. Both are scrubs.")
}

if (p1p > 21 && p2p > 21)
{
	println("Both of you scrubs went over the limit (21). You both lose.")
}

static def handCount(hand)
{
	int count = 0
	for (Card c : hand)
	{
		count += c.rank
	}
	return count
}