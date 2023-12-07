import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day7A {
    private void puzzle1(String[] lines){
        List<Hand> hands = new ArrayList<>(Arrays.stream(lines).filter(l -> !l.isEmpty()).map(Hand::new).toList());
        hands.sort(Hand::compareTo);
        int sum = 0;
        for (int i = 0; i < hands.size(); i++) {
            sum += (i+1)* hands.get(i).bet;
        }
        System.out.println(sum);

    }

    private class Hand implements Comparable<Hand>{
        public String cards;
        public int bet;
        public int worth = 0;
        public Hand(String line){
            cards = line.split(" ")[0];
            bet = Short.parseShort(line.split(" ")[1].trim());
            worth = worthOfHand(cards);
        }

        @Override
        public int compareTo(Hand other) {
            if(worth != other.worth){
                return Integer.compare(worth, other.worth);
            }
            for (int i = 0; i < cards.length(); i++) {
                char c1 = cards.charAt(i);
                char c2 = other.cards.charAt(i);

                int worth1 = worthOfCard(c1);
                int worth2 = worthOfCard(c2);

                if(worth1 == worth2) continue;

                return Integer.compare(worth1, worth2);
            }
            return 0;
        }
        
        private int worthOfCard(char c){
            return switch (c){
                case 'A' -> 14;
                case 'K' -> 13;
                case 'Q' -> 12;
                case 'J' -> 11;
                case 'T' -> 10;
                default -> Integer.parseInt(String.valueOf(c));
            };
        }
        private int worthOfHand(String cards){
            CardCount[] cardCounts = new CardCount[cards.length()];
            for (int i = 0; i < cardCounts.length; i++) {
                cardCounts[i] = new CardCount();
            }
            for (int i = 0; i < cards.length(); i++) {
                char c = cards.charAt(i);
                for (CardCount cardCount : cardCounts) {
                    if (c == cardCount.card || cardCount.card == 'e') {
                        cardCount.card = c;
                        cardCount.count++;
                        break;
                    }
                }
            }
            if(cardCounts[1].count == 0) //five
                return 7;
            if(cardCounts[0].count == 4 || cardCounts[1].count == 4) //four
                return 6;
            if(cardCounts[2].count == 0) //full house
                return 5;
            if(cardCounts[0].count == 3 || cardCounts[1].count == 3 || cardCounts[2].count == 3) // three
                return 4;
            if(cardCounts[3].count == 0) //two pair
                return 3;
            if(cardCounts[4].count == 0) // pair
                return 2;
            return 1; // high card
        }

        private static class CardCount{
            public char card = 'e';
            public int count = 0;
        }
    }
    public static void main(String[] args) {
        Day7A day7 = new Day7A();
        day7.puzzle1(InputReader.getLines(7));
    }
}
