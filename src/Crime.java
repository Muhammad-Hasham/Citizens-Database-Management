public class Crime {

    private String Charges;
    private String Punishment;
    private int Fine;
    public Crime(String charges, String punishment, int fine) {
        Charges = charges;
        Punishment = punishment;
        Fine = fine;
    }
    public String getCharges() {
        return Charges;
    }
    public void setCharges(String charges) {
        Charges = charges;
    }
    public String getPunishment() {
        return Punishment;
    }
    public void setPunishment(String punishment) {
        Punishment = punishment;
    }
    public int getFine() {
        return Fine;
    }
    public void setFine(int fine) {
        Fine = fine;
    }

}
