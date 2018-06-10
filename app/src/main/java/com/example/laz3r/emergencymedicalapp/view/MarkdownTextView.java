package com.example.laz3r.emergencymedicalapp.view;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import ru.noties.markwon.Markwon;


public class MarkdownTextView extends AppCompatTextView {

    public MarkdownTextView(Context context) {
        super(context);
    }

    public MarkdownTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MarkdownTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    void setText(String markdownText){
        Markwon.setMarkdown(this, markdownText);
    }

}