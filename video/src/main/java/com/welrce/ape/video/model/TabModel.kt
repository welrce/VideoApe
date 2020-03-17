package com.welrce.ape.video.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.angcyo.jsoup.html.HtmlCategory
import com.angcyo.jsoup.html.HtmlDom
import com.angcyo.jsoup.html.css.AttrSelect
import com.angcyo.jsoup.html.css.HtmlElementSelect
import com.welrce.ape.video.model.bean.TabBean

/**
 *
 * Email:angcyo@126.com
 * @author angcyo
 * @date 2020/03/17
 */

class TabModel : ViewModel() {
    val tabListLiveData = MutableLiveData<MutableList<TabBean>>()

    init {
        tabListLiveData.value = mutableListOf(TabBean().apply {
            tabName = "全网影视"
            tabHtmlDom = HtmlDom().apply {
                htmlUrl = "https://www.wo03.com/"
                htmlCategoryList = mutableListOf<HtmlCategory>().apply {
                    add(HtmlCategory().apply {
                        htmlUrl = "https://www.wo03.com/"
                        categoryName = "推荐"
                        elementsCss =
                            "body #banner .carousel-inner .item | body #banner .carousel-text li "

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
                    })
                }
            }
        })
    }
}