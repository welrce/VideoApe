package com.welrce.ape.video.fragment.home

import android.os.Bundle
import com.angcyo.dsladapter.DslAdapter
import com.angcyo.getData
import com.angcyo.http.base.toJson
import com.angcyo.item.DslTextInfoItem
import com.angcyo.library.toastQQ
import com.angcyo.widget._rv
import com.angcyo.widget.recycler.initDslAdapter
import com.welrce.ape.video.R
import com.welrce.ape.video.base.AppFragment
import com.welrce.ape.video.model.bean.TabBean

/**
 *
 * Email:angcyo@126.com
 * @author angcyo
 * @date 2020/03/17
 */
class HomeListFragment : AppFragment() {

    lateinit var _adapter: DslAdapter

    var tabBean: TabBean? = null

    init {
        fragmentLayoutId = R.layout.layout_recycler
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tabBean = getData()

        if (tabBean == null) {
            toastQQ("数据异常")
        }
    }

    override fun initBaseView(savedInstanceState: Bundle?) {
        super.initBaseView(savedInstanceState)
        _vh._rv(R.id.lib_recycler_view)?.initDslAdapter {
            _adapter = this

            DslTextInfoItem()() {
                itemInfoText = tabBean?.toJson {
                    disableHtmlEscaping()
                }
            }
        }
    }
}