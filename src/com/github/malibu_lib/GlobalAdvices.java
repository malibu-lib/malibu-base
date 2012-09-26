
package com.github.malibu_lib;

import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.Lists;

public final class GlobalAdvices {

    private static final LinkedList<Advice> advices = new LinkedList<Advice>();
    private static final List<Advice> reverseAdvices = Lists.reverse(advices);

    /**
     * register your global advices
     */
    public static void registerGlobalAdvice(Advice advice) {
        advices.add(advice);
    }

    public static Iterable<Advice> getAdvices() {
        return advices;
    }

    public static Iterable<Advice> getReverseAdvices() {
        return reverseAdvices;
    }

}
