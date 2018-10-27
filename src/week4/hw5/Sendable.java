package week4.hw5;

/**
 * Сущность, которую можно отправить по почте.
 * Можно получить от кого и кому направляется письмо.
 */
public interface Sendable {
    String getFrom();

    String getTo();
}
