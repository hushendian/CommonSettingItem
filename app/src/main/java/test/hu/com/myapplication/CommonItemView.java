package test.hu.com.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/12/2.
 */

public class CommonItemView extends LinearLayout {
    private TextView mLeftText;
    private View mRedPoint;
    private ImageView mGO;
    private String mText;
    private float mTextSize;
    private int mTextMargeLeft;
    private int imageHeigh;
    private int imageWidth;
    private int imageLeftMargin;
    private int imageRightMargin;
    private boolean isShowRedPoint;
    private int background;
    private View view;

    public CommonItemView(Context context) {
        super(context);
    }

    public CommonItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.common_setting_item, this);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.settingItem);
        mText = array.getString(R.styleable.settingItem_text);
        mTextSize = array.getDimension(R.styleable.settingItem_textSize, 14);
        mTextMargeLeft = array.getDimensionPixelSize(R.styleable.settingItem_textMargeLeft, 0);
        isShowRedPoint = array.getBoolean(R.styleable.settingItem_isShowRedPoint, false);
        imageHeigh = array.getDimensionPixelSize(R.styleable.settingItem_imageHeigh, 30);
        imageWidth = array.getDimensionPixelSize(R.styleable.settingItem_imageWidht, 30);
        imageLeftMargin = array.getDimensionPixelSize(R.styleable.settingItem_imageMarginLeft, 10);
        imageRightMargin = array.getDimensionPixelSize(R.styleable.settingItem_imageMarginRight, 10);
        background = array.getResourceId(R.styleable.settingItem_image, R.drawable.next_arrow);
        initView();
    }

    public CommonItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    private void initView() {
        setTextParams();
        setRedPoint();
        setImageParams();
    }

    private void setTextParams() {
        mLeftText = view.findViewById(R.id.tv_left);
        mLeftText.setText(mText);
        mLeftText.setTextSize(mTextSize);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mLeftText.getLayoutParams();
        params.leftMargin=mTextMargeLeft;
        mLeftText.setLayoutParams(params);
    }

    private void setRedPoint() {
        mRedPoint = view.findViewById(R.id.red_point);
        mRedPoint.setVisibility(isShowRedPoint ? View.VISIBLE : GONE);
    }

    private void setImageParams() {
        mGO = view.findViewById(R.id.iv_go);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mGO.getLayoutParams();
        params.height = imageHeigh;
        params.width = imageWidth;
        params.leftMargin = imageLeftMargin;
        params.rightMargin = imageRightMargin;
        mGO.setLayoutParams(params);
        mGO.setImageResource(background);
    }
}
