package services;

import javax.inject.*;

/**
 * This class is a concrete implementation of the {@link Shortner} trait.
 *
 * This class has a {@link Singleton} annotation because we need to make
 * sure we only use one shortner per application.
 */

@Singleton
public class Base62Shortner implements Shortner {

    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";


    @Override
    public String encode(long id) {
        StringBuilder short_url = new StringBuilder();
        while ( id > 0 ) {
            short_url.append( ALPHA.charAt( (int) id % 62 ) );
            id /= 62;
        }
        return short_url.reverse().toString();
    }

    @Override
    public long decode(String short_url) {
        int id = 0;
        for ( int i = 0; i < short_url.length(); i++ )
            id = id * 62 + ALPHA.indexOf(short_url.charAt(i));
        return id;
    }

}
