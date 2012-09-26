
package com.github.malibu_lib.pointcuts;

import android.app.Activity;
import android.os.Bundle;

import com.github.malibu_lib.Advice;

public interface OnSaveInstanceStateActivityAdvice extends Advice {

    public void onSaveInstanceState(Activity activity, Bundle outState);
}
