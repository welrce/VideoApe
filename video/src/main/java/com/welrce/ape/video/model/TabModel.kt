package com.welrce.ape.video.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.angcyo.http.base.fromJson
import com.angcyo.http.base.type
import com.angcyo.library.app
import com.angcyo.library.ex.readAssets
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
        tabListLiveData.value = app().readAssets("tab_list.json")
            .fromJson(type(ArrayList::class.java, TabBean::class.java))
    }
}