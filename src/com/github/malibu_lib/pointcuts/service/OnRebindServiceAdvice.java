
package com.github.malibu_lib.pointcuts.service;

import android.app.Service;
import android.content.Intent;

import com.github.malibu_lib.Advice;

public interface OnRebindServiceAdvice extends Advice {

    public void onRebind(Service service, Intent intent);

}
