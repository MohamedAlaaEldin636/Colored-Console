@file:Suppress("unused")

package com.maproductions.mohamedalaa.coloredconsole

object ConsoleLog {

    @JvmStatic
    fun main(args: Array<String>) {
        println(null)
        println(null)
        println("null")
    }

    const val reset = "\u001b[0m"

    //region Foreground Colors

    const val black = "\u001b[30m"

    const val red = "\u001b[31m"

    const val green = "\u001b[32m"

    const val yellow = "\u001b[33m"

    const val blue = "\u001b[34m"

    const val magenta = "\u001b[35m"

    const val cyan = "\u001b[36m"

    const val white = "\u001b[37m"

    const val brightBlack = "\u001b[30;1m"

    const val brightRed = "\u001b[31;1m"

    const val brightGreen = "\u001b[32;1m"

    const val brightYellow = "\u001b[33;1m"

    const val brightBlue = "\u001b[34;1m"

    const val brightMagenta = "\u001b[35;1m"

    const val brightCyan = "\u001b[36;1m"

    const val brightWhite = "\u001b[37;1m"

    //endregion

    //region Background Colors

    const val backgroundBlack = "\u001b[40m"

    const val backgroundRed = "\u001b[41m"

    const val backgroundGreen = "\u001b[42m"

    const val backgroundYellow = "\u001b[43m"

    const val backgroundBlue = "\u001b[44m"

    const val backgroundMagenta = "\u001b[45m"

    const val backgroundCyan = "\u001b[46m"

    const val backgroundWhite = "\u001b[47m"

    const val backgroundBrightBlack = "\u001b[40;1m"

    const val backgroundBrightRed = "\u001b[41;1m"

    const val backgroundBrightGreen = "\u001b[42;1m"

    const val backgroundBrightYellow = "\u001b[43;1m"

    const val backgroundBrightBlue = "\u001b[44;1m"

    const val backgroundBrightMagenta = "\u001b[45;1m"

    const val backgroundBrightCyan = "\u001b[46;1m"

    const val backgroundBrightWhite = "\u001b[47;1m"

    //endregion

    //region Decorations

    const val bold = "\u001b[1m"
    const val underline = "\u001b[4m"
    /** - Means exchange foreground & background colors isa. */
    const val reversed = "\u001b[7m"

    //endregion

}
