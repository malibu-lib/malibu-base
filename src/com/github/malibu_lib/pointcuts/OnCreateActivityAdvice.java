
package com.github.malibu_lib.pointcuts;

import android.app.Activity;
import android.os.Bundle;

import com.github.malibu_lib.Advice;

public interface OnCreateActivityAdvice extends Advice {

    void onCreate(Activity activity, Bundle savedInstanceState);

}
