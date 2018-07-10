package iti.musicapp

import iti.musicapp.models.Artist
import iti.musicapp.models.Style
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UserTests {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
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
