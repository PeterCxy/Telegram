/*
 * This is the source code of Telegram for Android v. 3.x.x.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Nikolai Kudashov, 2013-2016.
 */

package org.telegram.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;

import org.telegram.messenger.AndroidUtilities;
import org.telegram.messenger.R;

public class DividerCell extends BaseCell {

    private static Paint paint;

    public DividerCell(Context context) {
        super(context);
        if (paint == null) {
            paint = new Paint();
            paint.setColor(ContextCompat.getColor(context, R.color.divider));
            paint.setStrokeWidth(1);
        }
    }

    public static void setDividerColor(Context context, boolean night) {
        if (paint != null) {
            paint.setColor(ContextCompat.getColor(context, night ? R.color.divider_dark : R.color.divider_light));
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), AndroidUtilities.dp(16) + 1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(getPaddingLeft(), AndroidUtilities.dp(8), getWidth() - getPaddingRight(), AndroidUtilities.dp(8), paint);
    }
}
