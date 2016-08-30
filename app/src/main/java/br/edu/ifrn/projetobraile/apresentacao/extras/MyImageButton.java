package br.edu.ifrn.projetobraile.apresentacao.extras;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class MyImageButton extends ImageButton {

    private int posRef;

    public MyImageButton(Context context) {
        super(context);
    }

    public MyImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }

    public int getPosRef() {
        return posRef;
    }

    public void setPosRef(int posRef) {
        this.posRef = ++posRef;
    }
}
