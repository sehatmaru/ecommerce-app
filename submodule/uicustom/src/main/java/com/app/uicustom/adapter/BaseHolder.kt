package com.app.uicustom.adapter

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

open class BaseHolder(@LayoutRes layoutId: Int, parent: ViewGroup?)
    : RecyclerView.ViewHolder(LayoutInflater.from(parent?.context).inflate(layoutId, parent, false))
