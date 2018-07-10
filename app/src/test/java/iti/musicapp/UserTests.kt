package iti.musicapp

import iti.musicapp.models.Artist
import iti.musicapp.models.Style
import iti.musicapp.models.User
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UserTests {

    @Test
    fun suggest_artist_to_user(){

        val artistList = InitializeArtistsList()
        val user = User(artistList.toSet())

        user.AddFavorite("Metallica")
        user.AddFavorite("Duke Ellington")

        var userSuggestion = user.getSuggestions()

        assertEquals(5, userSuggestion.count());
    }
    @Test
    fun suggest_artist_to_user_2(){

        val artistList = InitializeArtistsList()
        val user = User(artistList.toSet())

        user.AddFavorite("Metallica")
        user.AddFavorite("Rammstein")
        user.AddFavorite("Tupac")
        user.AddFavorite("Miles Davis")
        user.AddFavorite("Duke Ellington")

        var userSuggestion = user.getSuggestions()

        assertEquals(3, userSuggestion.count());
        assertEquals(userSuggestion.filter { it.styles.contains(Style.RAP) }.count(),0)
    }

    fun InitializeArtistsList(): MutableList<Artist>{
        return mutableListOf<Artist>(
                Artist("Metallica", mutableSetOf(Style.METAL)),
                Artist("Rammstein", mutableSetOf(Style.METAL)),
                Artist("Iron Maiden", mutableSetOf(Style.METAL)),
                Artist("Miles Davis", mutableSetOf(Style.JAZZ)),
                Artist("Duke Ellington", mutableSetOf(Style.JAZZ)),
                Artist("John Colltrane", mutableSetOf(Style.JAZZ)),
                Artist("Billie Holliday", mutableSetOf(Style.JAZZ)),
                Artist("Tupac", mutableSetOf(Style.RAP)),
                Artist("Cypress Hill", mutableSetOf(Style.RAP)),
                Artist("Pusha T", mutableSetOf(Style.RAP))
        )
    }
}
