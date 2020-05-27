package logic;

import models.KlientEntity;
import models.PracownikEntity;

public class singleton {
    public static final singleton instance = new singleton();

    public String funkcja;

    public PracownikEntity staff = null;
    public KlientEntity uzytkownik = null;

    public void SetFunc(String funkcja) {
        this.funkcja = funkcja;
    }

    public String GetFunc() {
        return funkcja;
    }

    private singleton() {
        if (instance != null) {
            throw new IllegalStateException("Singleton already constructed");
        }
    }
}
