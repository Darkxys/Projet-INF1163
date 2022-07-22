public abstract class InfoPaiement {
    private String tokenized_card;

    public abstract boolean validate();

    public String getTokenizeCard() {
        return this.tokenized_card;
    }
}
