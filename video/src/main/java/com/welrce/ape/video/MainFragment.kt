package com.welrce.ape.video

import android.os.Bundle
import com.angcyo.base.dslChildFHelper
import com.angcyo.widget.tab
import com.welrce.ape.video.base.AppFragment
import com.welrce.ape.video.fragment.find.FindFragment
import com.welrce.ape.video.fragment.home.HomeFragment
import com.welrce.ape.video.fragment.me.MeFragment

/**
 *
 * Email:angcyo@126.com
 * @author angcyo
 * @date 2020/03/16
 * Copyright (c) 2019 ShenZhen O&M Cloud Co., Ltd. All rights reserved.
 */

class MainFragment : AppFragment() {
    init {
        fragmentLayoutId = R.layout.fragment_main
    }

    override fun canSwipeBack(): Boolean {
        return false
    }

    override fun initBaseView(savedInstanceState: Bundle?) {
        super.initBaseView(savedInstanceState)

        _vh.tab(R.id.lib_tab_layout)?.configTabLayoutConfig {
            onSelectIndexChange = { fromIndex, selectIndexList, reselect, fromUser ->
                dslChildFHelper {
                    hideBeforeIndex = 1
                    removeOverlayFragmentOnShow = false
                    restore(
                        when (selectIndexList.first()) {
                            0 -> HomeFragment::class.java
                            1 -> FindFragment::class.java
                            2 -> MeFragment::class.java
                            else -> MeFragment::class.java
                        }
                    )
                    noAnim()
                }
            }
        }
    }
}