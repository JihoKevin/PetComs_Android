package kevin.android.petcoms.fragments.diary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import kevin.android.petcoms.R
import kevin.android.petcoms.models.record.DiaryNewlyFeedModel

class NewlyFeedAdapter(val lists: ArrayList<DiaryNewlyFeedModel>) : RecyclerView.Adapter<NewlyFeedAdapter.NewlyFeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewlyFeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.record_recycler_layout, parent, false)
        return NewlyFeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewlyFeedViewHolder, position: Int) {
        holder.progImg.setImageResource(lists.get(position).profImg)
        holder.time.text = lists.get(position).time
        holder.nickname.text = lists.get(position).nickName
        holder.date.text = lists.get(position).date
        holder.location.text = lists.get(position).location
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    class NewlyFeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val progImg = itemView.findViewById<CircleImageView>(R.id.imgRecordProfile)
        val nickname = itemView.findViewById<TextView>(R.id.txtNickName)
        val time = itemView.findViewById<TextView>(R.id.txtTime)
        val date = itemView.findViewById<TextView>(R.id.txtDay)
        val location = itemView.findViewById<TextView>(R.id.txtLocation)
    }
}