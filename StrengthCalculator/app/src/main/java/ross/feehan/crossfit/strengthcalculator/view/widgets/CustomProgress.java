/**
  The MIT License (MIT)

 Copyright (c) 2014 Niko Yuwono

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 **/
package ross.feehan.crossfit.strengthcalculator.view.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

import java.util.Arrays;

import ross.feehan.crossfit.strengthcalculator.R;


public class CustomProgress extends TextView {

    private final static int SHAPE_RECTANGLE = 0;
    private final static int SHAPE_ROUNDED_RECTANGLE = 1;
    private final static int DEFAULT_TEXT_MARGIN = 10;

	private ShapeDrawable progressDrawable;
    private TextView textView;
	private int width = 0;
    private int maxWidth = 0;
    private int maxHeight = 0;
    private int progressColor;
    private int progressBackgroundColor;
    private int progressShape = SHAPE_RECTANGLE;
    private float maximumPercentage = 0.0f;
    private float cornerRadius = 25.0f;
    private boolean showingPercentage = false;

    //Constructor

	public CustomProgress(Context context) {
		super(context);
        setDefaultValue();
	}

    public CustomProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDefaultValue();
    }

    public CustomProgress(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setDefaultValue();
    }

    private void setDefaultValue() {
        // default color
        progressColor = getResources().getColor(R.color.mainColor);
        progressBackgroundColor = getResources().getColor(R.color.mainGrey);
    }

    //View Lifecycle

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if(changed) {
            initView();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        progressDrawable.setBounds(0, 0, width, this.getHeight());
        progressDrawable.draw(canvas);
        if(isShowingPercentage()) {
            this.setText(getCurrentPercentage()+"%");
        }
        if(width<maxWidth) {
            width+=5;
            invalidate();
        }
    }

    /**
     * Initialize the view before it will be drawn
     */
    private void initView() {
        Shape progressShapeDrawable = null;
        Shape backgroundProgressShapeDrawable = null;
        switch (progressShape) {
            case SHAPE_RECTANGLE:
                progressShapeDrawable = new RectShape();
                backgroundProgressShapeDrawable = new RectShape();
                break;
            case SHAPE_ROUNDED_RECTANGLE:
                float[] outerRadius = new float[8];
                Arrays.fill(outerRadius, cornerRadius);
                progressShapeDrawable = new RoundRectShape(outerRadius, null, null);
                backgroundProgressShapeDrawable = new RoundRectShape(outerRadius, null, null);
                break;
        }

        //Progress
        progressDrawable = new ShapeDrawable(progressShapeDrawable);
        progressDrawable.getPaint().setColor(progressColor);
        if((this.getText().length() > 0) || isShowingPercentage()) {
            progressDrawable.setAlpha(100);
        }

        //Background
        ShapeDrawable backgroundDrawable = new ShapeDrawable(backgroundProgressShapeDrawable);
        backgroundDrawable.getPaint().setColor(progressBackgroundColor);
        backgroundDrawable.setBounds(0, 0, this.getWidth(), this.getHeight());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            this.setBackground(backgroundDrawable);
        } else {
            this.setBackgroundDrawable(backgroundDrawable);
        }

        this.maxWidth = (int) (this.getWidth() * maximumPercentage);

        //Percentage
        if(isShowingPercentage()) {
            this.setTextSize(20);
            this.setTextColor(Color.WHITE);
            this.setGravity(Gravity.CENTER);
        }
    }

    //Helper

    /**
     * Set the progress color
     * @param color
     */
    public void setProgressColor(int color) {
        this.progressColor = color;
    }

    /**
     * Set the background color
     * @param color
     */
    public void setProgressBackgroundColor(int color) {
        this.progressBackgroundColor = color;
    }

    /**
     * Reset the progress to 0
     */
    public void resetWidth() {
        width = 0;
    }

    /**
     * Set the maximum percentage for the progress
     * @param percentage
     */
    public void setMaximumPercentage(float percentage) {
        this.maximumPercentage = percentage;
    }

    /**
     * Get current percentage based on current width
     * @return
     */
    public int getCurrentPercentage() {
        return (int) Math.ceil((width/(maxWidth*1.0f))*100);
    }

    /**
     * Set the shape of custom progress to rectangle
     */
    public void useRectangleShape() {
        this.progressShape = SHAPE_RECTANGLE;
    }

    /**
     * Set the shape of custom progress to rounded rectangle
     * @param cornerRadius radius of the corner
     */
    public void useRoundedRectangleShape(float cornerRadius) {
        this.progressShape = SHAPE_ROUNDED_RECTANGLE;
        this.cornerRadius = cornerRadius;
    }

    /**
     * If this returns true the custom progress
     * will show progress based on getCurrentPercentage()
     * @return true for showing percentage false for not showing anything
     */
    public boolean isShowingPercentage() {
        return showingPercentage;
    }

    /**
     * Set if the custom progress will show percentage or not
     * @param showingPercentage true for showing percentage false for not showing anything
     */
    public void setShowingPercentage(boolean showingPercentage) {
        this.showingPercentage = showingPercentage;
    }
}