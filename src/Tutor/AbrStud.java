package Tutor;

public class AbrStud extends Student {
    private boolean isUnderstand = false;

    public AbrStud(String name, boolean isUnderstand) {
        super(name);
        this.isUnderstand = isUnderstand;
    }

    public boolean isUnderstand() {
        return isUnderstand;
    }

    public void setUnderstand(boolean understand) {
        isUnderstand = understand;
    }
}
