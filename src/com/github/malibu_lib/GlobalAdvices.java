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

package com.github.malibu_lib;

import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.Lists;

public final class GlobalAdvices implements Pointcut {

    public static final GlobalAdvices instance = new GlobalAdvices();
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

    private GlobalAdvices() {
    }

    @Override
    public void registerAdvice(Advice advice) {
        registerGlobalAdvice(advice);
    }

}
