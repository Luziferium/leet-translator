package xyz.leet.translator;

import xyz.leet.translator.enums.LeetLetter;
import xyz.leet.translator.enums.LeetLevel;

import java.util.Optional;

public class LeetTranslator {

    /**
     * Translates the given *normal* String to Leet
     */
    public String translate(String normal, LeetLevel leetLevel) {

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i != normal.length(); i++)
            builder.append(getLeetLetter(normal, i, leetLevel));
        return addEncryptionCode(builder.toString(), leetLevel);
    }

    /**
     * Translates the given *leet* String to normal
     */
    public String translate(String leet) {

        Optional<LeetLevel> leetLevel = this.getEncryption(leet);
        leet = getWithoutEncrytpionCode(leet);

        if(leetLevel.isEmpty()) return leet;
        
        for (String filler : LeetLetter.getLeetFillers(leetLevel.get()))
            leet = leet.replace(filler, LeetLetter.fromLeet(filler).name());

        return leet;
    }

    private String getLeetLetter(String s, int index, LeetLevel leetLevel) {

        String current = String.valueOf(s.charAt(index));

        if(Character.isAlphabetic(s.charAt(index)))
            return LeetLetter.fromLetter(current).getLeet(leetLevel);
        return current;
    }

    private String addEncryptionCode(String s, LeetLevel leetLevel) {
        return s + leetLevel.getEncryptionCode();
    }

    private String getWithoutEncrytpionCode(String s) {

        Optional<LeetLevel> leetLevel = this.getEncryption(s);
        return s.substring(0, s.length() - leetLevel.get().getEncryptionCode().length());
    }

    private Optional<LeetLevel> getEncryption(String s) {

        for(LeetLevel leetLevel : LeetLevel.values()) {

            if(s.endsWith(leetLevel.getEncryptionCode()))
                return Optional.of(leetLevel);
        }
        return Optional.empty();
    }

}
