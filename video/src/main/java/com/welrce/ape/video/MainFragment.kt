package com.welrce.ape.video

import android.os.Bundle
import com.angcyo.http.base.toJson
import com.angcyo.jsoup.html.HtmlCategory
import com.angcyo.jsoup.html.css.AttrSelect
import com.angcyo.jsoup.html.css.HtmlElementSelect
import com.angcyo.jsoup.html.parse
import com.angcyo.library.L
import com.welrce.ape.video.base.AppFragment

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

    override fun onFragmentShow(bundle: Bundle?) {
        super.onFragmentShow(bundle)

        val htmlCategory = HtmlCategory().apply {
            htmlUrl = "https://www.wo03.com/"
            categoryName = "推荐"
            elementsCss = "body #banner .carousel-inner .item | body #banner .carousel-text li "

            htmlElementSelect = HtmlElementSelect().apply {

                titleSelect = AttrSelect().apply {
                    attrTargetCss = ".title"
                    attrKey = AttrSelect.ATTR_KEY_TEXT
                }

                summarySelect = AttrSelect().apply {
                    attrTargetCss = ".text"
                    attrKey = AttrSelect.ATTR_KEY_TEXT
                }

                coverSelect = AttrSelect().apply {
                    attrTargetCss = "a"
                    attrKey = "style"
                    attrPattern = listOf("(?<=url\\(').*(?=')")
                    attrIsUrl = true
                }

                targetUrlSelect = AttrSelect().apply {
                    attrTargetCss = "a"
                    attrKey = "href"
                    attrIsUrl = true
                }
            }
        }

        L.i(htmlCategory.toJson())

        htmlCategory.parse {
            L.i(htmlCategory.toJson())
        }
    }
}