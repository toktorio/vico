package pl.patrykgoworowski.liftchart_common.extension

inline val Int.half: Int
    get() = this / 2

inline val Float.half: Float
    get() = this / 2

inline val Number?.orZeroInt: Int
    get() = this?.toInt() ?: 0

inline val Float?.orZero: Float
    get() = this ?: 0f