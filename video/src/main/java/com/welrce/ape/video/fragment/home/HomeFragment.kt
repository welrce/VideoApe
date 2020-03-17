package com.welrce.ape.video.fragment.home

import android.os.Bundle
import android.widget.TextView
import com.angcyo.core.vmCore
import com.angcyo.drawable.base.dslGradientDrawable
import com.angcyo.library.ex._color
import com.angcyo.widget.base.find
import com.angcyo.widget.base.resetChild
import com.welrce.ape.video.R
import com.welrce.ape.video.base.AppFragment
import com.welrce.ape.video.model.TabModel

/**
 *
 * Email:angcyo@126.com
 * @author angcyo
 * @date 2020/03/17
 */
class HomeFragment : AppFragment() {

    val tabModel: TabModel by lazy {
        vmCore<TabModel>()
    }

    init {
        fragmentLayoutId = R.layout.fragment_home
    }

    override fun initBaseView(savedInstanceState: Bundle?) {
        super.initBaseView(savedInstanceState)
        _vh.view(R.id.lib_title_wrap_layout)?.background = dslGradientDrawable {
            gradientColors =
                intArrayOf(_color(R.color.colorPrimaryDark), _color(R.color.colorPrimary))
        }

        tabModel.tabListLiveData.observe {
            it?.apply {
                _vh.group(R.id.lib_tab_layout)
                    ?.resetChild(size, R.layout.layout_tab_home_item) { itemView, itemIndex ->
                        itemView.find<TextView>(R.id.lib_text_view)?.text = get(itemIndex).tabName
                    }
            }
        }
    }
}