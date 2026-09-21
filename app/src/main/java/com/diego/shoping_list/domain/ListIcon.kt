package com.diego.shoping_list.domain

import androidx.annotation.DrawableRes
import com.diego.shoping_list.R

enum class ListIcon(
    val key: String,
    @DrawableRes val resId: Int
) {
    ICON_0("icon_0", R.drawable.icon_0),
    ICON_1("icon_1", R.drawable.icon_1),
    ICON_2("icon_2", R.drawable.icon_2),
    ICON_3("icon_3", R.drawable.icon_3),
    ICON_4("icon_4", R.drawable.icon_4),
    ICON_5("icon_5", R.drawable.icon_5),
    ICON_6("icon_6", R.drawable.icon_6),
    ICON_7("icon_7", R.drawable.icon_7),
    ICON_8("icon_8", R.drawable.icon_8),
    ICON_9("icon_9", R.drawable.icon_9),
    ICON_10("icon_10", R.drawable.icon_10),
    ICON_11("icon_11", R.drawable.icon_11),
    ICON_12("icon_12", R.drawable.icon_12),
    ICON_13("icon_13", R.drawable.icon_13),
    ICON_14("icon_14", R.drawable.icon_14),
    ICON_15("icon_15", R.drawable.icon_15),
    ICON_16("icon_16", R.drawable.icon_16),
    ICON_17("icon_17", R.drawable.icon_17),
    ICON_18("icon_18", R.drawable.icon_18),
    ICON_19("icon_19", R.drawable.icon_19),
    ICON_20("icon_20", R.drawable.icon_20),
    ICON_21("icon_21", R.drawable.icon_21),
    ICON_22("icon_22", R.drawable.icon_22),
    ICON_23("icon_23", R.drawable.icon_23),
    ICON_24("icon_24", R.drawable.icon_24),
    ICON_25("icon_25", R.drawable.icon_25),
    ICON_26("icon_26", R.drawable.icon_26),
    ICON_27("icon_27", R.drawable.icon_27),
    ICON_28("icon_28", R.drawable.icon_28),
    ICON_29("icon_29", R.drawable.icon_29);

    companion object {
        fun fromKey(key: String): ListIcon =
            entries.firstOrNull { it.key == key } ?: ICON_0

        val default: ListIcon = ICON_0
    }
}