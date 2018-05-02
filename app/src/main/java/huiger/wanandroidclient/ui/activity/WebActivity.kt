package huiger.wanandroidclient.ui.activity

import android.view.KeyEvent
import android.view.ViewGroup
import com.just.agentweb.AgentWeb
import com.just.agentweb.ChromeClientCallbackManager
import huiger.wanandroidclient.R
import huiger.wanandroidclient.base.BaseActivity
import huiger.wanandroidclient.constans.Constans
import huiger.wanandroidclient.utils.getAgentWeb
import huiger.wanandroidclient.widgets.TitleOnClickListener
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : BaseActivity() {

    private lateinit var url: String
    private lateinit var agentWeb: AgentWeb


    override fun setLayoutResId(): Int = R.layout.activity_web

    override fun initData() {

        intent.extras?.let {
            url = it.getString(Constans.JUMP_URL)

            agentWeb = url.getAgentWeb(this, content_layout,
                    ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT),
                    receivedTitleCallback)
        }

    }

    override fun onPause() {
        agentWeb.webLifeCycle.onPause()
        super.onPause()
    }

    override fun onResume() {
        agentWeb.webLifeCycle.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        agentWeb.webLifeCycle.onDestroy()
        super.onDestroy()
    }

    override fun initListener() {
        titleLayout.setTitleOnClickListener(object : TitleOnClickListener() {
            override fun leftOnClick() {
                finish()
            }
        })
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return if (agentWeb.handleKeyEvent(keyCode, event)) true else super.onKeyDown(keyCode, event)
    }


    private val receivedTitleCallback = ChromeClientCallbackManager.ReceivedTitleCallback { _, title ->
        titleLayout.setTitleContent(title)
    }

}
