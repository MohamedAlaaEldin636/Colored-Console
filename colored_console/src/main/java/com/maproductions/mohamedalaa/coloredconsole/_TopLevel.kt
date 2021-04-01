@file:Suppress("unused")
@file:JvmName("Console")

package com.maproductions.mohamedalaa.coloredconsole

private const val DEFAULT_STACKTRACE_LIMIT = 10

private const val FULL_CLASS_NAME = "com.maproductions.mohamedalaa.coloredconsole.Console"

/**
 * @param stacktraceLimit the limit of the referenced occurrences of code, if the stacktrace is
 * more than the limit then the limit will be divided by 2 and the start and end of stacktrace will
 * be used isa.
 */
@JvmName("print")
fun consolePrint(msg: Any?, markup: String = ConsoleLog.reset, stacktraceLimit: Int = DEFAULT_STACKTRACE_LIMIT) = coloredPrint(markup, msg.toString(), MsgType.CUSTOM, false, stacktraceLimit)
@JvmName("printLn")
fun consolePrintLn(msg: Any?, markup: String = ConsoleLog.reset, stacktraceLimit: Int = DEFAULT_STACKTRACE_LIMIT) = coloredPrint(markup, msg.toString(), MsgType.CUSTOM, true, stacktraceLimit)

@JvmName("verbose")
fun consoleVerbose(msg: Any?, stacktraceLimit: Int = DEFAULT_STACKTRACE_LIMIT) = coloredPrint(ConsoleLog.reset + ConsoleLog.green, msg.toString(), MsgType.VERBOSE, false, stacktraceLimit)
@JvmName("verboseLn")
fun consoleVerboseLn(msg: Any?, stacktraceLimit: Int = DEFAULT_STACKTRACE_LIMIT) = coloredPrint(ConsoleLog.reset + ConsoleLog.green, msg.toString(), MsgType.VERBOSE, true, stacktraceLimit)

@JvmName("debug")
fun consoleDebug(msg: Any?, stacktraceLimit: Int = DEFAULT_STACKTRACE_LIMIT) = coloredPrint(ConsoleLog.reset + ConsoleLog.magenta, msg.toString(), MsgType.DEBUG, false, stacktraceLimit)
@JvmName("debugLn")
fun consoleDebugLn(msg: Any?, stacktraceLimit: Int = DEFAULT_STACKTRACE_LIMIT) = coloredPrint(ConsoleLog.reset + ConsoleLog.magenta, msg.toString(), MsgType.DEBUG, true, stacktraceLimit)

@JvmName("info")
fun consoleInfo(msg: Any?, stacktraceLimit: Int = DEFAULT_STACKTRACE_LIMIT) = coloredPrint(ConsoleLog.reset + ConsoleLog.brightYellow, msg.toString(), MsgType.INFO, false, stacktraceLimit)
@JvmName("infoLn")
fun consoleInfoLn(msg: Any?, stacktraceLimit: Int = DEFAULT_STACKTRACE_LIMIT) = coloredPrint(ConsoleLog.reset + ConsoleLog.brightYellow, msg.toString(), MsgType.INFO, true, stacktraceLimit)

@JvmName("warn")
fun consoleWarn(msg: Any?, stacktraceLimit: Int = DEFAULT_STACKTRACE_LIMIT) = coloredPrint(ConsoleLog.reset + ConsoleLog.cyan, msg.toString(), MsgType.WARN, false, stacktraceLimit)
@JvmName("warnLn")
fun consoleWarnLn(msg: Any?, stacktraceLimit: Int = DEFAULT_STACKTRACE_LIMIT) = coloredPrint(ConsoleLog.reset + ConsoleLog.cyan, msg.toString(), MsgType.WARN, true, stacktraceLimit)

@JvmName("error")
fun consoleError(msg: Any?, stacktraceLimit: Int = DEFAULT_STACKTRACE_LIMIT) = coloredPrint(ConsoleLog.reset + ConsoleLog.red, msg.toString(), MsgType.ERROR, false, stacktraceLimit)
@JvmName("errorLn")
fun consoleErrorLn(msg: Any?, stacktraceLimit: Int = DEFAULT_STACKTRACE_LIMIT) = coloredPrint(ConsoleLog.reset + ConsoleLog.red, msg.toString(), MsgType.ERROR, true, stacktraceLimit)

@JvmName("wtf")
fun consoleWTF(msg: Any?, stacktraceLimit: Int = DEFAULT_STACKTRACE_LIMIT) = coloredPrint(ConsoleLog.reset + ConsoleLog.backgroundRed + ConsoleLog.black, msg.toString(), MsgType.WTF, false, stacktraceLimit)
@JvmName("wtfLn")
fun consoleWTFLn(msg: Any?, stacktraceLimit: Int = DEFAULT_STACKTRACE_LIMIT) = coloredPrint(ConsoleLog.reset + ConsoleLog.backgroundRed + ConsoleLog.black, msg.toString(), MsgType.WTF, true, stacktraceLimit)

private fun coloredPrint(
    consoleStyle: String,
    msg: String?,
    msgType: MsgType,
    linePrint : Boolean,
    stacktraceLimit: Int = 10
) {
    val start = when (msgType) {
        MsgType.VERBOSE -> "Verbose"
        MsgType.DEBUG -> "Debug"
        MsgType.INFO -> "Info"
        MsgType.WARN -> "Warn"
        MsgType.ERROR -> "Error"
        MsgType.WTF -> "WTF"
        MsgType.CUSTOM -> "Custom"
    }

    var list = Thread.currentThread().stackTrace.toList()

    var startIndex = list.indexOfFirst { it.className == FULL_CLASS_NAME }

    val value = if (startIndex == -1) {
        "$consoleStyle$start : at UNKNOWN\n\t$msg"
    }else {
        do {
            startIndex++
        }while (list[startIndex].className == FULL_CLASS_NAME)

        list = list.drop(startIndex)

        when {
            stacktraceLimit == 0 -> "$consoleStyle$start :\n\t$msg"
            stacktraceLimit == 1 -> "$consoleStyle$start : ${list.firstOrNull()?.let { "at $it" } ?: ""}\n\t$msg"
            stacktraceLimit < list.size -> {
                val halfFloor = stacktraceLimit / 2

                val subListStart = list.take(halfFloor)
                val subListEnd = list.takeLast(stacktraceLimit - halfFloor)

                val prefix = "$consoleStyle$start : "
                val postfix = "\n\t$msg"

                prefix + subListStart.joinToString("\n") { "at $it" } + "\n...\n" +
                    subListEnd.joinToString("\n") { "at $it" } + postfix
            }
            else -> {
                list.joinToString(
                    separator = "\n",
                    prefix = "$consoleStyle$start : ",
                    postfix = "\n\t$msg"
                ) {
                    "at $it"
                }
            }
        }
    }

    if (linePrint) println(value) else print(value)
}

private enum class MsgType {
    VERBOSE, DEBUG, INFO, WARN, ERROR, WTF, CUSTOM
}

// todo
//  - add optional param to state stacktrace needed to how many default to 1 in case wanna know where it called from isa.
//  - minimized console block isa.
//  - add kdocs
