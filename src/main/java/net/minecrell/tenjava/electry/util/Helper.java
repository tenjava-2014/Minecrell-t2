package net.minecrell.tenjava.electry.util;

import com.google.common.collect.Iterables;

public final class Helper {
    private Helper() {}

    public static boolean nullOrEmpty(Iterable<?> iterable) {
        return iterable == null || Iterables.isEmpty(iterable);
    }
}
