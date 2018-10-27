package week4.hw5;

public class Thief implements MailService {

    private final int minValue;
    private int stolenValue = 0;

    public Thief(int minValue) {
        this.minValue = minValue;
    }

    public int getStolenValue() {
        return this.stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage && ((MailPackage) mail).getContent().getPrice() >= minValue) {
            MailPackage stones = new MailPackage(
                    mail.getFrom(),
                    mail.getTo(),
                    new Package("stones instead of " + ((MailPackage) mail).getContent().getContent(), 0)
            );
            stolenValue += ((MailPackage) mail).getContent().getPrice();
            return stones;
        } else {
            return mail;
        }
    }
}
