package pkgPokerBLL;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgPokerEnum.eHandStrength;
import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

public class TestHands {

	@Test
	public void TestRoyalFlush() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.KING,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.QUEEN,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.JACK,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.CLUBS));		
		h.EvaluateHand();
		
		assertEquals(eHandStrength.RoyalFlush.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		assertEquals(eRank.ACE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		assertEquals(eRank.TEN.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		
		assertEquals(0,h.getHandScore().getKickers().size());
	
	}

	@Test
	public void TestStraightFlush() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SEVEN,eSuit.DIAMONDS));		
		h.EvaluateHand();
		
		//	Hand better be a full house
		assertEquals(eHandStrength.StraightFlush.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Four'
		assertEquals(eRank.SEVEN.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		
		//	Full House has no kickers.
		assertEquals(0,h.getHandScore().getKickers().size());
	}	
	
	@Test
	public void TestFourOfAKind() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));		
		h.EvaluateHand();
		
		//	Hand better be a full house
		assertEquals(eHandStrength.FourOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		
		//	Full House has no kickers.
		assertEquals(1,h.getHandScore().getKickers().size());
	}	
	
	@Test
	public void TestFourOfAKind2() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));		
		h.EvaluateHand();
		
		//	Hand better be a full house
		assertEquals(eHandStrength.FourOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Four'
		assertEquals(eRank.SIX.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	LO hand better be 'Three'
		assertEquals(eRank.FIVE.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		
		//	Full House has no kickers.
		assertEquals(1,h.getHandScore().getKickers().size());
	}
	
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
	@Test
	public void TestThreeOfAKind() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();

		//	Hand better be a full house
		assertEquals(eHandStrength.ThreeOfAKind.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//	HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//	Full House has no kickers.
		assertEquals(2,h.getHandScore().getKickers().size());
}
	@Test
	public void TestHandFlush01() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.KING,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.HEARTS));	
		
		h.EvaluateHand();
		
		//Hand better be a Flush
		assertEquals(eHandStrength.Flush.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	
	
	@Test
	public void TestHandFlush02() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.TEN,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.KING,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.DIAMONDS));	
		
		h.EvaluateHand();
		
		//Hand better be a Flush
		assertEquals(eHandStrength.Flush.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	}
	
	public void TestStraight() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.HEARTS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.SPADES));		
		h.EvaluateHand();
		
		assertEquals(eHandStrength.Straight.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		assertEquals(eRank.TWO.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		assertEquals(0,h.getHandScore().getKickers().size());
	}
	
	@Test
	public void TestTwoPair() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SEVEN,eSuit.SPADES));		
		h.EvaluateHand();
		
		//		Hand better be a two pair
		assertEquals(eHandStrength.TwoPair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//		HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//		LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
	
		//		Two pairs has one kicker.
		assertEquals(1,h.getHandScore().getKickers().size());
		
		assertEquals(eRank.SEVEN,
				h.getHandScore().getKickers().get(0).geteRank());
	}
		
	@Test
	public void TestTwoPair2() {
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SEVEN,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SEVEN,eSuit.SPADES));		
		h.EvaluateHand();
		
		//		Hand better be a two pair
		assertEquals(eHandStrength.TwoPair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//		HI hand better be 'seven'
		assertEquals(eRank.SEVEN.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//		LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
	
		//		Two pairs has one kicker.
		assertEquals(1,h.getHandScore().getKickers().size());
		
		assertEquals(eRank.TWO,
				h.getHandScore().getKickers().get(0).geteRank());
	}
	
	@Test
	public void TestPair() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.NINE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.NINE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.SPADES));		
		h.EvaluateHand();
		
		//		Hand better be a pair
		assertEquals(eHandStrength.Pair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//		HI hand better be 'Four'
		assertEquals(eRank.NINE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
	
		//		Pair has three kickers.
		assertEquals(3,h.getHandScore().getKickers().size());
		
		assertEquals(eRank.EIGHT,
				h.getHandScore().getKickers().get(0).geteRank());
	}
	
	@Test
	public void TestPair2() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SIX,eSuit.SPADES));		
		h.EvaluateHand();
		
		//		Hand better be a pair
		assertEquals(eHandStrength.Pair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//		HI hand better be 'five'
		assertEquals(eRank.FIVE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
	
		//		Pair has three kickers.
		assertEquals(3,h.getHandScore().getKickers().size());
		
		assertEquals(eRank.SIX,
				h.getHandScore().getKickers().get(0).geteRank());
	}
	
	@Test
	public void TestPair3() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SEVEN,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.SEVEN,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.NINE,eSuit.SPADES));		
		h.EvaluateHand();
		
		//		Hand better be a pair
		assertEquals(eHandStrength.Pair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//		HI hand better be 'six'
		assertEquals(eRank.SEVEN.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
	
		//		Pair has three kickers.
		assertEquals(3,h.getHandScore().getKickers().size());
		
		assertEquals(eRank.NINE,
				h.getHandScore().getKickers().get(0).geteRank());
	}
	@Test
	public void TestPair4() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.NINE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SEVEN,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.SPADES));		
		h.EvaluateHand();
		
		//		Hand better be a pair
		assertEquals(eHandStrength.Pair.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//		HI hand better be 'nine'
		assertEquals(eRank.TWO.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
	
		//		Pair has three kickers.
		assertEquals(3,h.getHandScore().getKickers().size());
		
		assertEquals(eRank.NINE,
				h.getHandScore().getKickers().get(0).geteRank());
	}
	
	
	@Test
	public void HighCard() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.FIVE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.TWO,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.SEVEN,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		
		//		Hand better be a high card
		assertEquals(eHandStrength.HighCard.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
	
		//		High card has four kickers.
		assertEquals(5,h.getHandScore().getKickers().size());
		
		assertEquals(eRank.EIGHT,
				h.getHandScore().getKickers().get(0).geteRank());
	}
	
	@Test
	public void isAcesAndEights1() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.FOUR,eSuit.SPADES));		
		h.EvaluateHand();
		
		
		//		Hand better be a AcesAndEight
		assertEquals(eHandStrength.AcesAndEights.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//		LO hand better be 'EIGHT'
		assertEquals(eRank.EIGHT.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		
		//		HI hand better be 'ACE'
		assertEquals(eRank.ACE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
		
		//		 has one kicker.
		assertEquals(1,h.getHandScore().getKickers().size());
	
		//		Kicker better be 'FOUR'
		assertEquals(eRank.FOUR,
				h.getHandScore().getKickers().get(0).geteRank());
	}
	
	@Test
	public void isAcesAndEights2() {
		
		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.ACE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.ACE,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.NINE,eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.EIGHT,eSuit.CLUBS));		
		h.EvaluateHand();
		
		//		Hand better be a high card
		assertEquals(eHandStrength.AcesAndEights.getHandStrength(),
				h.getHandScore().getHandStrength().getHandStrength());
		
		//		LO hand better be 'EIGHT'
		assertEquals(eRank.EIGHT.getiRankNbr(),
				h.getHandScore().getLoHand().getiRankNbr());
		
		//		HI hand better be 'ACE'
		assertEquals(eRank.ACE.getiRankNbr(),
				h.getHandScore().getHiHand().getiRankNbr());
	
		//		AceAndEights has one kicker.
		assertEquals(1,h.getHandScore().getKickers().size());
		
		// 		Kicker better be 'NINE'
		assertEquals(eRank.NINE,
				h.getHandScore().getKickers().get(0).geteRank()); 
		
	}
}
	