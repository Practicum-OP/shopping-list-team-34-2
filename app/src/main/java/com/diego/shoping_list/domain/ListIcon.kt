package com.diego.shoping_list.domain

enum class ListIcon(val key: String) {
    ICON_0("icon_0"),
    ICON_1("icon_1"),
    ICON_2("icon_2"),
    ICON_3("icon_3"),
    ICON_4("icon_4"),
    ICON_5("icon_5"),
    ICON_6("icon_6"),
    ICON_7("icon_7"),
    ICON_8("icon_8"),
    ICON_9("icon_9"),
    ICON_10("icon_10"),
    ICON_11("icon_11"),
    ICON_12("icon_12"),
    ICON_13("icon_13"),
    ICON_14("icon_14"),
    ICON_15("icon_15"),
    ICON_16("icon_16"),
    ICON_17("icon_17"),
    ICON_18("icon_18"),
    ICON_19("icon_19"),
    ICON_20("icon_20"),
    ICON_21("icon_21"),
    ICON_22("icon_22"),
    ICON_23("icon_23"),
    ICON_24("icon_24"),
    ICON_25("icon_25"),
    ICON_26("icon_26"),
    ICON_27("icon_27"),
    ICON_28("icon_28"),
    ICON_29("icon_29");

    companion object {
        fun fromKey(key: String): ListIcon =
            entries.firstOrNull { it.key == key } ?: ICON_0

        val default: ListIcon = ICON_0
    }
}