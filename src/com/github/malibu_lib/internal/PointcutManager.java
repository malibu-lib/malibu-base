
package com.github.malibu_lib.internal;

import java.util.HashMap;
import java.util.LinkedList;

import com.github.malibu_lib.Advice;
import com.github.malibu_lib.GlobalAdvices;
import com.github.malibu_lib.Pointcut;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class PointcutManager<P extends Pointcut> implements Pointcut {

    private final LinkedList<Advice> localAdvices = new LinkedList<Advice>();
    private final Iterable<Advice> advices = Iterables.concat(
            GlobalAdvices.getAdvices(),
            localAdvices);
    private final Iterable<Advice> reverseAdvices = Iterables.concat(
            Lists.reverse(localAdvices),
            GlobalAdvices.getReverseAdvices());
    private final HashMap<Class<?>, Iterable<Class<?>>> advicesCache = new HashMap<Class<?>, Iterable<Class<?>>>();
    private final HashMap<Class<?>, Iterable<Class<?>>> reverseAdvicesCache = new HashMap<Class<?>, Iterable<Class<?>>>();
    protected final P pointcut;

    public PointcutManager(P pointcut) {
        this.pointcut = pointcut;
    }

    @Override
    public void registerAdvice(final Advice advice) {
        localAdvices.add(advice);
    }

    @SuppressWarnings("unchecked")
    private <A> Iterable<A> advices(
            Class<A> pointcut,
            Iterable<Advice> listeners,
            HashMap<Class<?>, Iterable<Class<?>>> cache) {
        Iterable<A> result = (Iterable<A>) cache.get(pointcut);
        if (result == null) {
            result = Iterables.filter(listeners, pointcut);
            cache.put(pointcut, (Iterable<Class<?>>) result);
        }
        return result;
    }

    protected <A> Iterable<A> advices(Class<A> pointcut) {
        return advices(pointcut, advices, advicesCache);
    }

    protected <A> Iterable<A> reverseAdvices(Class<A> pointcut) {
        return advices(pointcut, reverseAdvices, reverseAdvicesCache);
    }

    protected void clearAdvices() {
        localAdvices.clear();
    }
}
