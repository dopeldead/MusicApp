package iti.musicapp.models
import java.time.LocalDateTime

class User(val artistsDb: Set<Artist>) {
    private var favoriteArtists = mutableListOf<Artist>()
    private var styles = mutableMapOf<Style,LocalDateTime>()

    fun AddFavorite(artist: Artist){
        if(artist !in favoriteArtists){
            favoriteArtists.add(artist)
            for (s in artist.styles) {
                if (s !in styles.keys) styles.put(s, LocalDateTime.now())
            }
        }
    }
    fun AddFavorite(artistName: String){
        val artist = artistsDb.find { it.name==artistName }
        if(artist == null) throw Exception("The artist name should Exist")
        AddFavorite(artist)
    }
    fun getSuggestions(): List<Artist>{
        /*- retreive Styles (keys) from the style dictionnary
          - create tuples (Pairs) from <Style, Count of artist from favorites having that style>
          - Sort by number of time this style is in favorite artists (descending) then by date of first add in favorites
          - take the 2 firsts
          - splitting Pairs to <Key,Value> of type <Style,Count>
          - keep only the Styles(Keys)
         */


        val preferedStyles =  styles.keys
                .map {Pair(it,favoriteArtists.count { a -> a.styles.contains(it) }) }
                .sortedWith(
                        compareByDescending<Pair<Style,Int>>{ it.second }
                                .thenBy { styles[it.first] }
                )
                .take(2).toMap().keys

        return artistsDb.filter { a-> a.styles.intersect(preferedStyles).count()!=0 }.filter { it !in favoriteArtists }
    }
}
