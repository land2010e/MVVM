package com.t3h.mvvm.ui.test.viewpager

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.t3h.mvvm.ui.test.asyntask.TruyenCuoiAdapter
import com.t3h.mvvm.ui.test.asyntask.TruyenCuoiData
import com.t3h.mvvm.databinding.FragmentListStoreBinding
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import java.util.concurrent.Executors

class ListStoreFragment:Fragment(), TruyenCuoiAdapter.ITruyenCuoi{
    private var binding:FragmentListStoreBinding?=null
    private val truyenCuois = mutableListOf<TruyenCuoiData>()
    private var currentPage = 1
    private val exs = Executors.newFixedThreadPool(3)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentListStoreBinding.inflate(
            inflater, container, false
        )
        binding!!.rc.layoutManager = GridLayoutManager(context, 2)
        binding!!.rc.adapter = TruyenCuoiAdapter(this)
        loadDataAsyn(
            arguments!!.getString("URL")!!
        )
        return binding!!.root
    }

    private fun loadDataAsyn(link: String) {

        val asyn = object : AsyncTask<String, Void, MutableList<TruyenCuoiData>>() {
            override fun doInBackground(vararg params: String): MutableList<TruyenCuoiData> {
                return loadDataTruyenCuoi(params[0])
            }

            override fun onPostExecute(result: MutableList<TruyenCuoiData>) {
                if (result.size == 0) {
                    return
                }
                truyenCuois.addAll(result)
                binding!!.rc.adapter!!.notifyDataSetChanged()
//                binding!!.rc.smoothScrollToPosition(
//                    truyenCuois.size - result.size
//                )
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
        Toast.makeText(context, truyenCuois[position].title,
            Toast.LENGTH_SHORT)
    }


}