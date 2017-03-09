package pkgPokerBLL;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgPokerEnum.eHandStrength;
import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

public class TestHands {

	@Test
	public void TestFullHouse() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		
		//	Hand better be a full house
		assertEquals(eHandStrength.FullHouse.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		
		//	Full House has no kickers.
		assertEquals(0,h.getHandScore().getKickers().size());
	}
	
		
		
		public void TestStraightFlush() {

			Hand h = new Hand();
			h.AddCardToHand(new Card(eRank.FOUR, eSuit.CLUBS));
			h.AddCardToHand(new Card(eRank.FIVE, eSuit.CLUBS));
			h.AddCardToHand(new Card(eRank.SIX, eSuit.CLUBS));
			h.AddCardToHand(new Card(eRank.SEVEN, eSuit.CLUBS));
			h.AddCardToHand(new Card(eRank.EIGHT, eSuit.CLUBS));
			h.EvaluateHand();

			assertEquals(eHandStrength.FourOfAKind.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

			assertEquals(eRank.EIGHT.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());
			assertEquals(eRank.FOUR.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

			assertEquals(0, h.getHandScore().getKickers().size());
	
		
	}
		
		@Test // Tests Positions 1, 2, 3, 4, and 5 for a Straight
		public void TestStraight() {

			Hand h = new Hand();
			h.AddCardToHand(new Card(eRank.FIVE, eSuit.CLUBS));
			h.AddCardToHand(new Card(eRank.SIX, eSuit.DIAMONDS));
			h.AddCardToHand(new Card(eRank.SEVEN, eSuit.HEARTS));
			h.AddCardToHand(new Card(eRank.EIGHT, eSuit.DIAMONDS));
			h.AddCardToHand(new Card(eRank.NINE, eSuit.SPADES));
			h.EvaluateHand();

			assertEquals(eHandStrength.Straight.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

			assertEquals(eRank.NINE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());
			assertEquals(eRank.FIVE.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

			assertEquals(0, h.getHandScore().getKickers().size());
		}

		@Test // Tests Positions 1, 2, 3, 4, and 5 for a High-Ace Straight
		public void TestStraightA() {

			Hand h = new Hand();
			h.AddCardToHand(new Card(eRank.TEN, eSuit.CLUBS));
			h.AddCardToHand(new Card(eRank.JACK, eSuit.DIAMONDS));
			h.AddCardToHand(new Card(eRank.QUEEN, eSuit.HEARTS));
			h.AddCardToHand(new Card(eRank.KING, eSuit.DIAMONDS));
			h.AddCardToHand(new Card(eRank.ACE, eSuit.SPADES));
			h.EvaluateHand();

			assertEquals(eHandStrength.Straight.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

			assertEquals(eRank.ACE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());
			assertEquals(eRank.TEN.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

			assertEquals(0, h.getHandScore().getKickers().size());
		}

		@Test // Tests Positions 1, 2, 3, 4, and 5 for a Low-Ace Straight
		public void TestStraighta() {

			Hand h = new Hand();
			h.AddCardToHand(new Card(eRank.ACE, eSuit.CLUBS));
			h.AddCardToHand(new Card(eRank.TWO, eSuit.DIAMONDS));
			h.AddCardToHand(new Card(eRank.THREE, eSuit.HEARTS));
			h.AddCardToHand(new Card(eRank.FOUR, eSuit.DIAMONDS));
			h.AddCardToHand(new Card(eRank.FIVE, eSuit.SPADES));
			h.EvaluateHand();

			assertEquals(eHandStrength.Straight.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

			assertEquals(eRank.FIVE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());
			assertEquals(eRank.ACE.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

			assertEquals(0, h.getHandScore().getKickers().size());
		}
}