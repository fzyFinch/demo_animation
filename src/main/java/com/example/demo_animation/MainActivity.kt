package com.example.demo_animation

import android.animation.AnimatorInflater
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.ToggleButton
/**
 * Copyright (c) 2021, Lollitech
 * All rights reserved
 * Author: fangzhiyuan@lollitech.com
 */
class MainActivity : AppCompatActivity() {

    private var isTween: Boolean = true

    private lateinit var radioGroup: RadioGroup
    private lateinit var radio: RadioButton
    private lateinit var btnFrame: ToggleButton
    private lateinit var viewAnimation: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        radioGroup = findViewById(R.id.radio_group)
        radio = findViewById(R.id.radio)
        btnFrame = findViewById(R.id.btn_frame)
        viewAnimation = findViewById(R.id.view_animation)
        //帧动画
        frameAnimation()
        radioGroup.check(R.id.radio)
        radioGroup.setOnCheckedChangeListener { _, _ ->
            isTween = radio.isChecked
        }
    }

    private fun frameAnimation() {
        viewAnimation.setBackgroundResource(R.drawable.animation_frame)
        val drawable = viewAnimation.background as AnimationDrawable
        btnFrame.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                drawable.start()
            } else {
                drawable.stop()
            }
        }
    }

    fun translate(v: View) {
        if (isTween) {
            startAnimation(R.anim.anim_trans)
        } else {
            startPropertyAnimation(R.animator.anim_trans)
        }
    }

    fun scale(v: View) {
        if (isTween) {
            startAnimation(R.anim.anim_scale)
        } else {
            startPropertyAnimation(R.animator.anim_scale)
        }
    }

    fun rotate(v: View) {
        if (isTween) {
            startAnimation(R.anim.anim_rotate)
        } else {
            startPropertyAnimation(R.animator.anim_rotate)
        }
    }

    fun alpha(v: View) {
        if (isTween) {
            startAnimation(R.anim.anim_alpha)
        } else {
            startPropertyAnimation(R.animator.anim_alpha)
        }
    }

    fun meanwhileAnimate(v: View) {
        if (isTween) {
            startAnimation(R.anim.set_animation1)
        } else {
            startPropertyAnimation(R.animator.set_animation1)
        }
    }

    fun orderAnimate(v: View) {
        if (isTween) {
            startAnimation(R.anim.set_animation2)
        } else {
            startPropertyAnimation(R.animator.set_animation2)
        }
    }

    private fun startAnimation(animation: Int) {
        val animate = AnimationUtils.loadAnimation(this, animation)
        viewAnimation.startAnimation(animate)
    }

    private fun startPropertyAnimation(animate: Int) {
        val propertyAnimator = AnimatorInflater.loadAnimator(this, animate)
        propertyAnimator.setTarget(viewAnimation)
        propertyAnimator.start()
    }
}