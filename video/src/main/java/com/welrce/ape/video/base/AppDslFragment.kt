package com.welrce.ape.video.base

import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.angcyo.core.fragment.BaseDslFragment

/**
 *
 * Email:angcyo@126.com
 * @author angcyo
 * @date 2020/03/16
 * Copyright (c) 2019 ShenZhen O&M Cloud Co., Ltd. All rights reserved.
 */
open class AppDslFragment : BaseDslFragment() {
    init {

    }

    override fun onCreateBehavior(child: View): CoordinatorLayout.Behavior<*>? {
        return super.onCreateBehavior(child)
    }
}