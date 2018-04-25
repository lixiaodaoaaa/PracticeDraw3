package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice14GetFontMetricsView extends View{
    
    Paint rectPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint innerTextPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    
    
    List<String> listText;
    
    
    int top=200;
    int bottom=400;
    
    public Practice14GetFontMetricsView(Context context){
        super(context);
    }
    
    public Practice14GetFontMetricsView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }
    
    public Practice14GetFontMetricsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }
    
    
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        
        super.onDraw(canvas);
        
        float marginLeftRight=50.0f;
        int firstTextX=100;
        
        
        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差
        
        
        int middle=(top + bottom) / 2;
        
        
        //{"A","a","J","j","Â","â"};
        
        int totalCount=initListTextAndListYoffset();
        
        
        rectPaint.setStyle(Paint.Style.STROKE);
        rectPaint.setStrokeWidth(20);
        rectPaint.setColor(Color.parseColor("#E91E63"));
        canvas.drawRect(marginLeftRight, top, getWidth() - marginLeftRight, bottom, rectPaint);
        
        innerTextPaint.setTextSize(160);
        
        Paint.FontMetrics fontMetrics=innerTextPaint.getFontMetrics();
        float yOffset=(fontMetrics.ascent + fontMetrics.descent) / 2;
        for (int q=0; q < totalCount; q++) {
            canvas.drawText(listText.get(q), firstTextX * q + firstTextX, middle + Math.abs(yOffset), innerTextPaint);
        }
        
    }
    
    
    private int initListTextAndListYoffset(){
        listText=new ArrayList<>();
        listText.add("A");
        listText.add("a");
        listText.add("J");
        listText.add("j");
        listText.add("Â");
        listText.add("â");
        int totalCount=listText.size();
        return totalCount;
    }
}
