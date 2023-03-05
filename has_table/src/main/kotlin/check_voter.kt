val voted = hashMapOf<String,Boolean>()

fun checkVoter(name: String){
    if(!voted.containsKey(name)){
        voted[name] = true
        println("let them vote !")
    }else{
        println("kick them out !")
    }
}

fun main(){
    checkVoter("tom")
    checkVoter("mike")
    checkVoter("mike")
}