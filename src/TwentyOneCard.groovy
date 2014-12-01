class TwentyOneCard extends Card
{
    /**
     * Constructor
     * rank can be 2, 3, ..., 10, JACK, QUEEN, KING, ACE
     * suit can be CLUBS, DIAMONDS, HEARTS, SPADES
     */
    public TwentyOneCard (int rank, Suit suit)
    {
        super(rank, suit)
    }

    def int getRank()
    {
        int superRank = super.getRank()
        if (superRank == ACE)
        {
            return 11
        }
        if (superRank > 10)
        {
            return 10
        }
        return superRank
    }
}
