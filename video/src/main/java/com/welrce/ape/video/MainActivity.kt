package com.welrce.ape.video

import android.os.Bundle
import com.angcyo.base.dslFHelper
import com.angcyo.core.activity.BaseCoreAppCompatActivity

/**
 *
 * Email:angcyo@126.com
 * @author angcyo
 * @date 2020/02/02
 */
class MainActivity : BaseCoreAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dslFHelper {
            restore(MainFragment::class.java)
        }
    }
}
