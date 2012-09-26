/*******************************************************************************
 * Copyright (c) 2012 MASConsult Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.github.malibu_lib.internal;

import java.util.HashMap;
import java.util.LinkedList;

import com.github.malibu_lib.Advice;
import com.github.malibu_lib.GlobalAdvices;
import com.github.malibu_lib.Pointcut;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class PointcutManager<P> implements Pointcut {

    public static final String TAG = "Malibu.PM";

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
