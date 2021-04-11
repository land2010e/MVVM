package com.t3h.mvvm.fragment.store

import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.t3h.mvvm.BaseFragment
import com.t3h.mvvm.databinding.FragmentExternalStoreBinding
import java.io.File

class ExternalStoreFragment : BaseFragment(), ExternalStoreAdapter.IExternalStore {
    private val folders = mutableListOf<FolderInfo>()
    private var binding: FragmentExternalStoreBinding? = null
    private var currentPath = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loadPath(
            Environment.getExternalStorageDirectory().path
        )
        binding = FragmentExternalStoreBinding.inflate(
            inflater, container, false
        )
        binding!!.rc.layoutManager = LinearLayoutManager(context)
        binding!!.rc.adapter = ExternalStoreAdapter(this)
        return binding!!.root
    }

    //lay cac thu muc con/file con trong path
    private fun loadPath(path: String) {
        folders.clear()
        currentPath = path
        val f = File(path)
        val fs = f.listFiles()
        if (fs == null) {
            return
        }
        for (childPath in fs) {
            folders.add(
                FolderInfo(
                    childPath.name,
                    childPath.path,
                    childPath.isFile
                )
            )
        }
    }

    override fun getCount() = folders.size

    override fun getData(position: Int) = folders[position]

    override fun onClickItem(position: Int) {
        if (!getData(position).isFile) {
            loadPath(getData(position).path)
            binding!!.rc.adapter!!.notifyDataSetChanged()
        }
    }

    override fun onBackPress() {
        if (currentPath.equals(
                Environment.getExternalStorageDirectory().path
            )
        ) {
            super.onBackPress()
        } else {
            loadPath(
                File(currentPath).parent!!
            )
            binding!!.rc.adapter!!.notifyDataSetChanged()
        }

    }
}