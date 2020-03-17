package com.welrce.ape.video.model.bean

import com.angcyo.jsoup.html.HtmlDom

/**
 *
 * Email:angcyo@126.com
 * @author angcyo
 * @date 2020/03/17
 */

data class TabBean(
    /**标签名*/
    var tabName: String? = null,
    /**数据Dom*/
    var tabHtmlDom: HtmlDom? = null
)