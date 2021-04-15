package com.t3h.mvvm.ui.test.asyntask

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.t3h.mvvm.R
import com.t3h.mvvm.databinding.ActivityAsyntaskBinding
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import java.util.concurrent.Executors

class AsyntaskActivity : AppCompatActivity(), View.OnClickListener, TruyenCuoiAdapter.ITruyenCuoi {
    private lateinit var binding: ActivityAsyntaskBinding
    private val truyenCuois = mutableListOf<TruyenCuoiData>()
    private var currentPage = 1
    private val exs = Executors.newFixedThreadPool(3)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_asyntask
        )
        binding.btnStart.setOnClickListener(this)
        binding.btnMore.setOnClickListener(this)
        binding.rc.layoutManager = GridLayoutManager(this, 2)
        binding.rc.adapter = TruyenCuoiAdapter(this)
        loadDataAsyn("https://truyencotich.vn/truyen-co-tich/co-tich-viet-nam")
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_more->{
                currentPage++
                loadDataAsyn("https://truyencotich.vn/truyen-co-tich/co-tich-viet-nam/page/$currentPage")
            }
        }
//        createAsyn()
    }

    private fun createAsyn() {
        val asyn = @SuppressLint("StaticFieldLeak")
        object : AsyncTask<Int, String, String>() {
            override fun doInBackground(vararg params: Int?): String {
                for (i in params[0]!!..params[1]!!) {
//                    binding.tvNumber.setText(i.toString())
                    publishProgress(i.toString())
                    SystemClock.sleep(1000)
                }
                return "Finish"
            }

            override fun onProgressUpdate(vararg values: String) {
                binding.tvNumber.setText(values[0])
            }

            override fun onPostExecute(result: String) {
                binding.tvNumber.setText(result)
            }
        }
        asyn.executeOnExecutor(
            exs,
            0, 10
        )
    }

    private fun loadDataAsyn(link: String) {
        binding.rl.visibility = View.VISIBLE
        val asyn = object : AsyncTask<String, Void, MutableList<TruyenCuoiData>>() {
            override fun doInBackground(vararg params: String): MutableList<TruyenCuoiData> {
                return loadDataTruyenCuoi(params[0])
            }

            override fun onPostExecute(result: MutableList<TruyenCuoiData>) {
                binding.rl.visibility = View.GONE
                if (result.size == 0) {
                    return
                }
                truyenCuois.addAll(result)
                binding.rc.adapter!!.notifyDataSetChanged()
                binding.rc.smoothScrollToPosition(
                    truyenCuois.size - result.size
                )
            }
        }
        asyn.execute(link)
    }

    private fun loadDataTruyenCuoi(link: String): MutableList<TruyenCuoiData> {
        val doc = Jsoup.connect(link).get()
        val els: Elements = doc.select("div.clear")
        val mainEle = els.get(4)
        val truyenCuoisData = mutableListOf<TruyenCuoiData>()
        for (element in mainEle.select("article.entry-grid")) {
            val imageLink = element.selectFirst("img").attr("src")
            val title = element.selectFirst("h2.entry-title").text()
            val htmlLink = element.selectFirst("h2.entry-title")
                .selectFirst("a").attr("href")
            val content = element.selectFirst("p.post-excerpt").text()

            truyenCuoisData.add(
                TruyenCuoiData(title, content, htmlLink, imageLink)
            )
            Log.d("AsyntaskActivity", "loadDataTruyenCuoi imageLink: " + imageLink)
            Log.d("AsyntaskActivity", "loadDataTruyenCuoi title: " + title)
            Log.d("AsyntaskActivity", "loadDataTruyenCuoi htmlLink: " + htmlLink)
            Log.d("AsyntaskActivity", "loadDataTruyenCuoi content: " + content)
            Log.d("AsyntaskActivity", "===================================")
        }
        return truyenCuoisData

    }

    override fun getCount()=truyenCuois.size

    override fun getData(position: Int)=truyenCuois[position]

    override fun onItemClick(position: Int) {
        Toast.makeText(this, truyenCuois[position].title,
        Toast.LENGTH_SHORT)
    }
}