package practiceexam.two.question1;

public class WordMatch {
    private String secret;

    public WordMatch(String secret) {
        this.secret = secret;
    }

    public int scoreGuess(String guess) {
        int score = 0;

        for (int i = 0; i <= secret.length() - guess.length(); i++) {
            // check if subsection equals the guess
            if (secret.substring(i, i + guess.length()).equals(guess)) {
                score++;
            }
        }

        return score * guess.length() * guess.length();
    }

    public String findBetterGuess(String guess1, String guess2) {
        // capture scores in variables so you only call scoreGuess once for each guess
        int g1Score = scoreGuess(guess1);
        int g2Score = scoreGuess(guess2);

        if (g1Score > g2Score) {
            return guess1;
        }
        if (g2Score > g1Score) {
            return guess2;
        }

        // both scores are equal, we have to implement the tiebreaker rule

        if (guess1.compareTo(guess2) > 0) {
            return guess1;
        }
        return guess2;
    }

    public static void main(String[] args) {
        WordMatch game = new WordMatch("mississippi");
        System.out.println(game.scoreGuess("i"));
        System.out.println(game.scoreGuess("iss"));
        System.out.println(game.scoreGuess("issipp"));
        System.out.println(game.scoreGuess("mississippi"));

        WordMatch game2 = new WordMatch("concatenation");
        String g1 = "ten";
        String g2 = "nation";
        System.out.println(game2.scoreGuess(g1));
        System.out.println(game2.scoreGuess(g2));
        System.out.println(game2.findBetterGuess(g1, g2));
        g1 = "con";
        g2 = "cat";
        System.out.println(game2.scoreGuess(g1));
        System.out.println(game2.scoreGuess(g2));
        System.out.println(game2.findBetterGuess(g1, g2));
    }
}
