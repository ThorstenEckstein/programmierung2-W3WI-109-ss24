package de.dhbw.demo.datatypes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DatatypesDemoTest {

    @Test
    @DisplayName("DEMO : Datentypen & Umwandlung")
    public void demo1() {
        // given
        String   s = null;
        char     c = 'A';
        byte     b = 0;
        short   sh = 0;
        int      i = 0;
        long     l = 0L;
        float    f = 0.0f;
        double   d = 0.0;
        boolean bl = false;

        // when & then - widening (implicit conversion)

        b = 97;
        i = b;
        System.out.println("byte    -> integer : " + i);

        i = 2_500_000;
        d = i;
        System.out.println("int     -> double  : " + d);

        // when & then - narrowing (explicit casting)

        sh = 4_000;
        //b = (byte)sh;
        System.err.println("short   -> byte    : " + b);

        i = 1_000_000;
        // sh = (short)l;
        System.err.println("integer -> short   : " + sh);

        s = "true";
        //bl = s;
        //bl = Boolean.valueOf(s);
        System.err.println("string  -> boolean : " + bl);

    }

}
