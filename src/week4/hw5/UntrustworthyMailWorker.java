package week4.hw5;

public class UntrustworthyMailWorker implements MailService {

    private final MailService[] services;
    private final RealMailService realService;

    public UntrustworthyMailWorker(MailService[] services) {
        this.services = services;
        this.realService = new RealMailService();
    }

    public RealMailService getRealMailService() {
        return realService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService service : services) {
            mail = service.processMail(mail);
        }
        return realService.processMail(mail);
    }
}
