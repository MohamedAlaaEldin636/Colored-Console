@file:Suppress("unused")
@file:JvmName("Console")

package com.maproductions.mohamedalaa.coloredconsole

@JvmName("print")
fun consolePrint(msg: Any?, markup: String = ConsoleLog.reset) = coloredPrint(markup, msg.toString(), MsgType.CUSTOM, false)
@JvmName("printLn")
fun consolePrintLn(msg: Any?, markup: String = ConsoleLog.reset) = coloredPrint(markup, msg.toString(), MsgType.CUSTOM, true)

@JvmName("verbose")
fun consoleVerbose(msg: Any?) = coloredPrint(ConsoleLog.reset + ConsoleLog.green, msg.toString(), MsgType.VERBOSE, false)
@JvmName("verboseLn")
fun consoleVerboseLn(msg: Any?) = coloredPrint(ConsoleLog.reset + ConsoleLog.green, msg.toString(), MsgType.VERBOSE, true)

@JvmName("debug")
fun consoleDebug(msg: Any?) = coloredPrint(ConsoleLog.reset + ConsoleLog.magenta, msg.toString(), MsgType.DEBUG, false)
@JvmName("debugLn")
fun consoleDebugLn(msg: Any?) = coloredPrint(ConsoleLog.reset + ConsoleLog.magenta, msg.toString(), MsgType.DEBUG, true)

@JvmName("info")
fun consoleInfo(msg: Any?) = coloredPrint(ConsoleLog.reset + ConsoleLog.brightYellow, msg.toString(), MsgType.INFO, false)
@JvmName("infoLn")
fun consoleInfoLn(msg: Any?) = coloredPrint(ConsoleLog.reset + ConsoleLog.brightYellow, msg.toString(), MsgType.INFO, true)

@JvmName("warn")
fun consoleWarn(msg: Any?) = coloredPrint(ConsoleLog.reset + ConsoleLog.cyan, msg.toString(), MsgType.WARN, false)
@JvmName("warnLn")
fun consoleWarnLn(msg: Any?) = coloredPrint(ConsoleLog.reset + ConsoleLog.cyan, msg.toString(), MsgType.WARN, true)

@JvmName("error")
fun consoleError(msg: Any?) = coloredPrint(ConsoleLog.reset + ConsoleLog.red, msg.toString(), MsgType.ERROR, false)
@JvmName("errorLn")
fun consoleErrorLn(msg: Any?) = coloredPrint(ConsoleLog.reset + ConsoleLog.red, msg.toString(), MsgType.ERROR, true)

@JvmName("wtf")
fun consoleWTF(msg: Any?) = coloredPrint(ConsoleLog.reset + ConsoleLog.backgroundRed + ConsoleLog.black, msg.toString(), MsgType.WTF, false)
@JvmName("wtfLn")
fun consoleWTFLn(msg: Any?) = coloredPrint(ConsoleLog.reset + ConsoleLog.backgroundRed + ConsoleLog.black, msg.toString(), MsgType.WTF, true)

private fun coloredPrint(consoleStyle: String, msg: String?, msgType: MsgType, linePrint : Boolean) {
    val stackTraceElement = Thread.currentThread().stackTrace[3]
    
    val start = when (msgType) {
        MsgType.VERBOSE -> "Verbose"
        MsgType.DEBUG -> "Debug"
        MsgType.INFO -> "Info"
        MsgType.WARN -> "Warn"
        MsgType.ERROR -> "Error"
        MsgType.WTF -> "WTF"
        MsgType.CUSTOM -> "Custom"
    }

    val value = "$consoleStyle$start : at $stackTraceElement\n\t$msg"
    if (linePrint) println(value) else print(value)
}

private enum class MsgType {
    VERBOSE, DEBUG, INFO, WARN, ERROR, WTF, CUSTOM
}

// todo
//  - add optional param to state stacktrace needed to how many default to 1 in case wanna know where it called from isa.
//  - minimized console block isa.
