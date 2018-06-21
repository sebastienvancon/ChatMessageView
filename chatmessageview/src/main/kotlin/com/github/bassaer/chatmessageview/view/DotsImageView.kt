package com.github.bassaer.chatmessageview.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageView

import com.github.bassaer.chatmessageview.R

/**
 * Round Image view for picture on message
 * Created by nakayama on 2017/03/08.
 */
class DotsImageView{

    private var layout :FrameLayout?=null
    private var layoutInflater : LayoutInflater?=null

    constructor(context: Context, viewGroup: ViewGroup){
//        initClipPath()
        layoutInflater  = LayoutInflater.from(context)
        layout = layoutInflater!!.inflate(R.layout.message_dots_left,viewGroup) as FrameLayout
        init()
    }


    fun init(){
        var alphaAnimation1 : AlphaAnimation = AlphaAnimation(1f,0.3f)
        alphaAnimation1.duration = 1000
        alphaAnimation1.startOffset = 0
        alphaAnimation1.repeatMode = Animation.REVERSE
        alphaAnimation1.repeatCount = Animation.INFINITE
        var alphaAnimation2 : AlphaAnimation = AlphaAnimation(1f,0.3f)
        alphaAnimation2.duration = 700
        alphaAnimation2.startOffset = 300
        alphaAnimation2.repeatMode = Animation.REVERSE
        alphaAnimation2.repeatCount = Animation.INFINITE
        var alphaAnimation3 : AlphaAnimation = AlphaAnimation(1f,0.3f)
        alphaAnimation3.duration = 400
        alphaAnimation3.startOffset = 600
        alphaAnimation3.repeatMode = Animation.REVERSE
        alphaAnimation3.repeatCount = Animation.INFINITE
        var dot1 : ImageView = layout!!.findViewById(R.id.dot1)
        var dot2 : ImageView = layout!!.findViewById(R.id.dot2)
        var dot3 : ImageView = layout!!.findViewById(R.id.dot3)
        dot1.startAnimation(alphaAnimation1)
        dot2.startAnimation(alphaAnimation2)
        dot3.startAnimation(alphaAnimation3)
    }


    fun getLayout(): FrameLayout{
        return layout!!
    }
}