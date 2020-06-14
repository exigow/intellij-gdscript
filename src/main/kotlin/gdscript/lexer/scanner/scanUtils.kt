package gdscript.lexer.scanner


internal fun scanChar(chars: CharSequence, start: Int, expected: Char): Int {
    if (start < chars.length && chars[start] == expected)
        return start + 1
    return start
}

internal fun scanWhile(chars: CharSequence, start: Int, accepts: (Char) -> Boolean): Int {
    var current = start
    while (current < chars.length && accepts(chars[current]))
        current += 1
    return current
}

internal fun scanUntil(chars: CharSequence, start: Int, terminates: (Char) -> Boolean): Int =
    scanWhile(chars, start) { !terminates(it) }
