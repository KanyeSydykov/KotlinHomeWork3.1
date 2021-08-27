package kg.geektech.kotlinhomework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kg.geektech.kotlinhomework3.MainActivity.Companion.KEY_RES
import kg.geektech.kotlinhomework3.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private var recyclerAdapter: RecyclerAdapter? = null
    private lateinit var binding: ActivitySecondBinding
    private var list = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item: ArrayList<String>? = intent.getStringArrayListExtra(KEY_RES)

        if (item != null) {
            list = item
        }

        recyclerAdapter = RecyclerAdapter(list)

        binding.rvActivitySecond.apply {
            layoutManager = GridLayoutManager(this@SecondActivity, 3)
            adapter = recyclerAdapter

        }
        recyclerAdapter?.setOnClicklistener(object : RecyclerAdapter.OnClickListener{
            override fun onClick(img: String) {

            }

        })

    }

}