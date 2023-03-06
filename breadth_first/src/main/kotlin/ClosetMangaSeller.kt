import java.util.*

fun listAllFriends(): HashMap<String, List<String>> {
    return hashMapOf(
        "you" to listOf("bob", "alice", "claire"),
        "bob" to listOf("anuj", "peggy"),
        "alice" to listOf("peggy"),
        "claire" to listOf("thom", "jonny")
    )
}

fun checkMangaSellerName(person: String) =  person.endsWith('j')

fun getClosetMangaSeller(): String{
    val graphOfFriends = listAllFriends()
    val searchQueue: Queue<String> = LinkedList(graphOfFriends["you"]!!)
    val searchedQueue = mutableListOf<String>()

    while(searchQueue.isNotEmpty()){
        val person = searchQueue.poll()
        if(!searchedQueue.contains(person)){
            if(checkMangaSellerName(person)){
                return "Manga seller is: $person"

            }
            graphOfFriends[person]?.let { searchQueue.addAll(it) }
            searchedQueue.add(person)
        }
    }
    return "Not found!"

}

fun main(){
    print(getClosetMangaSeller())
}