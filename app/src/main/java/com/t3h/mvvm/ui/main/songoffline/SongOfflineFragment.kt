package com.t3h.mvvm.ui.main.songoffline

import android.content.ContentUris
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.t3h.mvvm.databinding.FragmentMusicOfflineBinding
import com.t3h.mvvm.model.songofffline.SongOffline
import com.t3h.mvvm.ui.base.BaseFragment
import java.util.*

class SongOfflineFragment : BaseFragment(), SongOfflineAdapter.ISongOffline {
    private val musicOfflines = mutableListOf<SongOffline>()
    private var binding: FragmentMusicOfflineBinding? = null
    private var musicMrg: MusicOfflinePlayer? = null
    private var currentPosition = -1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicOfflineBinding.inflate(
            inflater, container, false
        )
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        binding?.rc?.layoutManager = LinearLayoutManager(context)
        binding?.rc?.adapter = SongOfflineAdapter(this)
        musicMrg = MusicOfflinePlayer()
        musicMrg?.complete = {
            currentPosition = (currentPosition + 1) % getCount()
            onItemClick(currentPosition)
        }
    }

    private fun loadData() {
        val c = context!!.contentResolver.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            null, null,
            null, null
        )
        if (c == null) {
            return
        }
        c.moveToFirst()
        val indexPath = c.getColumnIndex(MediaStore.Audio.Media.DATA)
        val indexArtist = c.getColumnIndex(MediaStore.Audio.Media.ARTIST)
        val indexAb = c.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)
        val indexTitle = c.getColumnIndex(MediaStore.Audio.Media.TITLE)
        val indexDate = c.getColumnIndex(MediaStore.Audio.Media.DATE_MODIFIED)
        while (!c.isAfterLast) {
            val path = c.getString(indexPath)
            val artist = c.getString(indexArtist)
            val ab = c.getLong(indexAb)
            val title = c.getString(indexTitle)
            val date = Date(c.getLong(indexDate) * 1000)
            val uri = ContentUris.withAppendedId(
                Uri.parse("content://media/external/audio/albumart"),
                ab
            )
            musicOfflines.add(
                SongOffline(
                    title, artist, uri, date,
                    path
                )
            )
            c.moveToNext()
        }
        binding?.rc?.adapter?.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun getCount(): Int {
        return musicOfflines.size
    }

    override fun getData(position: Int): SongOffline {
        return musicOfflines[position]
    }

    override fun onItemClick(position: Int) {
        currentPosition = position
        musicMrg?.setDataSource(musicOfflines[position].path)
        musicMrg?.start()
    }
}