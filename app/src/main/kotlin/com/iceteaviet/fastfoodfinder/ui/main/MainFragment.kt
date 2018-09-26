package com.iceteaviet.fastfoodfinder.ui.main


import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.iceteaviet.fastfoodfinder.R
import com.iceteaviet.fastfoodfinder.utils.d
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {
    lateinit var mTabLayout: TabLayout
    lateinit var mViewPager: ViewPager

    override fun onCreateView(@NonNull inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(@NonNull view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mTabLayout = tab_layout
        mViewPager = view_pager

        val mPagerAdapter = MainPagerAdapter(childFragmentManager)
        mViewPager.adapter = mPagerAdapter
        mViewPager.offscreenPageLimit = 2
        mTabLayout.setupWithViewPager(mViewPager)


        for (i in 0 until mTabLayout.tabCount) {
            mTabLayout.getTabAt(i)!!.text = null
            mTabLayout.getTabAt(i)!!.setIcon(mPagerAdapter.getIcon(i))
        }

        mTabLayout.getTabAt(0)!!.icon!!.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)


        mTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val tabItemColor = Color.WHITE
                tab.icon!!.setColorFilter(tabItemColor, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val tabItemColor = ContextCompat.getColor(context!!, R.color.colorYouTubeDark)
                tab.icon!!.setColorFilter(tabItemColor, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                d(TAG, "onTabReselected")
            }
        })


    }

    companion object {
        private val TAG = MainFragment::class.java.simpleName

        fun newInstance(): MainFragment {

            val args = Bundle()

            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
