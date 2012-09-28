
package com.github.malibu_lib.pointcuts.service;

import android.app.Service;
import android.content.Intent;

import com.github.malibu_lib.Advice;

public interface OnUnbindServiceAdvice extends Advice {

    public boolean onUnbind(Service service, Intent intent);

}
