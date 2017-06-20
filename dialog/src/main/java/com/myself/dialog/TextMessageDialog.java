package com.myself.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2017/6/20 0020.
 */

public class TextMessageDialog extends Dialog {
    public TextMessageDialog(@NonNull Context context) {
        super(context);


    }

    public TextMessageDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected TextMessageDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
