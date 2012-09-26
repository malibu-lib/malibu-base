
package com.github.malibu_lib.pointcuts;

import android.app.Activity;
import android.content.Intent;

import com.github.malibu_lib.Advice;

public interface OnActivityResultActivityAdvice extends Advice {

    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data);
}
