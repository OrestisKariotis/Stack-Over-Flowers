package gr.ntua.ece.softeng.kidspiration;

public class PurchaseView {
    int id;
    int wallet;

    public PurchaseView(int id, int wallet) {
        this.id = id;
        this.wallet = wallet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }
}


