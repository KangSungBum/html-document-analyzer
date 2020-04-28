package com.sungbum.htmlanalyzer;

import java.util.Comparator;

public class WmpTestCharComparator implements Comparator<Character> {
    private final int EQUALIZING_NUMBER = 63;

    @Override
    public int compare(Character o1, Character o2) {
        if (o1.equals(o2)) {
            return 0;
        } else {
            int i1 = Character.isLowerCase(o1) ? o1 * 2 - EQUALIZING_NUMBER : o1 * 2;
            int i2 = Character.isLowerCase(o2) ? o2 * 2 - EQUALIZING_NUMBER : o2 * 2;
            return i1 - i2;
        }
    }
}
