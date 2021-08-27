package kg.geektech.kotlinhomework3

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.kotlinhomework3.databinding.ItemListBinding

class RecyclerAdapter(private var imgUrls:ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private lateinit var mClickListener: OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false),mClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(imgUrls[position])
    }

    override fun getItemCount(): Int {
          return imgUrls.size
     }
    fun setOnClicklistener(clickListener: OnClickListener){
        mClickListener = clickListener
    }

    inner class ViewHolder(itemView: View,var clickListener: OnClickListener) : RecyclerView.ViewHolder(itemView) {
        private val binding =  ItemListBinding.bind(itemView)

        fun bind(url: String) {
            binding.itemImage.load(url)
            binding.itemImage.setOnClickListener{
                clickListener.onClick(url)
                binding.itemImage.setBackgroundColor(Color.BLACK)

            }
        }
    }
    interface OnClickListener{
        fun onClick(img: String)
    }

}