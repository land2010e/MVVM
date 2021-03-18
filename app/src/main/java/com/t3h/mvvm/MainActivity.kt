package com.t3h.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.t3h.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val aodais: MutableList<AoDaiData> = mutableListOf()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initData()

        val adapter = AoDaoAdapter(aodais)
        //cach sap xep cac itemview
        binding.rc.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )
//        binding.rc.layoutManager = GridLayoutManager(this, 3)
        binding.rc.adapter = adapter
    }

    private fun initData() {
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai1,
                "Nguyen Van A",
                "How can I use a VectorDrawable with CircleImageView?"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai2,
                "Nguyen Van B",
                "Short answer: you shouldn't. Using a VectorDrawable with CircleImageView is very inefficient"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai3,
                "Nguyen Van C",
                "How can I add a selector (e.g. ripple effect) bound to a circle?"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai4,
                "Nguyen Van D",
                "There's currently no direct support for a circle bound selector but you can follow these steps to implement it yourself."
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai5,
                "Nguyen VanE",
                "Adding a gap is also not supported directly but there's a workaround."
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai7,
                "Nguyen Van F",
                "Align bitmap paint flags with BitmapDrawable (improves scaling)"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai8,
                "Nguyen Van H",
                "Fix wrong outline being provided if circular transformation is disabled"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai9,
                "Nguyen Van DDD",
                "Fix touch event not fired if view is empty Fix touchable area limited to a circle even if transformation is disabled"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai10,
                "Nguyen Van GF",
                "Limit touch event handling to circle area"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai11,
                "Nguyen Van 12",
                "Migrate to AndroidX"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai_14,
                "Remove deprecated properties and methods",
                ""
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai15,
                "elevation",
                "Add support for elevation"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai17,
                "Add circle background color attribute to replace fill color",
                "Fix hairline gap being drawn between image and border under some conditions"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai18,
                "BREAKING: Custom xml attributes are now prefixed with \"civ_\"",
                "Add support for a fill color shown behind images with transparent areas"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai20,
                "Fix dimension calculation issues with small images",
                "Fix ColorDrawables not being rendered properly on Lollipop"
            )
        )

        aodais.add(
            AoDaiData(
                R.drawable.ao_dai1,
                "Nguyen Van A",
                "How can I use a VectorDrawable with CircleImageView?"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai2,
                "Nguyen Van B",
                "Short answer: you shouldn't. Using a VectorDrawable with CircleImageView is very inefficient"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai3,
                "Nguyen Van C",
                "How can I add a selector (e.g. ripple effect) bound to a circle?"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai4,
                "Nguyen Van D",
                "There's currently no direct support for a circle bound selector but you can follow these steps to implement it yourself."
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai5,
                "Nguyen VanE",
                "Adding a gap is also not supported directly but there's a workaround."
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai7,
                "Nguyen Van F",
                "Align bitmap paint flags with BitmapDrawable (improves scaling)"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai8,
                "Nguyen Van H",
                "Fix wrong outline being provided if circular transformation is disabled"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai9,
                "Nguyen Van DDD",
                "Fix touch event not fired if view is empty Fix touchable area limited to a circle even if transformation is disabled"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai10,
                "Nguyen Van GF",
                "Limit touch event handling to circle area"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai11,
                "Nguyen Van 12",
                "Migrate to AndroidX"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai_14,
                "Remove deprecated properties and methods",
                ""
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai15,
                "elevation",
                "Add support for elevation"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai17,
                "Add circle background color attribute to replace fill color",
                "Fix hairline gap being drawn between image and border under some conditions"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai18,
                "BREAKING: Custom xml attributes are now prefixed with \"civ_\"",
                "Add support for a fill color shown behind images with transparent areas"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai20,
                "Fix dimension calculation issues with small images",
                "Fix ColorDrawables not being rendered properly on Lollipop"
            )
        )

        aodais.add(
            AoDaiData(
                R.drawable.ao_dai1,
                "Nguyen Van A",
                "How can I use a VectorDrawable with CircleImageView?"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai2,
                "Nguyen Van B",
                "Short answer: you shouldn't. Using a VectorDrawable with CircleImageView is very inefficient"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai3,
                "Nguyen Van C",
                "How can I add a selector (e.g. ripple effect) bound to a circle?"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai4,
                "Nguyen Van D",
                "There's currently no direct support for a circle bound selector but you can follow these steps to implement it yourself."
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai5,
                "Nguyen VanE",
                "Adding a gap is also not supported directly but there's a workaround."
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai7,
                "Nguyen Van F",
                "Align bitmap paint flags with BitmapDrawable (improves scaling)"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai8,
                "Nguyen Van H",
                "Fix wrong outline being provided if circular transformation is disabled"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai9,
                "Nguyen Van DDD",
                "Fix touch event not fired if view is empty Fix touchable area limited to a circle even if transformation is disabled"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai10,
                "Nguyen Van GF",
                "Limit touch event handling to circle area"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai11,
                "Nguyen Van 12",
                "Migrate to AndroidX"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai_14,
                "Remove deprecated properties and methods",
                ""
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai15,
                "elevation",
                "Add support for elevation"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai17,
                "Add circle background color attribute to replace fill color",
                "Fix hairline gap being drawn between image and border under some conditions"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai18,
                "BREAKING: Custom xml attributes are now prefixed with \"civ_\"",
                "Add support for a fill color shown behind images with transparent areas"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai20,
                "Fix dimension calculation issues with small images",
                "Fix ColorDrawables not being rendered properly on Lollipop"
            )
        )

        aodais.add(
            AoDaiData(
                R.drawable.ao_dai1,
                "Nguyen Van A",
                "How can I use a VectorDrawable with CircleImageView?"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai2,
                "Nguyen Van B",
                "Short answer: you shouldn't. Using a VectorDrawable with CircleImageView is very inefficient"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai3,
                "Nguyen Van C",
                "How can I add a selector (e.g. ripple effect) bound to a circle?"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai4,
                "Nguyen Van D",
                "There's currently no direct support for a circle bound selector but you can follow these steps to implement it yourself."
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai5,
                "Nguyen VanE",
                "Adding a gap is also not supported directly but there's a workaround."
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai7,
                "Nguyen Van F",
                "Align bitmap paint flags with BitmapDrawable (improves scaling)"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai8,
                "Nguyen Van H",
                "Fix wrong outline being provided if circular transformation is disabled"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai9,
                "Nguyen Van DDD",
                "Fix touch event not fired if view is empty Fix touchable area limited to a circle even if transformation is disabled"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai10,
                "Nguyen Van GF",
                "Limit touch event handling to circle area"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai11,
                "Nguyen Van 12",
                "Migrate to AndroidX"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai_14,
                "Remove deprecated properties and methods",
                ""
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai15,
                "elevation",
                "Add support for elevation"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai17,
                "Add circle background color attribute to replace fill color",
                "Fix hairline gap being drawn between image and border under some conditions"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai18,
                "BREAKING: Custom xml attributes are now prefixed with \"civ_\"",
                "Add support for a fill color shown behind images with transparent areas"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai20,
                "Fix dimension calculation issues with small images",
                "Fix ColorDrawables not being rendered properly on Lollipop"
            )
        )

        aodais.add(
            AoDaiData(
                R.drawable.ao_dai1,
                "Nguyen Van A",
                "How can I use a VectorDrawable with CircleImageView?"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai2,
                "Nguyen Van B",
                "Short answer: you shouldn't. Using a VectorDrawable with CircleImageView is very inefficient"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai3,
                "Nguyen Van C",
                "How can I add a selector (e.g. ripple effect) bound to a circle?"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai4,
                "Nguyen Van D",
                "There's currently no direct support for a circle bound selector but you can follow these steps to implement it yourself."
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai5,
                "Nguyen VanE",
                "Adding a gap is also not supported directly but there's a workaround."
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai7,
                "Nguyen Van F",
                "Align bitmap paint flags with BitmapDrawable (improves scaling)"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai8,
                "Nguyen Van H",
                "Fix wrong outline being provided if circular transformation is disabled"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai9,
                "Nguyen Van DDD",
                "Fix touch event not fired if view is empty Fix touchable area limited to a circle even if transformation is disabled"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai10,
                "Nguyen Van GF",
                "Limit touch event handling to circle area"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai11,
                "Nguyen Van 12",
                "Migrate to AndroidX"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai_14,
                "Remove deprecated properties and methods",
                ""
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai15,
                "elevation",
                "Add support for elevation"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai17,
                "Add circle background color attribute to replace fill color",
                "Fix hairline gap being drawn between image and border under some conditions"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai18,
                "BREAKING: Custom xml attributes are now prefixed with \"civ_\"",
                "Add support for a fill color shown behind images with transparent areas"
            )
        )
        aodais.add(
            AoDaiData(
                R.drawable.ao_dai20,
                "Fix dimension calculation issues with small images",
                "Fix ColorDrawables not being rendered properly on Lollipop"
            )
        )
    }


}