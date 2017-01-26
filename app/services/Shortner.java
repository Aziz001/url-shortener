package services;

/**
 * The interface represents a shortner component that returns a
 * url when a short url is given and vice-versa.
 *
 * {@link Base62Shortner} implementation.
 */
public interface Shortner {
    String encode(long id);
    long decode(String short_url);
}
