/*
Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?
 */

fun main(args: Array<String>) {
    var display = {word: String -> println(String.format("%s is unique: %s",word,solution1(word)))}
    display("hey")
    display("heyy")
}

/* hashtable */ 
// cons - collision risks
// O(n) - single pass - each look up is O(1)

fun solution1(word: String): Boolean{
    var ht = mutableSetOf<Char>()
    for (c in word) {
        if(ht.contains(c)){
            return false
        }
        ht.add(c)
    }
    return true
}
/* bit vector or bit map - need to know size of character set */
// cons - unnecessary space reservation