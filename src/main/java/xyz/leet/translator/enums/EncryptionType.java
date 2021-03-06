package xyz.leet.translator.enums;

public enum EncryptionType {
    
    DECODE(""),
    LEET_LEVEL_1("_L1"),
    LEET_LEVEL_2("_L2"),
    LEET_LEVEL_3("_L3"),
    DISCORD_EMOJI("_DE"),
    CAESAR_SHIFT("_CS"),
    FUCKERY("_F");
    
    private final String encryptionCode;
    
    EncryptionType(String encryptionCode) {
        this.encryptionCode = encryptionCode;
    }
    
    public String getEncryptionCode() {
        return encryptionCode;
    }
}
