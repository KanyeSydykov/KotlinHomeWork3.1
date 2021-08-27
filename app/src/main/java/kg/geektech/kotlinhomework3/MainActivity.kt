package kg.geektech.kotlinhomework3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import kg.geektech.kotlinhomework3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adrecyclerAdapterpter: RecyclerAdapter? = null
    private var listImage = arrayListOf<String>()
    private var list = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addImage()

        adrecyclerAdapterpter = RecyclerAdapter(listImage)

        binding.rvActivityMain.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter = adrecyclerAdapterpter
        }
        adrecyclerAdapterpter?.setOnClicklistener(object : RecyclerAdapter.OnClickListener{
            override fun onClick(img: String) {
                list.add(img)
            }

        })

    }

    private fun addImage() {
        listImage = arrayListOf(
            "https://picsum.photos/id/100/367/267",
            "https://picsum.photos/id/1010/367/267",
            "https://picsum.photos/id/1020/367/267",
            "https://picsum.photos/id/1024/367/267",
            "https://picsum.photos/id/1025/367/267",
            "https://picsum.photos/id/1027/367/267",
            "https://picsum.photos/id/1045/367/267",
            "https://picsum.photos/id/1052/367/267",
            "https://picsum.photos/id/1054/367/267",
            "https://picsum.photos/id/1069/367/267",
            "https://picsum.photos/id/1074/367/267",
            "https://picsum.photos/id/1080/367/267",
            "https://picsum.photos/id/1082/367/267",
            "https://picsum.photos/id/1081/367/267",
            "https://picsum.photos/id/110/367/267",
            "https://picsum.photos/id/137/367/267",
            "https://picsum.photos/id/15/367/267",
            "https://picsum.photos/id/169/367/267"
        )

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu -> openAnotherActivity()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openAnotherActivity() {
        val intent = Intent(this, SecondActivity::class.java).apply {
            putStringArrayListExtra(KEY_RES, list)
        }
        startActivity(intent)
    }

    companion object{
     const val KEY_RES = "res"
    }

}