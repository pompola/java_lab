import java.util.HashSet;
import java.util.Set;

class Bukva {
    private Set<Character> letters;

    public Bukva() {
        letters = new HashSet<>();
    }

    public Bukva(Set<Character> letters) {
        this.letters = letters;
    }

    public void addLetter(char letter) {
        letters.add(Character.toLowerCase(letter));
    }

    public Set<Character> getMissingLetters(String alphabet) {
        Set<Character> alphabetSet = new HashSet<>();
        for (char c : alphabet.toCharArray()) {
            alphabetSet.add(Character.toLowerCase(c));
        }
        alphabetSet.removeAll(letters);
        return alphabetSet;
    }


    @Override
    public String toString() {
        return "Список используемых букв: " + letters;
    }

    public Set<Character> getLetters() {
        return letters;
    }
}
