
package com.github.malibu_lib.pointcuts;

import android.app.Activity;
import android.os.Bundle;

import com.github.malibu_lib.Advice;

public interface OnRestoreInstanceStateActivityAdvice extends Advice {

    public void onRestoreInstanceState(Activity activity, Bundle savedInstanceState);
}
