package pavelpoley.advancedrecycleview.adapters

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.horizontal_feed_layout.view.*
import pavelpoley.advancedrecycleview.R
import pavelpoley.advancedrecycleview.model.FeedModel

class FeedAdapter(frag: FragmentActivity, list: ArrayList<FeedModel>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_MAIN_FEED_LAYOUT = 3
    private val TYPE_AD_LAYOUT = 4
    private val TYPE_VERTICAL_FEED_LAYOUT = 5

    private var mContext: Context = frag.applicationContext
    private var mList = ArrayList<FeedModel>()


    init {
        mList.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_VERTICAL_FEED_LAYOUT) {

            val horizontalFeed = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_feed_layout, parent, false)
            return ViewHolder(horizontalFeed)

        } else if (viewType == TYPE_AD_LAYOUT) {

            val adView = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_ad, parent, false)
            return ViewHolder(adView)

        } else {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed, parent, false)
            return ViewHolder(view)
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (position == 0) {
            holder.itemView.rv_horizontal.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
            holder.itemView.rv_horizontal.adapter = HorizontalListAdapter(mList)
        }
    }


    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return TYPE_VERTICAL_FEED_LAYOUT
        } else if (isAdPosition(position))
            return TYPE_AD_LAYOUT;
        else
            return TYPE_MAIN_FEED_LAYOUT
    }


    private fun isAdPosition(pos: Int): Boolean {

        if (pos == 0)
            return false
        else
            return pos % 7 == 0
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }
}