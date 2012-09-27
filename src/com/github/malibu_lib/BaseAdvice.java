
package com.github.malibu_lib;

/**
 * Simple advices may extends this class to ease integration. To use specific
 * advice inside an activity or fragment just add code like this
 * 
 * <pre>
 * <code>
 * final BaseAdvice advice = new BaseAdvice(this);
 * </code>
 * </pre>
 * 
 * @author Geno Roupsky &lt;geno&#064;masconsult.eu&gt;
 */
public class BaseAdvice implements Advice {

    public BaseAdvice(Pointcut pointcut) {
        pointcut.registerAdvice(this);
    }
}
