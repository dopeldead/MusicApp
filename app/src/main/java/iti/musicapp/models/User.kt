package iti.musicapp.models
import java.time.LocalDateTime

class User() {

    var artists= mutableListOf<Artist>()
    private var styles = mutableMapOf<Style,LocalDateTime>()

    fun AddFavorite(artist: Artist){
        if(artist !in artists) artists.add(artist)
        for (s in artist.styles){
            if(s !in styles.keys) styles.put(s, LocalDateTime.now())
        }
    }

    fun getSuggestions(collection: AbstractCollection<Artist>): List<Artist>{

        val preferedStyles =  styles.keys
                .map {Pair(it,artists.count { a -> a.styles.contains(it) }) }
                .sortedWith(
                        compareByDescending<Pair<Style,Int>>{ it.second }
                                .thenBy { styles[it.first] }
                )
                .take(2)

        return collection.filter { a-> a.styles.intersect(preferedStyles).count()!=0 }.filter { it !in artists }
    }
}
