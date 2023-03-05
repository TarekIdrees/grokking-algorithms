val cache = hashMapOf<String,String>()

fun getDataFromServer(url: String): String{
    return when(url){
        "www.facebook.com" -> "127.168.1.1"
        "www.google.com" -> "145.11.2.2"
        else -> "not found!"
    }
}
fun getPage(url: String): String{
    return if(cache.containsKey(url)){
        println("Found !")
        cache[url]!!
    }
    else{
        println("request from server")
        val data = getDataFromServer(url)
        cache[url] = data
        data
    }
}

fun main(){
    println(getPage("www.facebook.com"))
    println(getPage("www.google.com"))

    println(getPage("www.facebook.com"))

    println(getPage("www.fakepage.com"))

}