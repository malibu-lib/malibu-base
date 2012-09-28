
package com.github.malibu_lib.pointcuts.service;

import android.app.Service;
import android.content.res.Configuration;

import com.github.malibu_lib.Advice;

public interface OnConfigurationChangedServiceAdvice extends Advice {

    public void onConfigurationChanged(Service service, Configuration newConfig);

}
