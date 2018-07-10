package iti.musicapp.models
import java.time.LocalDateTime

class User() {
    var artists= mapOf<Artist,LocalDateTime>()

    fun AddFavorite(artist: Artist){
        artists.add(artist, LocalDateTime.now())
    }
    fun RemoveFavorite(artist: Artist){
        artists.remove(artist)
    }
    fun getSuggestions(collection: AbstractCollection<Artist>): Set<Artist>{

        val preferedStyles = artists.groupingBy { it.style }
                                    .eachCount()
                                    .toList()
                                    .sortedBy { (_, value ) -> value}
                                    .toMap()
                                    .keys.take(2)

        val occurences =  collection.filter { a-> a.style in preferedStyles}.filter { it !in artists }
    }
}
